package br.com.Vendas.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.DAO.ProdutoDAO;
import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.domain.Produto;
import br.com.Vendas.util.JSFUtil;

@ManagedBean(name = "MBVendas")
@ViewScoped
public class VendasBean {
	private Produto produto;
	private ArrayList<Produto> itens;
	private ArrayList<Produto> itensFiltrados;
	
	private ArrayList<Produto> produtos;
	private ArrayList<Produto> produtosFiltrados;
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public ArrayList<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	
	public void setProdutosFiltrados(ArrayList<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Produto> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	public void carregarProduto() {
		
		try {
			ProdutoDAO fdao = new ProdutoDAO();
			produtos = (ArrayList<Produto>) fdao.listar();
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemError("e.getMessage()");
			e.printStackTrace();
		}
		
	}
}

package br.com.Vendas.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.Vendas.DAO.FuncionariosDAO;
import br.com.Vendas.DAO.ItensDAO;
import br.com.Vendas.DAO.ProdutoDAO;
import br.com.Vendas.DAO.VendasDAO;
import br.com.Vendas.domain.Funcionario;
import br.com.Vendas.domain.Itens;
import br.com.Vendas.domain.Produto;
import br.com.Vendas.domain.Vendas;
import br.com.Vendas.util.JSFUtil;

@ManagedBean(name = "MBVendas")
@ViewScoped
public class VendasBean {
	private Produto produto;
	private Vendas vendaCadastro;
	private List<Itens> itens;
	private List<Itens> itensFiltrados;

	private List<Produto> produtos;
	private List<Produto> produtosFiltrados;
	
	public Vendas getVendaCadastro() {
		if (vendaCadastro == null) {
			vendaCadastro = new Vendas();
			vendaCadastro.setValor_total(new BigDecimal("0.00"));
		}
		return vendaCadastro;
	}
	
	public void setVendaCadastro(Vendas vendaCadastro) {
		this.vendaCadastro = vendaCadastro;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Itens> getItens() {
		if (itens == null) {
			itens = new ArrayList<Itens>();
		}
		return itens;
	}

	public void setItens(List<Itens> itens) {
		this.itens = itens;
	}

	public List<Itens> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(List<Itens> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public void carregarProduto() {

		try {
			ProdutoDAO fdao = new ProdutoDAO();
			produtos = (List<Produto>) fdao.listar();

		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemError("e.getMessage()");
			e.printStackTrace();
		}

	}

	public void adicionar(Produto produto) {

		int posicaoEncontrada = -1;

		for (int pos = 0; pos < itens.size() && posicaoEncontrada < 0; pos++) {
			Itens itemtemp = itens.get(pos);

			if (itemtemp.getProduto().equals(produto)) {
				posicaoEncontrada = pos;
			}
		}
		Itens item = new Itens();
		item.setProduto(produto);
		
		if (posicaoEncontrada < 0) {
			
			item.setQuantidade(1);
			item.setValor_parcial(produto.getPreco());
			itens.add(item);
		}else {
			Itens itemTemporario = itens.get(posicaoEncontrada);
			item.setQuantidade(itemTemporario.getQuantidade() + 1);
			item.setValor_parcial(produto.getPreco() .multiply(new BigDecimal(item.getQuantidade())));
			itens.set(posicaoEncontrada, item);
		}
		vendaCadastro.setValor_total(vendaCadastro.getValor_total() .add(produto.getPreco()));
	}
	
	public void remover(Itens item) {
		int posicaoEncontrada = -1;

		for (int pos = 0; pos < itens.size() && posicaoEncontrada < 0; pos++) {
			Itens itemtemp = itens.get(pos);

			if (itemtemp.getProduto().equals(item.getProduto())) {
				posicaoEncontrada = pos;
			}
		}
		
		if (posicaoEncontrada > -1) {
			itens.remove(posicaoEncontrada);
			vendaCadastro.setValor_total(vendaCadastro.getValor_total() .subtract(item.getValor_parcial()));
		}
		
		
	}
	
	public void carregarDadosVenda() {
		vendaCadastro.setHorario(new Date());
		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionario funcionario = fdao.buscarPorCodigo(4L);
		vendaCadastro.setFuncionario(funcionario);
	}
	
	public void salvar() {
		try {
			
			VendasDAO vdao = new VendasDAO();
			Long codigoVenda = vdao.salvar(vendaCadastro);
			
			Vendas vendaFK = vdao.buscarPorCodigo(codigoVenda);
			
			for (Itens item : itens) {
				item.setVendas(vendaFK);
				ItensDAO itemdao = new ItensDAO();
				itemdao.salvar(item);
			}
			
			vendaCadastro = new Vendas();
			vendaCadastro.setValor_total(new BigDecimal("0.0"));
			itens = new ArrayList<Itens>();
			
			JSFUtil.adicionarMensagemSucesso("Salvo com sucesso");

		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemError("e.getMessage()");
			e.printStackTrace();
		}
	}
}

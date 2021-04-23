package br.com.Vendas.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.util.JSFUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {
	
	private Fornecedor fornecedores;
	private ArrayList<Fornecedor> itens;
	private ArrayList<Fornecedor> itensFiltrados;
	private String acao;
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public Fornecedor getFornecedores() {
		
		return fornecedores;
	}

	public void setFornecedores(Fornecedor fornecedores) {
		this.fornecedores = fornecedores;
	}

	public ArrayList<Fornecedor> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Fornecedor> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Fornecedor> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<Fornecedor> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	public void prepararPesquisa() {
		
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			itens = (ArrayList<Fornecedor>) fdao.listar();
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemError("e.getMessage()");
			e.printStackTrace();
		}
		
	}
	
	public void carregarCadastro() {

		try {
			

			if (codigo != null) {
				FornecedoresDAO fdao = new FornecedoresDAO();
				fornecedores = fdao.buscarPorCodigo(codigo);
			}else {
				fornecedores = new Fornecedor();
			}
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemError("e.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void novo() {
		fornecedores = new Fornecedor();
	}
	
	public void salvar() {
		
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.salvar(fornecedores);
			
			fornecedores = new Fornecedor();
			
			//itens = fdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor salvo com sucesso!");
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemError("e.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.excluir(fornecedores);
			
			
			JSFUtil.adicionarMensagemError("Fornecedor deletado com sucesso!");
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemError("N�o � possivel excluir um fornecedor que tenha um produto associado!");
			e.printStackTrace();
		}
	}
	
	public void editar() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.editar(fornecedores);
			
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor editado com sucesso!");
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemError("e.getMessage()");
			e.printStackTrace();
		}
	}
}

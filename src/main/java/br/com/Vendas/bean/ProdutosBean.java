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

@ManagedBean(name = "MBProdutos")
@ViewScoped
public class ProdutosBean {
	
		private Produto produto;
		private ArrayList<Produto> itens;
		private ArrayList<Produto> itensFiltrados;
		private String acao;
		private Long codigo;
		private List<Fornecedor> listaFornecedor;
		
		public List<Fornecedor> getListaFornecedor() {
			return listaFornecedor;
		}
		
		public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
			this.listaFornecedor = listaFornecedor;
		}
		
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
		
		public void prepararPesquisa() {
			
			try {
				ProdutoDAO fdao = new ProdutoDAO();
				itens = (ArrayList<Produto>) fdao.listar();
				
			} catch (RuntimeException e) {
				JSFUtil.adicionarMensagemError("e.getMessage()");
				e.printStackTrace();
			}
			
		}
		
		public void carregarCadastro() {

			try {
				

				if (codigo != null) {
					ProdutoDAO fdao = new ProdutoDAO();
					produto = fdao.buscarPorCodigo(codigo);
				}else {
					produto = new Produto();
				}
				
				FornecedoresDAO dao = new FornecedoresDAO();
				listaFornecedor = dao.listar();
				
			} catch (RuntimeException e) {
				JSFUtil.adicionarMensagemError("e.getMessage()");
				e.printStackTrace();
			}
		}
		
		public void novo() {
			produto = new Produto();
		}
		
		public void salvar() {
			
			try {
				ProdutoDAO fdao = new ProdutoDAO();
				fdao.salvar(produto);
				
				produto = new Produto();
				
				
				JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso!");
				
			} catch (RuntimeException e) {
				JSFUtil.adicionarMensagemError("e.getMessage()");
				e.printStackTrace();
			}
		}
		
		public void excluir() {
			
			try {
				ProdutoDAO fdao = new ProdutoDAO();
				fdao.excluir(produto);
				
				
				JSFUtil.adicionarMensagemError("Produto deletado com sucesso!");
				
			} catch (RuntimeException e) {
				JSFUtil.adicionarMensagemError("e.getMessage()");
				e.printStackTrace();
			}
		}
		
		public void editar() {
			try {
				ProdutoDAO fdao = new ProdutoDAO();
				fdao.editar(produto);
				
				
				JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso!");
				
			} catch (RuntimeException e) {
				JSFUtil.adicionarMensagemError("e.getMessage()");
				e.printStackTrace();
			}
		}
}

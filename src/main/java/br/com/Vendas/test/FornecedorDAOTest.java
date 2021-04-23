package br.com.Vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.domain.Fornecedor;

public class FornecedorDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		Fornecedor f1 = new Fornecedor();
		Fornecedor f2 = new Fornecedor();
		f1.setDescricao("Teste01");
		f2.setDescricao("Ze ruela é minha irmã");
		
		FornecedoresDAO dao = new FornecedoresDAO();
		dao.salvar(f1);
		dao.salvar(f2);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		FornecedoresDAO dao = new FornecedoresDAO();
		List<Fornecedor> fornecedores = dao.listar();
		
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
		
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor f1 = dao.buscarPorCodigo(2L);
		 
			System.out.println(f1);
		
	}
	
	@Test
	@Ignore
	public void excluir() {
		FornecedoresDAO dao = new FornecedoresDAO();
		
		Fornecedor fornecedor = dao.buscarPorCodigo(2L);
		
	
			dao.excluir(fornecedor);
	}
	
	@Test
	public void editar() {
		FornecedoresDAO dao = new FornecedoresDAO();
		
		Fornecedor fornecedor = dao.buscarPorCodigo(7L);
		fornecedor.setDescricao("Paula Campos");
		
	
			dao.editar(fornecedor);
		
	}
	

}

package br.com.Vendas.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.DAO.ProdutoDAO;
import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.domain.Produto;

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor fornecedor = fdao.buscarPorCodigo(5L);
		
		Produto p1 = new Produto();
		Produto p2 = new Produto();
		
		p1.setDescricao("Arroz");
		p1.setQuantidade(13);
		p1.setPreco(new BigDecimal(22.99D));
		p1.setFornecedor(fornecedor);
		
		p2.setDescricao("feijão");
		p2.setQuantidade(13);
		p2.setPreco(new BigDecimal(12.99D));
		p2.setFornecedor(fornecedor);

		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p1);
		dao.salvar(p2);

	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.listar();

		for (Produto produto : produtos) {
			System.out.println(produto);
		}

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ProdutoDAO dao = new ProdutoDAO();
		Produto p1 = dao.buscarPorCodigo(2L);

		System.out.println(p1);

	}

	@Test
	@Ignore
	public void excluir() {
		ProdutoDAO dao = new ProdutoDAO();

		Produto produto = dao.buscarPorCodigo(3L);

		dao.excluir(produto);
	}

	@Test
	@Ignore
	public void editar() {
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		Fornecedor fornecedores = fdao.buscarPorCodigo(8L);
		
		ProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = dao.buscarPorCodigo(1L);
		
		produto.setDescricao("Libdgel");
		produto.setPreco(new BigDecimal(20.21D));
		produto.setQuantidade(99);
		produto.setFornecedor(fornecedores);

		dao.editar(produto);

	}
}

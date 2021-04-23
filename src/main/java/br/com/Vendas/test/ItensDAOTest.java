package br.com.Vendas.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.ItensDAO;
import br.com.Vendas.DAO.ProdutoDAO;
import br.com.Vendas.DAO.VendasDAO;
import br.com.Vendas.domain.Itens;
import br.com.Vendas.domain.Produto;
import br.com.Vendas.domain.Vendas;

public class ItensDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		ProdutoDAO pdao = new ProdutoDAO();
		Produto produto = pdao.buscarPorCodigo(1L);
		
		VendasDAO vdao = new VendasDAO();
		Vendas vendas = vdao.buscarPorCodigo(1L);
		
		Itens ite = new Itens();
		
		ite.setProduto(produto);
		ite.setVendas(vendas);
		ite.setQuantidade(11);
		ite.setValor_parcial(new BigDecimal(375.54d));
		
		ItensDAO dao = new ItensDAO();
		dao.salvar(ite);

	}

	@Test
	@Ignore
	public void listar() {
		ItensDAO dao = new ItensDAO();
		List<Itens> itens = dao.listar();

		for (Itens item : itens) {
			System.out.println(item);
		}

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ItensDAO dao = new ItensDAO();
		Itens ite = dao.buscarPorCodigo(3L);

		System.out.println(ite);

	}

	@Test
	@Ignore
	public void excluir() {
		ItensDAO dao = new ItensDAO();

		Itens ite = dao.buscarPorCodigo(3L);

		dao.excluir(ite);
	}

	@Test
	public void editar() {
		
		ProdutoDAO pdao = new ProdutoDAO();
		
		Produto produto = pdao.buscarPorCodigo(2L);
		
		
		VendasDAO vdao = new VendasDAO();
		
		Vendas vendas = vdao.buscarPorCodigo(1L);
		
		ItensDAO dao = new ItensDAO();
		
		Itens ite = dao.buscarPorCodigo(2L);
		
		ite.setProduto(produto);
		ite.setVendas(vendas);
		ite.setQuantidade(25);
		ite.setValor_parcial(new BigDecimal(102.55d));
		
		dao.editar(ite);

	}

}

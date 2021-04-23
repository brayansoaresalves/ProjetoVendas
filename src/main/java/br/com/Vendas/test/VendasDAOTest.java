package br.com.Vendas.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FuncionariosDAO;
import br.com.Vendas.DAO.VendasDAO;
import br.com.Vendas.domain.Funcionario;
import br.com.Vendas.domain.Vendas;

public class VendasDAOTest {
	@Test
	@Ignore
	public void salvar() {
		
		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionario funcionario = fdao.buscarPorCodigo(4L);
		
		Vendas v1 = new Vendas();
		//Vendas v2 = new Vendas();
		
		v1.setHorario(new Date());
		v1.setValor_total(new BigDecimal(83.55d));
		v1.setFuncionario(funcionario);

		VendasDAO dao = new VendasDAO();
		dao.salvar(v1);

	}

	@Test
	@Ignore
	public void listar() {
		VendasDAO dao = new VendasDAO();
		List<Vendas> vendas = dao.listar();

		for (Vendas venda : vendas) {
			System.out.println(venda);
		}

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		VendasDAO dao = new VendasDAO();
		Vendas v1 = dao.buscarPorCodigo(1L);

		System.out.println(v1);

	}

	@Test
	@Ignore
	public void excluir() {
		VendasDAO dao = new VendasDAO();

		Vendas vendas = dao.buscarPorCodigo(2L);

		dao.excluir(vendas);
	}

	@Test
	@Ignore
	public void editar() {
		
		FuncionariosDAO fdao = new FuncionariosDAO();
		
		Funcionario funcionario = fdao.buscarPorCodigo(6L);
		
		VendasDAO dao = new VendasDAO();
		
		Vendas vendas = dao.buscarPorCodigo(1L);
		
		vendas.setHorario(new Date());
		vendas.setValor_total(new BigDecimal(208.44d));
		vendas.setFuncionario(funcionario);

		dao.editar(vendas);

	}
}

package br.com.Vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FuncionariosDAO;
import br.com.Vendas.domain.Funcionario;

public class FuncionarioDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Funcionario f1 = new Funcionario();
		Funcionario f2 = new Funcionario();
		
		f1.setCpf("666.666.222-01");
		f1.setFuncao("Auxiliar Administrativo");
		f1.setNome("Carlos ");
		f1.setSenha("1234");
		
		f2.setCpf("666.666.666-11");
		f2.setFuncao("Porteiro");
		f2.setNome("Brayan ");
		f2.setSenha("1234");

		FuncionariosDAO dao = new FuncionariosDAO();
		dao.salvar(f1);
		dao.salvar(f2);

	}

	@Test
	@Ignore
	public void listar() {
		FuncionariosDAO dao = new FuncionariosDAO();
		List<Funcionario> funcionarios = dao.listar();

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FuncionariosDAO dao = new FuncionariosDAO();
		Funcionario f1 = dao.buscarPorCodigo(2L);

		System.out.println(f1);

	}

	@Test
	@Ignore
	public void excluir() {
		FuncionariosDAO dao = new FuncionariosDAO();

		Funcionario funcionario = dao.buscarPorCodigo(7L);

		dao.excluir(funcionario);
	}

	@Test
	@Ignore
	public void editar() {
		FuncionariosDAO dao = new FuncionariosDAO();

		Funcionario funcionario = dao.buscarPorCodigo(6L);
		funcionario.setCpf("111.1111.111");
		funcionario.setFuncao("Carpinteiro");
		funcionario.setNome("Alex");
		funcionario.setSenha("555");

		dao.editar(funcionario);

	}
}

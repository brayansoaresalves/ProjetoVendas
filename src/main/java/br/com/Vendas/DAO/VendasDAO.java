package br.com.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.Vendas.domain.Vendas;
import br.com.Vendas.util.HibernateUtil;

public class VendasDAO {
	public Long salvar(Vendas vendas) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;
		
		Long codigo = null;

		try {
			transacao = sessao.beginTransaction();// abrindo transação
			codigo = (Long)sessao.save(vendas);
			transacao.commit(); // confirmando a transação
		} catch (RuntimeException e) {

			if (transacao != null) {
				transacao.rollback(); // desfaz a transacao

			}

		} finally {
			sessao.close();
		}
		
		return codigo;
	}

	@SuppressWarnings("unchecked")
	public List<Vendas> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Vendas> venda = null;

		try {

			Query consulta = sessao.getNamedQuery("Vendas.listar");
			venda = consulta.list();

		} catch (RuntimeException e) {

			throw e;

		} finally {
			sessao.close();
		}

		return venda;
	}

	public Vendas buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Vendas vendas = null;

		try {

			Query consulta = sessao.getNamedQuery("Vendas.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			vendas = (Vendas) consulta.uniqueResult();

		} catch (RuntimeException e) {

			throw e;

		} finally {
			sessao.close();
		}

		return vendas;
	}

	public void excluir(Vendas vendas) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();// abrindo transação
			sessao.delete(vendas);
			transacao.commit(); // confirmando a transação
		} catch (RuntimeException e) {

			if (transacao != null) {
				transacao.rollback(); // desfaz a transacao

			}

		} finally {
			sessao.close();
		}
	}

	public void editar(Vendas vendas) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();// abrindo transação

			sessao.update(vendas);
			transacao.commit(); // confirmando a transação
		} catch (RuntimeException e) {

			if (transacao != null) {
				transacao.rollback(); // desfaz a transacao

			}

		} finally {
			sessao.close();
		}
	}
}

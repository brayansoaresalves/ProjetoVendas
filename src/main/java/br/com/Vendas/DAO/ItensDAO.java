package br.com.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.Vendas.domain.Itens;
import br.com.Vendas.util.HibernateUtil;

public class ItensDAO {
	public void salvar(Itens itens) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();// abrindo transação
			sessao.save(itens);
			transacao.commit(); // confirmando a transação
		} catch (RuntimeException e) {

			if (transacao != null) {
				transacao.rollback(); // desfaz a transacao

			}

		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Itens> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Itens> itens = null;

		try {

			Query consulta = sessao.getNamedQuery("Itens.listar");
			itens = consulta.list();

		} catch (RuntimeException e) {

			throw e;

		} finally {
			sessao.close();
		}

		return itens;
	}

	public Itens buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Itens itens = null;

		try {

			Query consulta = sessao.getNamedQuery("Itens.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			itens = (Itens) consulta.uniqueResult();

		} catch (RuntimeException e) {

			throw e;

		} finally {
			sessao.close();
		}

		return itens;
	}

	public void excluir(Itens itens) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();// abrindo transação
			sessao.delete(itens);
			transacao.commit(); // confirmando a transação
		} catch (RuntimeException e) {

			if (transacao != null) {
				transacao.rollback(); // desfaz a transacao

			}

		} finally {
			sessao.close();
		}
	}

	public void editar(Itens itens) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();// abrindo transação

			sessao.update(itens);
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

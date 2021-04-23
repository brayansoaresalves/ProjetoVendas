package br.com.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.util.HibernateUtil;

public class FornecedoresDAO {
	
	public void salvar(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();// abrindo transação
			sessao.save(fornecedor);
			transacao.commit(); // confirmando a transação
		}catch (RuntimeException e) {
			
			if (transacao != null) {
				transacao.rollback(); // desfaz a transacao
				
			}
		
		}finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		List<Fornecedor> fornecedores = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Fornecedor.listar");
			fornecedores = consulta.list();
			
		}catch (RuntimeException e) {
			
			throw e;
		
		}finally {
			sessao.close();
		}
		
		return fornecedores;
	}
	
	public Fornecedor buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Fornecedor fornecedores = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Fornecedor.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			
			fornecedores = (Fornecedor)consulta.uniqueResult();
			
		}catch (RuntimeException e) {
			
			throw e;
		
		}finally {
			sessao.close();
		}
		
		return fornecedores;
	}
	
	public void excluir(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();// abrindo transação
			sessao.delete(fornecedor);
			transacao.commit(); // confirmando a transação
		}catch (RuntimeException e) {
			
			if (transacao != null) {
				transacao.rollback(); // desfaz a transacao
				
			}
		
		}finally {
			sessao.close();
		}
	}
	
	/*public void excluir(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();// abrindo transação
			Fornecedor fornecedor = buscarPorCodigo(codigo);
			sessao.delete(fornecedor);
			transacao.commit(); // confirmando a transação
		}catch (RuntimeException e) {
			
			if (transacao != null) {
				transacao.rollback(); // desfaz a transacao
				
			}
		
		}finally {
			sessao.close();
		}
	}*/
	
	public void editar(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();// abrindo transação
			
			sessao.update(fornecedor);
			transacao.commit(); // confirmando a transação
		}catch (RuntimeException e) {
			
			if (transacao != null) {
				transacao.rollback(); // desfaz a transacao
				
			}
		
		}finally {
			sessao.close();
		}
	}
 

}

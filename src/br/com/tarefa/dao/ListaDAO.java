package br.com.tarefa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.tarefa.domain.Lista;
import br.com.tarefa.util.HibernateUtil;

public class ListaDAO {

	public void salvar(Lista lista) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {

			transacao = sessao.beginTransaction();
			sessao.save(lista);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Lista> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Lista> listas = null;
		try {
			Query consulta = sessao.getNamedQuery("Lista.listar");
			listas = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return listas;
	}

	public Lista buscarPorId(Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Lista lista = null;
		try {
			Query consulta = sessao.getNamedQuery("Lista.buscarPorId");
			consulta.setLong("id", id);
			lista = (Lista) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return lista;
	}

	public void excluir(Lista lista) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {

			transacao = sessao.beginTransaction();
			sessao.delete(lista);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

	public void excluir(Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {

			transacao = sessao.beginTransaction();
			Lista lista = buscarPorId(id);
			sessao.delete(lista);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

	public void editar(Lista lista) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {

			transacao = sessao.beginTransaction();

			sessao.update(lista);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

	{

	}

}

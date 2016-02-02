package br.com.tarefa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.tarefa.domain.Tarefa;
import br.com.tarefa.util.HibernateUtil;

public class TarefaDAO {
	public void salvar(Tarefa tarefa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {

			transacao = sessao.beginTransaction();
			sessao.save(tarefa);
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
	public List<Tarefa> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Tarefa> tarefas = null;
		try {
			Query consulta = sessao.getNamedQuery("Tarefa.listar");
			tarefas = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return tarefas;
	}

	public Tarefa buscarPorId(Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Tarefa tarefa = null;
		try {
			Query consulta = sessao.getNamedQuery("Tarefa.buscarPorId");
			consulta.setLong("id", id);
			tarefa = (Tarefa) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return tarefa;
	}

	public void excluir(Tarefa tarefa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {

			transacao = sessao.beginTransaction();
			sessao.delete(tarefa);
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
			Tarefa tarefa = buscarPorId(id);
			sessao.delete(tarefa);
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

	public void editar(Tarefa tarefa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {

			transacao = sessao.beginTransaction();

			sessao.update(tarefa);
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

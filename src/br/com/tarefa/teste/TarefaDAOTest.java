package br.com.tarefa.teste;

import org.junit.Ignore;
import org.junit.Test;

import br.com.tarefa.dao.ListaDAO;
import br.com.tarefa.dao.TarefaDAO;
import br.com.tarefa.domain.EstadoTarefa;
import br.com.tarefa.domain.Lista;
import br.com.tarefa.domain.Tarefa;

public class TarefaDAOTest {

	@Test
	@Ignore
	public void salvar() {

		ListaDAO lDAO = new ListaDAO();
		Lista lista = lDAO.buscarPorId(3L);

		Tarefa tarefa = new Tarefa();
		tarefa.setNome("JavaEE");
		tarefa.setEstado(EstadoTarefa.PENDENTE);
		tarefa.setLista(lista);
		TarefaDAO TDAO = new TarefaDAO();
		TDAO.salvar(tarefa);
	}

	@Test
	@Ignore
	public void editar() {
		TarefaDAO dao = new TarefaDAO();
		Tarefa tarefa = dao.buscarPorId(1L);
		tarefa.setNome("Hibernate");

		dao.editar(tarefa);
	}

	
}

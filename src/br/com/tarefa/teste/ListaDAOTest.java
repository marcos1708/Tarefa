package br.com.tarefa.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.tarefa.dao.ListaDAO;
import br.com.tarefa.domain.Lista;

public class ListaDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Lista l1 = new Lista();
		l1.setNome("Estudo");

		Lista l2 = new Lista();
		l2.setNome("Compras");

		ListaDAO dao = new ListaDAO();

		dao.salvar(l1);
		dao.salvar(l2);

	}

	@Test
	@Ignore
	public void listar() {
		ListaDAO dao = new ListaDAO();
		List<Lista> listas = dao.listar();

		for (Lista lista : listas) {
			System.out.println(lista);
		}
	}

	@Test
	@Ignore
	public void buscarPorId() {
		ListaDAO dao = new ListaDAO();
		Lista l1 = dao.buscarPorId(2L);
		System.out.println(l1);
	}

	@Test
	@Ignore
	public void excluir() {
		ListaDAO dao = new ListaDAO();
		Lista lista = dao.buscarPorId(1L);
		if (lista != null) {
			dao.excluir(lista);

		}
	}

	@Test
	@Ignore
	public void excluirPorCodigo() {
		ListaDAO dao = new ListaDAO();
		dao.excluir(1L);
	}

	@Test
	public void editar() {
		Lista lista = new Lista();
		lista.setId(2L);
		lista.setNome("teste");
		ListaDAO dao = new ListaDAO();
		dao.editar(lista);
	}
}

package br.com.tarefa.teste;

import org.junit.Test;

import br.com.tarefa.util.HibernateUtil;

public class GerarTabelasTest {
	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}

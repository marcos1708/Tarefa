package br.com.tarefa.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.tarefa.dao.ListaDAO;
import br.com.tarefa.dao.TarefaDAO;
import br.com.tarefa.domain.EstadoTarefa;
import br.com.tarefa.domain.Lista;
import br.com.tarefa.domain.Tarefa;
import br.com.tarefa.util.FacesUtil;

@ManagedBean
public class TarefasBean {

	private Tarefa tarefaCadastro;
	private List<Tarefa> tarefaSalvas;
	private List<Tarefa> tarefaFiltro;
	private List<Lista> Listas;
	private String acao;

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getAcao() {
		return acao;
	}

	public List<Lista> getListas() {
		return Listas;
	}

	public void setListas(List<Lista> listas) {
		Listas = listas;
	}

	public void setTarefaCadastro(Tarefa tarefaCadastro) {
		this.tarefaCadastro = tarefaCadastro;
	}

	public Tarefa getTarefaCadastro() {
		if (tarefaCadastro == null) {
			tarefaCadastro = new Tarefa();
		}
		return tarefaCadastro;
	}

	public void setTarefaSalvas(List<Tarefa> tarefaSalvas) {
		this.tarefaSalvas = tarefaSalvas;
	}

	public List<Tarefa> getTarefaSalvas() {
		return tarefaSalvas;
	}

	public void setTarefaFiltro(List<Tarefa> tarefaFiltro) {
		this.tarefaFiltro = tarefaFiltro;
	}

	public List<Tarefa> getTarefaFiltro() {
		return tarefaFiltro;
	}

	public EstadoTarefa[] getEstadoTarefa()

	{
		return EstadoTarefa.values();
	}

	public void carregarCadastro() {
		try {
			acao = FacesUtil.getParam("Taracao");
			String valor = FacesUtil.getParam("TarId");
			if (valor != null) {
				Long id = Long.parseLong(valor);
				TarefaDAO tarefadao = new TarefaDAO();
				tarefaCadastro = tarefadao.buscarPorId(id);
			} else {
				tarefaCadastro = new Tarefa();
			}
			ListaDAO listadao = new ListaDAO();
			Listas = listadao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgErro("Ocorreu erro ao tentar obter dados" + ex.getMessage());
		}

	}

	public void carregar() {
		try {
			TarefaDAO tarefadao = new TarefaDAO();
			tarefaSalvas = tarefadao.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgErro("Ocorreu erro ao tentar listar" + ex.getMessage());
		}
	}

	public void editar() {
		try {
			TarefaDAO tarefadao = new TarefaDAO();
			tarefadao.editar(tarefaCadastro);

			FacesUtil.addMsgInfo("Tarefa editado com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgErro("Ocorreu erro ao tentar editar a tarefa" + ex.getMessage());
		}

	}

	public void novo() {
		tarefaCadastro = new Tarefa();
	}

	public void excluir() {
		try {
			TarefaDAO tarefadao = new TarefaDAO();
			tarefadao.excluir(tarefaCadastro);
			FacesUtil.addMsgInfo("Tarefa excluida com sucesso");
		} catch (RuntimeException ex) {

			FacesUtil.addMsgErro("Ocorreu erro ao tentar excluir a tarefa" + ex.getMessage());
		}

	}

	public void salvar() {
		try {
			TarefaDAO tarefadao = new TarefaDAO();
			tarefadao.salvar(tarefaCadastro);
			tarefaCadastro = new Tarefa();
			FacesUtil.addMsgInfo("Tarefa salvo com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgErro("Ocorreu erro ao tentar incluir a tarefa" + ex.getMessage());
		}

	}

}

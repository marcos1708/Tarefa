package br.com.tarefa.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.tarefa.dao.ListaDAO;
import br.com.tarefa.domain.Lista;
import br.com.tarefa.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ListaBean {
	private Lista listaCadastro;
	private List<Lista> listaSalvas;
	private List<Lista> ListaFiltro;
	private String acao;

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public List<Lista> getListaSalvas() {
		return listaSalvas;
	}

	public void setListaSalvas(List<Lista> listaSalvas) {
		this.listaSalvas = listaSalvas;
	}

	public List<Lista> getListaFiltro() {
		return ListaFiltro;
	}

	public void setListaFiltro(List<Lista> listaFiltro) {
		ListaFiltro = listaFiltro;
	}

	public void setListaCadastro(Lista listaCadastro) {
		this.listaCadastro = listaCadastro;
	}

	public Lista getListaCadastro() {
		if (listaCadastro == null) {
			listaCadastro = new Lista();
		}
		return listaCadastro;
	}

	public void carregarCadastro() {
		try {
			acao = FacesUtil.getParam("LisAcao");
			String valor = FacesUtil.getParam("LisId");
			if (valor != null) {
				Long id = Long.parseLong(valor);
				ListaDAO listadao = new ListaDAO();
				listaCadastro = listadao.buscarPorId(id);
			}
		} catch (RuntimeException ex) {
			FacesUtil.addMsgErro("Ocorreu erro ao tentar obter dados" + ex.getMessage());
		}

	}

	public void carregar() {
		try {
			ListaDAO listaDAO = new ListaDAO();
			listaSalvas = listaDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addMsgErro("Ocorreu erro ao tentar listar" + ex.getMessage());
		}
	}

	public void editar() {
		try {
			ListaDAO listaDAO = new ListaDAO();
			listaDAO.editar(listaCadastro);

			FacesUtil.addMsgInfo("Lista editado com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgErro("Ocorreu erro ao tentar editar a Lista" + ex.getMessage());
		}

	}

	public void novo() {
		listaCadastro = new Lista();
	}

	public void excluir() {
		try {
			ListaDAO listaDAO = new ListaDAO();
			listaDAO.excluir(listaCadastro);
			FacesUtil.addMsgInfo("Lista excluido com sucesso");
		} catch (RuntimeException ex) {

			FacesUtil.addMsgErro("Ocorreu erro ao tentar excluir a Lista" + ex.getMessage());
		}

	}

	public void salvar() {
		try {
			ListaDAO listaDAO = new ListaDAO();
			listaDAO.salvar(listaCadastro);
			listaCadastro = new Lista();
			FacesUtil.addMsgInfo("Lista salvo com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgErro("Ocorreu erro ao tentar incluir a Lista" + ex.getMessage());
		}

	}

}

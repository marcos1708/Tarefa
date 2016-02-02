package br.com.tarefa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.tarefa.dao.ListaDAO;
import br.com.tarefa.domain.Lista;

@FacesConverter(forClass = Lista.class)

public class ListaConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext faceContext, UIComponent component, String valor) {
		System.out.println("getAsObject" + valor);
		try {
			Long id = Long.parseLong(valor);
			ListaDAO listaDAO = new ListaDAO();
			Lista lista = listaDAO.buscarPorId(id);

			return lista;
		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {

		try {
			Lista lista = (Lista) objeto;
			Long id = lista.getId();
			return id.toString();

		} catch (RuntimeException ex) {

		}
		return null;
	}
}

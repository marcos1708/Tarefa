package br.com.tarefa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.tarefa.dao.TarefaDAO;
import br.com.tarefa.domain.Tarefa;

@FacesConverter(forClass = Tarefa.class)

public class TarefaConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext faceContext, UIComponent component, String valor) {
		System.out.println("getAsObject" + valor);
		try {
			Long id = Long.parseLong(valor);
			TarefaDAO tarefaDAO = new TarefaDAO();
			Tarefa tarefa = tarefaDAO.buscarPorId(id);

			return tarefa;
		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {

		try {
			Tarefa tarefa = (Tarefa) objeto;
			Long id = tarefa.getId();
			return id.toString();

		} catch (RuntimeException ex) {

		}
		return null;
	}
}

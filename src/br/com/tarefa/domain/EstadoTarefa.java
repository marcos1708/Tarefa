package br.com.tarefa.domain;

public enum EstadoTarefa {
	PENDENTE("pendente"), FINALIZADA("finalizada");

	private String descricao;

	EstadoTarefa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}

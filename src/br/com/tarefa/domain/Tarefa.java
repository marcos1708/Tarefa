package br.com.tarefa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tarefa")
@NamedQueries({ @NamedQuery(name = "Tarefa.listar", query = "SELECT tarefa FROM Tarefa tarefa"),
		@NamedQuery(name = "Tarefa.buscarPorId", query = "SELECT tarefa FROM Tarefa tarefa where tarefa.id= :id") })

public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "lista_id")

	@NotNull(message="Selecione uma Lista")
	private Lista lista;
	@NotEmpty
	@Size(min = 3, max = 60, message = "Nome invalido")
	@Column(length = 60, nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Selecione o estado da tarefa")
	private EstadoTarefa estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EstadoTarefa getEstado() {
		return estado;
	}

	public void setEstado(EstadoTarefa estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", lista=" + lista + ", nome=" + nome + ", estado=" + estado + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

package br.maca.api.livro.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Editoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long IdEditoria;
	
	@NotEmpty(message = "Obrigatório informar o nome da Editoria")
	private String Nome;
	
	public Editoria () {}
	
	public Editoria (Long idEditoria, String nome) {
		
		this.IdEditoria = idEditoria;
		this.Nome = nome;
	}
	
	public Long getIdEditoria() {
		return IdEditoria;
	}

	public void setIdEditoria(Long idEditora) {
		IdEditoria = idEditora;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
}

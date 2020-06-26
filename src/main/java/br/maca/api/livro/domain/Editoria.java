package br.maca.api.livro.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;


@Entity
public class Editoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_editoria")
	private Long IdEditora;
	
	@NotEmpty(message = "Obrigatório informar o nome da Editoria")
	private String Nome;
	
	@OneToMany(mappedBy = "editoria", fetch = FetchType.LAZY)
	private List<Livro> livros;

	
	public Editoria () {}
	
	public Editoria (Long idEditoria, String nome) {
		this.IdEditora = idEditoria;
		this.Nome = nome;
	}
	
	public Long getIdEditoria() {
		return IdEditora;
	}

	public void setIdEditoria(Long idEditora) {
		IdEditora = idEditora;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
	


	
	

}

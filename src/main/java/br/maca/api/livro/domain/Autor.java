package br.maca.api.livro.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autor")
	private Long IdAutor;
	
	@NotEmpty (message = "O campo Nome não pode ser vazio")
	private String Nome;
	
	@NotEmpty (message = "O campo Biografia não pode ser vazio")
	private String Biografia;
	
	@OneToMany
	private List <Livro> livros;
	
	public Autor () {}
	
	public Autor (Long idAutor, String nome, String biografia) {
		
		this.IdAutor = idAutor;
		this.Nome = nome;
		this.Biografia = biografia;
	}

	public Long getIdAutor() {
		return IdAutor;
	}

	public void setIdAutor(Long idAutor) {
		IdAutor = idAutor;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getBiografia() {
		return Biografia;
	}

	public void setBiografia(String biografia) {
		Biografia = biografia;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
}
	
	


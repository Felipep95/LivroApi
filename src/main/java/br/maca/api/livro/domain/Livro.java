package br.maca.api.livro.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long IdLivro;
	
	@NotEmpty (message = "o campo Titulo é obrigatório!")
	private String Titulo;
	
	@NotEmpty (message = "o campo Gênero é obrigatório!")
	private String Genero;
	
	@NotEmpty (message = "o campo Edição é obrigatório!")
	private String Edicao;
	
	@NotEmpty (message = "o campo ISBN é obrigatório!")
	private String ISBN;

	@JsonIgnoreProperties("autor")
	@ManyToOne
	@NotNull (message = "o campo Autor é obrigatório!")
	private Autor Autor;
	
	@ManyToOne
	@NotNull (message = "o campo Editoria é obrigatório!")
	private Editoria Editoria;
	
	public Long getIdLivro() {
		return IdLivro;
	}
	public void setIdLivro(Long idLivro) {
		IdLivro = idLivro;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		Genero = genero;
	}
	public String getEdicao() {
		return Edicao;
	}
	public void setEdicao(String edicao) {
		Edicao = edicao;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Autor getAutor() {
		return Autor;
	}
	public void setAutor(Autor autor) {
		Autor = autor;
	}
	public Editoria getEditoria() {
		return Editoria;
	}
	public void setEditoria(Editoria editoria) {
		Editoria = editoria;
	}
}
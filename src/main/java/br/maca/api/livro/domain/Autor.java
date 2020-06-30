package br.maca.api.livro.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long IdAutor;
	
	@NotEmpty (message = "O campo Nome é obrigatório!")
	private String Nome;
	
	@NotEmpty (message = "O campo Biografia é obrigatório!")
	private String Biografia;
	
	@JsonIgnoreProperties("autor")
	@OneToMany(mappedBy = "Autor")
	private List <Livro> livros;
	
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
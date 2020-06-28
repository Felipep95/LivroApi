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
	//@Column(name = "id_editoria")
	private Long IdEditoria;
	
	@NotEmpty(message = "Obrigatório informar o nome da Editoria")
	private String Nome;
	
	/*@OneToMany(mappedBy = "editoria", fetch = FetchType.LAZY)
	private List<Livro> livros; */
	//@OneToOne
	//private Livro Livro;

	
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

	/*public Livro getLivro() {
		return Livro;
	}

	public void setLivro(Livro livro) {
		Livro = livro;
	}*/

/*	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
*/	
	
	


	
	

}

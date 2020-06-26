package br.maca.api.livro.resources;


	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import br.maca.api.livro.repository.LivrosRepository;
	import br.maca.api.livro.domain.Livro;

	@RestController
	@RequestMapping("/livros")
	public class LivrosResources {
		
		@Autowired
		private LivrosRepository livrosRepository;
		
		@GetMapping(value = "/livros")
		public List<Livro> listarTodas() {
			return livrosRepository.findAll();
		}
		
		@PostMapping(value = "/livros")
		public void salvar (Livro livro) {
			livrosRepository.save(livro);
		}
		
		@PutMapping
		public void atualizar (@RequestBody Livro livro) {
			livrosRepository.save(livro);
		}
		
		@DeleteMapping
		public void deletar(@RequestBody Livro livro) {
			livrosRepository.delete(livro);
		}
		
		@GetMapping(value = "/{id}")
		public Optional<Livro> buscarPorId(@PathVariable("id") Long idLivro) {
			return livrosRepository.findById(idLivro);
		}
		
	}



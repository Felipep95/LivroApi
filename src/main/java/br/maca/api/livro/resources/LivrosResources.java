package br.maca.api.livro.resources;


	import java.net.URI;
	import java.util.List;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.validation.annotation.Validated;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
	import br.maca.api.livro.service.LivrosService;
	import br.maca.api.livro.domain.Livro;
	

	@RestController
	@RequestMapping("/livros")
	public class LivrosResources {
		
		@Autowired
		private LivrosService livrosService;
		
		//@GetMapping(value = "/livros")
		@GetMapping
		public List<Livro> listarTodas() {
			return livrosService.listar();
		}
		
		//@PostMapping(value = "/livros")
		@PostMapping
		public ResponseEntity<Void> salvar(@RequestBody @Validated Livro livro) {
			livrosService.salvar(livro);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
								.buildAndExpand(livro.getIdLivro()).toUri();
			return ResponseEntity.created(uri).build();
			}
		
		@PutMapping
		public void atualizar (@RequestBody Livro livro) {
			livrosService.atualizar(livro);
		}
		
		@DeleteMapping(value = "/{id}")
		public void deletar(@PathVariable("id") Long IdLivro) throws Exception {
			livrosService.deletarPorId(IdLivro);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Livro> buscarPorId(@PathVariable("id") Long IdLivro) throws Exception {
			return ResponseEntity.ok(livrosService.buscarPorId(IdLivro));
		}	
	}



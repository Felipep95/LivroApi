package br.maca.api.livro.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.maca.api.livro.repository.AutoresRepository;
import br.maca.api.livro.domain.Autor;

@RestController
@RequestMapping("/autores")
public class AutoresResources {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	@GetMapping(value = "/autores")
	public List<Autor> listarTodas() {
		return autoresRepository.findAll();
	}
	
	@PostMapping(value = "/autores")
	public ResponseEntity<Void> salvar(@RequestBody Autor autor) {
		autoresRepository.save(autor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
							.buildAndExpand(autor.getIdAutor()).toUri();
		return ResponseEntity.created(uri).build();
		}
	
	@PutMapping
	public void atualizar (@RequestBody Autor autor) {
		autoresRepository.save(autor);
	}
	
	@DeleteMapping
	public void deletar(@RequestBody Autor autor) {
		autoresRepository.delete(autor);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Autor> buscarPorId(@PathVariable("id") Long idAutor) {
		return autoresRepository.findById(idAutor).map(autor ->
		ResponseEntity.ok(autor)).orElse(ResponseEntity.notFound().build());
	}
	
}

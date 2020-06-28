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

import br.maca.api.livro.service.AutoresService;
import br.maca.api.livro.domain.Autor;


@RestController
@RequestMapping("/autores")
public class AutoresResources {
	
	@Autowired
	private AutoresService autoresService;
	
	//@GetMapping(value = "/autores")
	@GetMapping
	public List<Autor> listarTodas() {
		return autoresService.listar();
	}
	
	//@PostMapping(value = "/autores")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Validated Autor autor) {
		autoresService.salvar(autor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
							.buildAndExpand(autor.getIdAutor()).toUri();
		return ResponseEntity.created(uri).build();
		}
	
	@PutMapping
	public void atualizar (@RequestBody Autor autor) {
		autoresService.atualizar(autor);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long IdAutor) throws Exception {
		autoresService.deletarPorId(IdAutor);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Autor> buscarPorId(@PathVariable("id") Long IdAutor) throws Exception {
		return ResponseEntity.ok(autoresService.buscarPorId(IdAutor));
	}
	
}

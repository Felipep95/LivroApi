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


import br.maca.api.livro.service.EditoriasService;
import br.maca.api.livro.domain.Editoria;

@RestController
@RequestMapping("/editorias")
public class EditoriasResources {
	
	@Autowired
	private EditoriasService editoriasService;
	
	//@GetMapping(value = "/editorias")
	@GetMapping
	public List<Editoria> listarTodas() {
		return editoriasService.listar();
	}
	
	//@PostMapping(value = "/editorias")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Validated Editoria editoria) {
		editoriasService.salvar(editoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
							.buildAndExpand(editoria.getIdEditoria()).toUri();
		return ResponseEntity.created(uri).build();
		}
	
	@PutMapping
	public void atualizar (@RequestBody Editoria editoria) {
		editoriasService.atualizar(editoria);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long IdEditoria) throws Exception {
		editoriasService.deletarPorId(IdEditoria);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Editoria> buscarPorId(@PathVariable("id") Long IdEditoria) throws Exception {
		return ResponseEntity.ok(editoriasService.buscarPorId(IdEditoria));
	}	
}

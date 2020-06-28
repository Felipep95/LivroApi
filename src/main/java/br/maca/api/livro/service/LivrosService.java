package br.maca.api.livro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.maca.api.livro.domain.Livro;
import br.maca.api.livro.repository.LivrosRepository;
@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;

	public Livro salvar(Livro livro) {
		Livro livroCriado = livrosRepository.save(livro);
		return livroCriado;
	}

	public Livro atualizar(Livro livro) {
		Livro livroAtualizado = livrosRepository.save(livro);
		return livroAtualizado;
	}

	public void deletarPorId(Long id) throws Exception {
		Livro livroExclusao = livrosRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));

		livrosRepository.deleteById(id);
	}

	public Livro buscarPorId(Long id) throws Exception {
		return livrosRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Livro> listar() {
		return livrosRepository.findAll();
	}

	
	
}

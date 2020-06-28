package br.maca.api.livro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.maca.api.livro.domain.Autor;
import br.maca.api.livro.repository.AutoresRepository;

@Service
public class AutoresService {
	@Autowired
	private AutoresRepository autoresRepository;

	public Autor salvar(Autor autor) {
		Autor autorCriado = autoresRepository.save(autor);
		return autorCriado;
	}

	public Autor atualizar(Autor autor) {
		Autor autorAtualizado = autoresRepository.save(autor);
		return autorAtualizado;
	}

	public void deletarPorId(Long id) throws Exception {
		Autor autorExclusao = autoresRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));

		autoresRepository.deleteById(id);
	}

	public Autor buscarPorId(Long id) throws Exception {
		return autoresRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Autor> listar() {
		return autoresRepository.findAll();
	}
}

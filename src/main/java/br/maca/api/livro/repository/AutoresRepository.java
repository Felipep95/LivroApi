package br.maca.api.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.maca.api.livro.domain.Autor;

@Repository
public interface AutoresRepository extends JpaRepository<Autor, Long>  {
	
}

package br.maca.api.livro.repository;

import br.maca.api.livro.domain.Editoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoriasRepository extends JpaRepository<Editoria, Long>   {

}

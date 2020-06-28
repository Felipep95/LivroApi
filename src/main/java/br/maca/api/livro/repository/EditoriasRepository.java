package br.maca.api.livro.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.maca.api.livro.domain.Editoria;


@Repository
public interface EditoriasRepository extends JpaRepository<Editoria, Long>   {

}

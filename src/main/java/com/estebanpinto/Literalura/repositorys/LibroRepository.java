package com.estebanpinto.Literalura.repositorys;

import com.estebanpinto.Literalura.models.Libro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface LibroRepository extends Repository<Libro, Long> {
    Optional<Libro> findById(Long id);
    Optional<Libro> findByTitulo(String titulo);

    List<Libro> findAll();
    void save(Libro libro);

    List<Libro> getTopByDescargas(long top);
    @Query("SELECT l FROM Libro l join l.autores a WHERE a.id = ?1")
    List<Libro> findByAutor(Long autorId);

    @Query("SELECT l FROM Libro l join l.generos g WHERE g.id = ?1")
    List<Libro> findByGenero(Long generoId);

    @Query("SELECT l FROM Libro l join l.idiomas i WHERE i.id = ?1")
    List<Libro> findByIdioma(Long idiomaId);
}

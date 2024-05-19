package com.estebanpinto.Literalura.repositorys;

import com.estebanpinto.Literalura.models.Libro;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface LibroRepository extends Repository<Libro, Long> {
    Optional<Libro> findById(Long id);
    Optional<Libro> findByTitulo(String titulo);

    List<Libro> findAll();

    void save(Libro libro);
}

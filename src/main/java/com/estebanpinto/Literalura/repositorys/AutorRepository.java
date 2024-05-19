package com.estebanpinto.Literalura.repositorys;

import com.estebanpinto.Literalura.models.Autor;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends Repository<Autor, Long> {
    Optional<Autor> findById(Long id);
    void save(Autor autor);
    Optional<Autor> findByNombre(String nombre);
    List<Autor> findAll();
    List<Autor> findByNombreContaining(String nombre);
}

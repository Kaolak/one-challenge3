package com.estebanpinto.Literalura.repositorys;

import com.estebanpinto.Literalura.models.Idioma;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface IdiomaRepository extends Repository<Idioma, Long> {
    void save(Idioma idioma);
    Optional<Idioma> findByNombre(String nombre);
    Optional<Idioma> findById(Long id);
    List<Idioma> findAll();
}

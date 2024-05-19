package com.estebanpinto.Literalura.repositorys;

import com.estebanpinto.Literalura.models.Genero;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface GeneroRepository extends Repository<Genero, Long> {
    void save(Genero genero);
    Optional<Genero> findByNombre(String nombre);
    Optional<Genero> findById(Long id);
    List<Genero> findAll();
}

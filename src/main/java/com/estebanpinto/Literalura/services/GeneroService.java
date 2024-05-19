package com.estebanpinto.Literalura.services;

import com.estebanpinto.Literalura.models.Genero;
import com.estebanpinto.Literalura.repositorys.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> getGeneros() {
        return generoRepository.findAll();
    }
}

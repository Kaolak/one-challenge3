package com.estebanpinto.Literalura.services;

import com.estebanpinto.Literalura.models.Autor;
import com.estebanpinto.Literalura.repositorys.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> getAutores() {
        return autorRepository.findAll();
    }
}

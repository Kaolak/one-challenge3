package com.estebanpinto.Literalura.services;

import com.estebanpinto.Literalura.models.Idioma;
import com.estebanpinto.Literalura.repositorys.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomaService {
    @Autowired
    private IdiomaRepository idiomaRepository;

    public List<Idioma> getIdiomas() {
        return idiomaRepository.findAll();
    }
}

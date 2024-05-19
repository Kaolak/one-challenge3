package com.estebanpinto.Literalura.services;

import com.estebanpinto.Literalura.models.Autor;
import com.estebanpinto.Literalura.models.Genero;
import com.estebanpinto.Literalura.models.Idioma;
import com.estebanpinto.Literalura.models.Libro;
import com.estebanpinto.Literalura.repositorys.AutorRepository;
import com.estebanpinto.Literalura.repositorys.GeneroRepository;
import com.estebanpinto.Literalura.repositorys.IdiomaRepository;
import com.estebanpinto.Literalura.repositorys.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private IdiomaRepository idiomaRepository;
    @Autowired
    private GeneroRepository generoRepository;

    public void addLibro(Libro libro) {
        Optional<Libro> libroOptional = libroRepository.findByTitulo(libro.getTitulo());
        if (libroOptional.isPresent()) {
            System.out.println("El libro ya existe");
            return;
        }
        libro.setGeneros(saveGeneros(libro.getGeneros()));
        libro.setAutores(saveAutores(libro.getAutores()));
        libro.setIdiomas(saveIdiomas(libro.getIdiomas()));
        libroRepository.save(libro);
    }

    public List<Libro> getLibros() {
        return libroRepository.findAll();
    }
    public List<Libro> getLibrosByGenero(Genero genero) {
        Optional<Genero> generoOptional = generoRepository.findByNombre(genero.getNombre());
        if (generoOptional.isEmpty()) {
            return new ArrayList<Libro>();
        }
        return libroRepository.findByGenero(generoOptional.get().getId());
    }

    public List<Libro> getLibrosByAutor(Autor autor) {
        Optional<Autor> autorOptional = autorRepository.findByNombre(autor.getNombre());
        if (autorOptional.isEmpty()) {
            return new ArrayList<Libro>();
        }
        return libroRepository.findByAutor(autorOptional.get().getId());
    }
    public List<Libro> getLibrosByIdioma(Idioma idioma) {
        Optional<Idioma> idiomaOptional = idiomaRepository.findByNombre(idioma.getNombre());
        if (idiomaOptional.isEmpty()) {
            return new ArrayList<Libro>();
        }
        return libroRepository.findByIdioma(idiomaOptional.get().getId());
    }
    public List<Libro> getTopLibros(long top) {
        return libroRepository.getTopByDescargas(top);
    }



    private List<Genero> saveGeneros(List<Genero> generos) {
        List<Genero> generoList = new ArrayList<Genero>();
        generos.forEach(genero -> {
            Optional<Genero> generoOptional = generoRepository.findByNombre(genero.getNombre());
            if (generoOptional.isEmpty()) {
                generoRepository.save(genero);
                generoList.add(genero);
            }
            else {
                generoList.add(generoOptional.get());
            }

        });
        return generoList;
    }
    private List<Autor> saveAutores(List<Autor> autores){
        List<Autor> autorList = new ArrayList<Autor>();
        autores.forEach(autor -> {
            Optional<Autor> autorOptional = autorRepository.findByNombre(autor.getNombre());
            if (autorOptional.isEmpty()) {
                autorRepository.save(autor);
                autorList.add(autor);
            }
            else {
                autorList.add(autorOptional.get());
            }
        });
        return autorList;
    }
    private List<Idioma> saveIdiomas(List<Idioma> idiomas){
        List<Idioma> idiomaList = new ArrayList<Idioma>();
        idiomas.forEach(idioma -> {
            Optional<Idioma> idiomaOptional = idiomaRepository.findByNombre(idioma.getNombre());
            if (idiomaOptional.isEmpty()) {
                idiomaRepository.save(idioma);
                idiomaList.add(idioma);
            }
            else {
                idiomaList.add(idiomaOptional.get());
            }
        });
        return idiomaList;
    }

}

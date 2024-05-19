package com.estebanpinto.Literalura.models;

import com.estebanpinto.Literalura.dto.LibroDTO;
import com.estebanpinto.Literalura.repositorys.AutorRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Entity
public class Libro {

    @Id
    private Long id;
    private String titulo;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> autores;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "libro_genero",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id"))
    private List<Genero> generos;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "libro_idioma",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "idioma_id"))
    private List<Idioma> idiomas;
    private long descargas;


    public Libro() {
    }
    public Libro(LibroDTO libroDTO) {
        this.id = libroDTO.id();
        this.titulo = libroDTO.title();
        this.autores = libroDTO.authors().stream().map(Autor::new).toList();
        this.generos = libroDTO.subjects().stream().map(Genero::new).toList();
        this.idiomas = libroDTO.languages().stream().map(Idioma::new).toList();
        this.descargas = libroDTO.download_count();
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public long getDescargas() {
        return descargas;
    }

    public String getTitulo() {
        return titulo;
    }


    public List<Autor> getAutores() {
        return autores;
    }

    public List<Genero> getGeneros() {
        return generos;
    }


    public List<Idioma> getIdiomas() {
        return idiomas;
    }


    @Override
    public String toString() {
        return ">>" +titulo + '\n' +
                "Autores: " + autores +
                "\nGeneros: " + generos +
                "\nIdiomas: " + idiomas +
                "\nDescargas:" + descargas;
    }
}

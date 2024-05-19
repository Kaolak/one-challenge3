package com.estebanpinto.Literalura.models;

import com.estebanpinto.Literalura.dto.IdiomaDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToMany
    @JoinTable(name = "libro_idioma",
            joinColumns = @JoinColumn(name = "idioma_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private List<Libro> libros;

    public Idioma() {

    }
    public Idioma(String nombre) {
        this.nombre = nombre;
    }

    public Idioma(IdiomaDTO idioma) {
        this.nombre = idioma.name();
    }


    public List<Libro> getLibros() {
        return libros;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

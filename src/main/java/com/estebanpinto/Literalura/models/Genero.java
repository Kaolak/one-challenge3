package com.estebanpinto.Literalura.models;

import com.estebanpinto.Literalura.dto.GeneroDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToMany
    @JoinTable(name = "libro_genero",
            joinColumns = @JoinColumn(name = "genero_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private List<Libro> libros;


    public Genero() {

    }
    public Genero(String nombre) {
        this.nombre = nombre;
    }
    public Genero(GeneroDTO genero) {
        this.nombre = genero.name();
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

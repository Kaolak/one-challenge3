package com.estebanpinto.Literalura.models;

import com.estebanpinto.Literalura.dto.AutorDTO;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int fechaNacimiento;
    private int fechaDefuncion;
    @ManyToMany
    @JoinTable(name = "libro_autor", joinColumns = @JoinColumn(name = "autor_id"), inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private List<Libro> libros;


    public Autor(String nombre, int fechaNacimiento, int fechaDefuncion) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDefuncion = fechaDefuncion;
    }

    public Autor() {

    }
    public Autor(AutorDTO autor) {
        this.nombre = autor.name();
        this.fechaNacimiento = autor.birth_year();
        this.fechaDefuncion = autor.death_year();
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getFechaDefuncion() {
        return fechaDefuncion;
    }

    @Override
    public String toString() {
        return nombre + " (" + fechaNacimiento + " - " + fechaDefuncion + ")";
    }

    public Long getId() {
        return id;
    }
}

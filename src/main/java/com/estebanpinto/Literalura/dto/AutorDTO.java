package com.estebanpinto.Literalura.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;

// This is a DTO class that is used to transfer data between the API and the application
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record AutorDTO(
        String name,
        int birth_year,
        int death_year
) {
}

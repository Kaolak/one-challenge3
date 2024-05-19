package com.estebanpinto.Literalura.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// This is a DTO class that is used to transfer data between the API and the application
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDTO(
        Long id,
        String title,
        List<AutorDTO> authors,
        List<String> languages,
        List<String> subjects,
        Long download_count
) {
}

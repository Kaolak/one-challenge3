package com.estebanpinto.Literalura.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

// This is a DTO class that is used to transfer data between the API and the application
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record IdiomaDTO(
        String name
) {
}

package com.estebanpinto.Literalura.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record GeneroDTO(
        String name
) {
}

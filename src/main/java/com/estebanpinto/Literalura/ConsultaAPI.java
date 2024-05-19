package com.estebanpinto.Literalura;

import com.estebanpinto.Literalura.dto.LibroDTO;
import com.estebanpinto.Literalura.models.Libro;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;


public class ConsultaAPI {
    private final String url;

    public ConsultaAPI(String url) {
        this.url = url;
    }
    public Libro getLibro(String libro) {

        Libro resultado = buscarLibro(libro);

        return resultado;
    }
    private Libro buscarLibro(String libro) {
        ObjectMapper mapper = new ObjectMapper();

        libro= libro.replace(" ", "+");
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + libro))
                    .GET()
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Map<String, Object> jsonMap = mapper.readValue(response.body(), Map.class);
            List<String> results = (List<String>) jsonMap.get("results");
            if (results.size() == 0) {
                return null;
            }
            Libro resultado = new Libro(mapper.convertValue(results.get(0), LibroDTO.class));
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

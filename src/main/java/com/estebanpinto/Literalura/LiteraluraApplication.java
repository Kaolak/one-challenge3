package com.estebanpinto.Literalura;

import com.estebanpinto.Literalura.models.Libro;
import com.estebanpinto.Literalura.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private LibroService libroService;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo");
		ConsultaAPI api = new ConsultaAPI("https://gutendex.com/books/?search=");
		Libro libro = api.getLibro("pride and prejudice");
		libroService.addLibro(libro);
		System.out.println(libro);
	}
}

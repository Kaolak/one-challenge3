package com.estebanpinto.Literalura;

import com.estebanpinto.Literalura.models.Autor;
import com.estebanpinto.Literalura.models.Genero;
import com.estebanpinto.Literalura.models.Idioma;
import com.estebanpinto.Literalura.models.Libro;
import com.estebanpinto.Literalura.services.AutorService;
import com.estebanpinto.Literalura.services.GeneroService;
import com.estebanpinto.Literalura.services.IdiomaService;
import com.estebanpinto.Literalura.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private LibroService libroService;
	@Autowired
	private AutorService autorService;
	@Autowired
	private GeneroService generoService;
	@Autowired
	private IdiomaService idiomaService;


	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ConsultaAPI api = new ConsultaAPI("https://gutendex.com/books/?search=");

		int opcion = menu();
		while (opcion != 6) {
			switch (opcion) {
				case 1:
					System.out.println("Ingrese el titulo del libro: ");
					Scanner scanner = new Scanner(System.in);
					String titulo = scanner.nextLine();
					Libro libro = api.getLibro(titulo);
					if(libro != null) {
						libroService.addLibro(libro);
						System.out.println(libro);
					}
					else {
						System.out.println("Libro no encontrado");
					}
					break;
				case 2:
					Genero genero = mostrarGeneros();
					libroService.getLibrosByGenero(genero).forEach(System.out::println);
					break;
				case 3:
					Idioma idioma = mostrarIdiomas();
					libroService.getLibrosByIdioma(idioma).forEach(System.out::println);
					break;
				case 4:
					Autor autor = mostrarAutores();
					libroService.getLibrosByAutor(autor).forEach(System.out::println);
					break;
				case 5:
					libroService.getLibros().forEach(System.out::println);
					break;
			}
			opcion = menu();
		}
	}

	private Autor mostrarAutores() {
		int i =0;
		System.out.println("Autores: ");
		List<Autor> autores= autorService.getAutores();
		for (Autor autor: autores) {
			System.out.println(i + ". " + autor);
			i++;
		}
		System.out.println("Ingrese el autor: ");
		Scanner scanner = new Scanner(System.in);
		int opcion = scanner.nextInt();
		if (opcion < 0 || opcion >= autores.size()) {
			System.out.println("Opcion invalida");
			mostrarAutores();
		}
		return autores.get(opcion);
	}

	private Idioma mostrarIdiomas() {
		int i =0;
		System.out.println("Idiomas: ");
		List<Idioma> idiomas= idiomaService.getIdiomas();
		for (Idioma idioma: idiomas) {
			System.out.println(i + ". " + idioma);
			i++;
		}
		System.out.println("Ingrese el idioma: ");
		Scanner scanner = new Scanner(System.in);
		int opcion = scanner.nextInt();
		if (opcion < 0 || opcion >= idiomas.size()) {
			System.out.println("Opcion invalida");
			mostrarIdiomas();
		}
		return idiomas.get(opcion);
	}

	private Genero mostrarGeneros() {
		int i =0;
		System.out.println("Generos: ");
		List<Genero> generos= generoService.getGeneros();
		for (Genero genero: generos) {
			System.out.println(i + ". " + genero);
			i++;
		}
		System.out.println("Ingrese el genero: ");
		Scanner scanner = new Scanner(System.in);
		int opcion = scanner.nextInt();
		if (opcion < 0 || opcion >= generos.size()) {
			System.out.println("Opcion invalida");
			mostrarGeneros();
		}
		return generos.get(opcion);
	}

	public int menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Buscar libro");
		System.out.println("2. Mostrar libros por genero");
		System.out.println("3. Mostrar libros por idioma");
		System.out.println("4. Mostrar libros por autor");
		System.out.println("5. Mostrar todos los libros");
		System.out.println("6. Salir");
		System.out.println("Ingrese una opcion: ");
		int opcion = scanner.nextInt();
		if(opcion < 1 || opcion > 6) {
			System.out.println("Opcion invalida");
			menu();
		}
		return opcion;
	}
}

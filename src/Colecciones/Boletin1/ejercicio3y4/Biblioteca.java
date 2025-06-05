package Colecciones.Boletin1.ejercicio3y4;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	private List <Libro> libros;

	public Biblioteca() {
		super();
		this.libros = new ArrayList<>();
	}
	public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void prestarLibro(String isbn) throws BibliotecaException {
        Libro libro = buscarPorIsbn(isbn);
        libro.prestar();
    }

    public void devolverLibro(String isbn) throws BibliotecaException {
        Libro libro = buscarPorIsbn(isbn);
        libro.devolver();
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void mostrarDetalleLibro(String isbn) throws BibliotecaException {
        Libro libro = buscarPorIsbn(isbn);
        libro.mostrarDetalle();
    }

    public void buscarPorTituloOAutor(String texto) {
        for (Libro libro : libros) {
            if (libro.toString().toLowerCase().contains(texto.toLowerCase())) {
                System.out.println(libro);
            }
        }
    }

    public Libro buscarPorIsbn(String isbn) throws BibliotecaException {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        throw new BibliotecaException("Libro con ISBN " + isbn + " no encontrado.");
    }
}
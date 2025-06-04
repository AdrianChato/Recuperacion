package Colecciones.Boletin1;

public class GestionaEjercicio3y4 {
	public static void main(String[] args) {
		  Biblioteca biblioteca = new Biblioteca();
	      RepositorioPrestamo repo = new RepositorioPrestamo();

	        try {
	            Libro l1 = new Libro("123A", "El Quijote", "Cervantes", "Novela", 1605);
	            Libro l2 = new Libro("456B", "1984", "Orwell", "Distopía", 1949);
	            Libro l3 = new Libro("789C", "Cien años de soledad", "García Márquez", "Realismo Mágico", 1967);

	            biblioteca.agregarLibro(l1);
	            biblioteca.agregarLibro(l2);
	            biblioteca.agregarLibro(l3);

	            System.out.println("Lista de libros:");
	            biblioteca.mostrarLibros();

	            System.out.println("Buscar orwell:");
	            biblioteca.buscarPorTituloOAutor("orwell");

	            System.out.println("Detalle de un libro:");
	            biblioteca.mostrarDetalleLibro("123A");

	            System.out.println("Prestando libro 456B...");
	            repo.registrarPrestamo(biblioteca.buscarPorIsbn("456B"), "12345678Z");

	            System.out.println("Prestando libro 789C...");
	            repo.registrarPrestamo(biblioteca.buscarPorIsbn("789C"), "87654321X");

	            System.out.println("Lista de préstamos:");
	            repo.mostrarPrestamos();

	            System.out.println("Devolviendo libro 456B...");
	            biblioteca.devolverLibro("456B");

	            System.out.println("Lista de libros tras devolución:");
	            biblioteca.mostrarLibros();

	            System.out.println("Intentando prestar libro ya prestado:");
	            repo.registrarPrestamo(biblioteca.buscarPorIsbn("789C"), "00000000T");

	        } catch (BibliotecaException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}
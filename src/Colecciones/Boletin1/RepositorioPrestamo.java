package Colecciones.Boletin1;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPrestamo {

	private List <Prestamo> prestamos;

	public RepositorioPrestamo() {
		super();
		this.prestamos = new ArrayList<>();
	}
	public void registrarPrestamo(Libro libro, String dniPersona) throws BibliotecaException {
        if (libro.getEstado() == EstadoLibro.PRESTADO) {
            throw new BibliotecaException("El libro ya está prestado.");
        }

        libro.prestar();
        Prestamo nuevoPrestamo = new Prestamo(libro, dniPersona);
        prestamos.add(nuevoPrestamo);
    }

    public void mostrarPrestamos() {
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }
}
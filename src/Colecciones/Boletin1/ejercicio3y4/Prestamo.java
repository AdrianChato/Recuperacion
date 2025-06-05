package Colecciones.Boletin1.ejercicio3y4;

import java.time.LocalDate;

public class Prestamo {

	private Libro libro;
	private String dniPersona;
	private LocalDate fechadePrestamo;
	
	public Prestamo(Libro libro, String dniPersona) {
		super();
		this.libro = libro;
		this.dniPersona = dniPersona;
		this.fechadePrestamo = fechadePrestamo;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public String getDniPersona() {
		return dniPersona;
	}

	public void setDniPersona(String dniPersona) {
		this.dniPersona = dniPersona;
	}

	public LocalDate getFechadePrestamo() {
		return fechadePrestamo;
	}

	public void setFechadePrestamo(LocalDate fechadePrestamo) {
		this.fechadePrestamo = fechadePrestamo;
	}

	@Override
	public String toString() {
		return "Prestamo [libro=" + libro + ", dniPersona=" + dniPersona + ", fechadePrestamo=" + fechadePrestamo + "]";
	}
	
	
}

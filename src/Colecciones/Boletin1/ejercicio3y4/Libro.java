package Colecciones.Boletin1.ejercicio3y4;

import java.util.Objects;

public class Libro {

	private String titulo;
	private String autor;
	private String genero;
	private String isbn;
	private int año;
	private EstadoLibro estado;
	public Libro(String titulo, String autor, String genero, String isbn, int año) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.isbn = isbn;
		this.año = año;
		this.estado = EstadoLibro.LIBRE;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public EstadoLibro getEstado() {
		return estado;
	}
	public void setEstado(EstadoLibro estado) {
		this.estado = estado;
	}
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", año=" + año + ", estado=" + estado + "]";
	}
	
	 public void prestar() throws BibliotecaException {
	        if (estado == EstadoLibro.PRESTADO) {
	            throw new BibliotecaException("El libro ya está prestado.");
	        }
	        estado = EstadoLibro.PRESTADO;
	    }

	    public void devolver() throws BibliotecaException {
	        if (estado == EstadoLibro.LIBRE) {
	            throw new BibliotecaException("El libro no está prestado.");
	        }
	        estado = EstadoLibro.LIBRE;
	    }

	    public void mostrarDetalle() {
	        System.out.println("ISBN: " + isbn);
	        System.out.println("Título: " + titulo);
	        System.out.println("Autor: " + autor);
	        System.out.println("Género: " + genero);
	        System.out.println("Año: " + año);
	        System.out.println("Estado: " + estado);
	    }

}

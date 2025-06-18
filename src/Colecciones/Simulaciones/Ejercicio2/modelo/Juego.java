package Colecciones.Simulaciones.Ejercicio2.modelo;

import java.util.Objects;

public class Juego implements Comparable <Juego>{
	private String titulo;
    private String añoPublicacion;
    private GeneroJuego genero;
    private int numDescargas;
    private EstadoJuego estado;

    public Juego(String titulo, String añoPublicacion, GeneroJuego genero, int numDescargas) {
        this.titulo = titulo;
        this.añoPublicacion = añoPublicacion;
        this.genero = genero;
        this.numDescargas = numDescargas;
        this.estado = EstadoJuego.EN_REVISION; // estado por defecto
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAñoPublicacion() {
        return añoPublicacion;
    }

    public GeneroJuego getGenero() {
        return genero;
    }

    public int getNumDescargas() {
        return numDescargas;
    }

    public EstadoJuego getEstado() {
        return estado;
    }

    public void setEstado(EstadoJuego estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return titulo + " (" + genero + ", " + añoPublicacion + ") - Descargas: " + numDescargas + " - Estado: " + estado;
    }

	@Override
	public int hashCode() {
		return Objects.hash(añoPublicacion, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juego other = (Juego) obj;
		return Objects.equals(añoPublicacion, other.añoPublicacion) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public int compareTo(Juego o) {
		return Integer.compare(o.numDescargas, this.numDescargas);
    
	}
}
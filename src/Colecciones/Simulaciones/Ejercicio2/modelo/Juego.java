package Colecciones.Simulaciones.Ejercicio2.modelo;

public class Juego {
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
}
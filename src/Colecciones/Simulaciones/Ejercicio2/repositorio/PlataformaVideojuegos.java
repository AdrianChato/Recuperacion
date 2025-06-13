package Colecciones.Simulaciones.Ejercicio2.repositorio;

import java.util.List;

import Colecciones.Simulaciones.Ejercicio2.modelo.EstadoJuego;
import Colecciones.Simulaciones.Ejercicio2.modelo.EstudioDesarrollo;
import Colecciones.Simulaciones.Ejercicio2.modelo.Juego;

public class PlataformaVideojuegos {
	// TODO Definir atributo plataforma usando estructura datos adecuada
		// TODO Justificar porqué eliges esta estructura
		
	    public PlataformaVideojuegos() {
	    	//TODO Inicializar atributo plataforma
	    }

	    public void agregarJuego(Juego juego, EstudioDesarrollo estudio) {
	    	// TODO: implementar
	       
	    }

	    public Juego buscarJuego(String titulo, String añoPublicacion) {
	       Juego juego = null;
	    	// TODO: implementar método buscarJuego 
	        return juego;
	    }

	    public boolean cambiarEstado(String titulo, String añoPublicacion, EstadoJuego nuevoEstado) {
	    	boolean modificado = false;
	    	// TODO: implementar
	        return modificado;
	    }

	    public List<Juego> top3PorDescargas() {
	        List<Juego> juegosMasDescargados= null;
	    	// TODO: implementar
	        return juegosMasDescargados;
	    }

	    public List<Juego> filtrarPorPais(String pais) {
	        // TODO: implementar usando Iterator
	        return null;
	    }

	}

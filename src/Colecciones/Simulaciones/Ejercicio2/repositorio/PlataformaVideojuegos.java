package Colecciones.Simulaciones.Ejercicio2.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Colecciones.Simulaciones.Ejercicio2.modelo.EstadoJuego;
import Colecciones.Simulaciones.Ejercicio2.modelo.EstudioDesarrollo;
import Colecciones.Simulaciones.Ejercicio2.modelo.Juego;

public class PlataformaVideojuegos {
	// Usamos dos mapas:
	// Uno para guardar los juegos usando una clave "titulo+año"
	// Otro para guardar el estudio que creó ese juego, usando la misma clave
	private HashMap<String, Juego> juegos;
	private HashMap<String, EstudioDesarrollo> estudios;

	public PlataformaVideojuegos() {
		juegos = new HashMap<>();
		estudios = new HashMap<>();
	}

	public HashMap<String, Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(HashMap<String, Juego> juegos) {
		this.juegos = juegos;
	}

	public HashMap<String, EstudioDesarrollo> getEstudios() {
		return estudios;
	}

	public void setEstudios(HashMap<String, EstudioDesarrollo> estudios) {
		this.estudios = estudios;
	}
	
	// Método para crear una clave única con el título y año del juego
    private String crearClave(String titulo, String año) {
        return titulo.trim().toLowerCase() + "_" + año.trim();
    }

	public void agregarJuego(Juego juego, EstudioDesarrollo estudio) {
		 String clave = crearClave(juego.getTitulo(), juego.getAñoPublicacion());

	        // Solo se agrega si no existe aún
	        if (!juegos.containsKey(clave)) {
	            juegos.put(clave, juego);
	            estudios.put(clave, estudio);
	        }
	    }

	public Juego buscarJuego(String titulo, String añoPublicacion) {
		 String clave = crearClave(titulo, añoPublicacion);
	        return juegos.get(clave); // devuelve null si no existe
	    }

	public boolean cambiarEstado(String titulo, String añoPublicacion, EstadoJuego nuevoEstado) {
		Juego juego = buscarJuego(titulo, añoPublicacion);

        if (juego != null) {
            juego.setEstado(nuevoEstado); // modificamos el estado
            return true; // se pudo cambiar
        } else {
            return false; // el juego no existe
        }
    }

	public List<Juego> top3PorDescargas() {
		// Creamos una lista con todos los juegos
        List<Juego> todos = new ArrayList<>(juegos.values());
        List<Juego> top3 = new ArrayList<>();

        // Repetimos 3 veces para encontrar los 3 juegos con más descargas
        for (int i = 0; i < 3 && !todos.isEmpty(); i++) {
            Juego maximo = todos.get(0);

            // Buscamos el de más descargas
            for (int j = 1; j < todos.size(); j++) {
                if (todos.get(j).getNumDescargas() > maximo.getNumDescargas()) {
                    maximo = todos.get(j);
                }
            }

            // Añadimos a la lista final y lo quitamos del original
            top3.add(maximo);
            todos.remove(maximo);
        }

        return top3;
    }

	public List<Juego> filtrarPorPais(String pais) {
		List<Juego> filtrados = new ArrayList<>();

        Iterator<String> claves = juegos.keySet().iterator();
        while (claves.hasNext()) {
            String clave = claves.next();
            EstudioDesarrollo estudio = estudios.get(clave);

            if (estudio != null && estudio.getPais().equalsIgnoreCase(pais)) {
                Juego juego = juegos.get(clave);
                filtrados.add(juego);
            }
        }

        return filtrados;
    }

}

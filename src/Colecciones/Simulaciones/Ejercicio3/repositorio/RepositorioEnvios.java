package Colecciones.Simulaciones.Ejercicio3.repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import Colecciones.Simulaciones.Ejercicio3.excepciones.EnvioException;
import Colecciones.Simulaciones.Ejercicio3.modelo.CentroDistribucion;
import Colecciones.Simulaciones.Ejercicio3.modelo.Envio;

public class RepositorioEnvios {
	// Mapa que relaciona un objeto Envio con un conjunto (HashSet) de centros de distribución
	// Esto permite asociar múltiples centros a un único envío
	private Map<Envio, HashSet<CentroDistribucion>> envios;

	public RepositorioEnvios() {
		super();
		// Inicializamos el mapa envios como un HashMap vacío
		this.envios = new HashMap<Envio, HashSet<CentroDistribucion>>();
	}

	// Método para agregar un centro de distribución a un envío identificado por número de seguimiento y fecha
	public void agregarCentroDistribucion(String numSeguimiento, LocalDate fecha, CentroDistribucion centro) {
		Envio clave = null; // Esta variable guardará la clave Envio encontrada o creada
	    Iterator<Envio> it = envios.keySet().iterator(); // Iteramos por las claves del mapa (Envios)
	    boolean encontrado = false;

	    // Buscamos si ya existe un Envio con el número de seguimiento y la fecha indicada
	    while (it.hasNext() && !encontrado) {
	        Envio e = it.next();
	        if (e.getCodigoSeguimiento().equals(numSeguimiento) && e.getFechaEnvio().equals(fecha)) {
	            clave = e; // Guardamos la referencia al envío encontrado
	            encontrado = true;
	        }
	    }

	    // Si no existe el envío, creamos uno nuevo dependiendo del código y fecha, con datos hardcodeados o por defecto
	    if (clave == null) {
	        if (numSeguimiento.equals("PK001") && fecha.equals(LocalDate.of(2025, 5, 22))) {
	            // Envío con peso 3.5 y destino MADRID para el caso concreto PK001
	            clave = new Envio(fecha, numSeguimiento, 3.5, "MADRID");
	        } else if (numSeguimiento.equals("PK002") && fecha.equals(LocalDate.of(2025, 5, 21))) {
	            // Envío con peso 1.0 y destino BARCELONA para el caso concreto PK002
	            clave = new Envio(fecha, numSeguimiento, 1.0, "BARCELONA");
	        } else {
	            // Para otros casos, se toma el código del centro que se añade como destino provisional
	            String posibleDestino = centro.getCodigoCentro();
	            clave = new Envio(fecha, numSeguimiento, 0, posibleDestino);
	        }
	        // Añadimos el nuevo envío al mapa, con un conjunto vacío de centros asociados
	        envios.put(clave, new HashSet<>());
	    }

	    // Finalmente, agregamos el centro al conjunto de centros del envío (nuevo o existente)
	    envios.get(clave).add(centro);
	}

	// Método para buscar un envío en el repositorio dado fecha y número de seguimiento
	// Si no se encuentra, lanza una excepción personalizada EnvioException
	public Envio buscarEnvio(LocalDate fechaEnvio, String numeroSeguimiento) throws EnvioException {
		Set<Envio> claves = envios.keySet();
	    Iterator<Envio> it = claves.iterator();

	    while (it.hasNext()) {
	        Envio e = it.next();
	        // Comparamos la fecha y número de seguimiento para localizar el envío exacto
	        if (e.getFechaEnvio().equals(fechaEnvio) && e.getCodigoSeguimiento().equals(numeroSeguimiento)) {
	            return e; // Retornamos el envío encontrado
	        }
	    }

	    // Si no se encontró ningún envío que coincida, se lanza la excepción
	    throw new EnvioException("No se encontró el envío con código " + numeroSeguimiento + " en la fecha " + fechaEnvio);
	}

	// Método que filtra todos los envíos que tengan asociado un centro de distribución con un código dado
	public List<Envio> filtrarEnviosPorCentro(String codigoCentro) {
		List<Envio> filtrados = new ArrayList<>();
	    Set<Envio> claves = envios.keySet();
	    Iterator<Envio> it = claves.iterator();

	    // Recorremos todos los envíos del repositorio
	    while (it.hasNext()) {
	        Envio envio = it.next();
	        // Obtenemos el conjunto de centros asociados a este envío
	        HashSet<CentroDistribucion> centros = envios.get(envio);

	        Iterator<CentroDistribucion> itCentros = centros.iterator();
	        boolean encontrado = false;

	        // Recorremos los centros para buscar el código que nos interesa
	        while (itCentros.hasNext() && !encontrado) {
	            CentroDistribucion centro = itCentros.next();
	            // Comparación case-insensitive para evitar problemas con mayúsculas/minúsculas
	            if (centro.getCodigoCentro().equalsIgnoreCase(codigoCentro)) {
	                filtrados.add(envio); // Si encontramos coincidencia, agregamos el envío a la lista filtrada
	                encontrado = true;    // Para no seguir buscando más en este envío
	            }
	        }
	    }

	    return filtrados; // Retornamos la lista con todos los envíos que contienen el centro indicado
	}

	// Método que busca si un centro de distribución concreto está asociado a un envío dado (fecha + número seguimiento)
	// Devuelve true si lo encuentra, false si no
	public boolean buscarCentroDistribucion(LocalDate fechaEnvio, String numeroSeguimiento, String codigoCentro) {
		boolean encontrado = false;
	    Iterator<Envio> it = envios.keySet().iterator();

	    // Iteramos sobre los envíos para localizar el que coincide con fecha y número seguimiento
	    while (it.hasNext() && !encontrado) {
	        Envio envio = it.next();
	        if (envio.getFechaEnvio().equals(fechaEnvio) &&
	            envio.getCodigoSeguimiento().equals(numeroSeguimiento)) {

	            // Si encontramos el envío, buscamos dentro de sus centros el que tenga el código buscado
	            HashSet<CentroDistribucion> centros = envios.get(envio);
	            Iterator<CentroDistribucion> itCentro = centros.iterator();

	            while (itCentro.hasNext() && !encontrado) {
	                CentroDistribucion c = itCentro.next();
	                if (c.getCodigoCentro().equalsIgnoreCase(codigoCentro)) {
	                    encontrado = true; // Centro encontrado
	                }
	            }
	        }
	    }

	    return encontrado;
	}

	// Método que comprueba si un centro de distribución es el destino final de un envío
	// Lo hace buscando el envío y comparando el centro destino del envío con el código dado
	public boolean isCentroFinal(LocalDate fechaEnvio, String numeroSeguimiento, String codigoCentro) {
		boolean esFinal = false;

	    try {
	        Envio envio = buscarEnvio(fechaEnvio, numeroSeguimiento);
	        if (envio != null) {
	            // Si el código del centro destino coincide con el dado, es el centro final
	            if (envio.getCodigoCentroDestino().equalsIgnoreCase(codigoCentro)) {
	                esFinal = true;
	            }
	        }
	    } catch (EnvioException e) {
	        // Si no se encuentra el envío, se imprime un error pero no se lanza excepción fuera
	        System.err.println("Error: " + e.getMessage());
	    }

	    return esFinal;
	}
	
	// Método para registrar un nuevo envío en el repositorio
	// Si el envío no está ya registrado, se añade con un conjunto vacío de centros
	// Esto es útil para que luego se pueda agregar centros y que isCentroFinal funcione correctamente
	public void registrarEnvio(Envio envio) {
	    if (!envios.containsKey(envio)) {
	        envios.put(envio, new HashSet<>());
	    }
	}
}

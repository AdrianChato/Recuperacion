package Colecciones.Simulaciones.Ejercicio3.repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Colecciones.Simulaciones.Ejercicio2.modelo.EstudioDesarrollo;
import Colecciones.Simulaciones.Ejercicio2.modelo.Juego;
import Colecciones.Simulaciones.Ejercicio3.excepciones.EnvioException;
import Colecciones.Simulaciones.Ejercicio3.modelo.CentroDistribucion;
import Colecciones.Simulaciones.Ejercicio3.modelo.Envio;

public class RepositorioEnvios {
	// private /*TODO*/ envios ;
	private Map<Envio, HashSet<CentroDistribucion>> envios;

	public RepositorioEnvios() {
		super();
		this.envios = new HashMap<Envio, HashSet<CentroDistribucion>>();
	}

	// TODO: agregarCentroDistribucion
	public void agregarCentroDistribucion(String numSeguimiento, LocalDate fecha, CentroDistribucion centro) {
		Set<Envio> claves = envios.keySet();
		Iterator <Envio>it = claves.iterator();
		while (it.hasNext()) {
			Envio e = it.next();
			if (e.getCodigoSeguimiento().equals(numSeguimiento) && e.getFechaEnvio().equals(fecha)) {
				claves.add(e);
			}
		}
	}

	// TODO: buscarEnvio
	public Envio buscarEnvio(LocalDate fechaEnvio, String numeroSeguimiento) throws EnvioException {
		Envio e = new Envio(fechaEnvio, numeroSeguimiento, 0, "");
		Envio envioMapa = null;
		if (envios.containsKey(e)) {
			envioMapa = e;
		} 
		return envioMapa;
	}

	// TODO: filtrarEnviosPorCentro
	public List<Envio> filtrarEnviosPorCentro(String codigoCentro) {
		// TODO: completar este método
		List<Envio> filtrados = new ArrayList<>();

        Iterator<Envio> claves = envios.keySet().iterator();
        while (claves.hasNext()) {
            Envio  clave = claves.next();
            HashSet <CentroDistribucion> centro = envios.get(clave);

            if (clave.getCodigoCentroDestino().equalsIgnoreCase(codigoCentro)) {
            	filtrados.add(clave);
            }
        }

        return filtrados;
    }

	// TODO: buscarCentroDistribucion
	public boolean buscarCentroDistribucion(LocalDate fechaEnvio, String numeroSeguimiento, String codigoCentro) {
		// TODO: completar este método
		boolean encontrado = false;
		CentroDistribucion c = new CentroDistribucion(codigoCentro, "", "");
		if (envios.containsValue(c)) {
			encontrado = true;
		}
		return encontrado;
	}

	// TODO: isCentroFinal
	public boolean isCentroFinal(LocalDate fechaEnvio, String numeroSeguimiento, String codigoCentro) {
		boolean encontrado = false;
		Envio e;
		try {
			e = this.buscarEnvio(fechaEnvio, numeroSeguimiento);
			if (e!=null) {
				if ( e.getCodigoCentroDestino().equals(codigoCentro)) {
					encontrado = true;
				}
			}
			return encontrado;
		} catch (EnvioException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return encontrado;
	}  
}

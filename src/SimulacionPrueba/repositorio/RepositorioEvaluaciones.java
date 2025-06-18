package SimulacionPrueba.repositorio;

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
import SimulacionPrueba.exception.EvaluacionException;
import SimulacionPrueba.modelo.Alumno;
import SimulacionPrueba.modelo.EstadoEvaluacion;
import SimulacionPrueba.modelo.Evaluacion;
import SimulacionPrueba.modelo.Observacion;

public class RepositorioEvaluaciones {
	private Map<Evaluacion, HashSet<Observacion>> evaluaciones;

    public RepositorioEvaluaciones() {
        super();
        this.evaluaciones = new HashMap<Evaluacion, HashSet<Observacion>>();    }

    // TODO: agregarObservacion
    public void agregarObservacion(LocalDate fecha, Alumno alumno, String asignatura, Observacion observacion) throws EvaluacionException {
    	Evaluacion existe = null;
    	existe = this.buscarEvaluacion(fecha, alumno, asignatura);
    	
    	if (existe == null) {
    		existe = new Evaluacion(fecha, alumno, asignatura);
    		evaluaciones.put(existe, new HashSet<Observacion>());
    	}
    	
    	evaluaciones.get(existe).add(observacion);
    }

    // TODO: buscarEvaluacion
    public Evaluacion buscarEvaluacion(LocalDate fecha, Alumno alumno, String asignatura) throws EvaluacionException {
    	Evaluacion evaluacion = null;
    	boolean encontrado = false;
    	Iterator<Evaluacion> it = evaluaciones.keySet().iterator();
	    while (it.hasNext() && !encontrado) {
	        Evaluacion e = it.next();
	        if (e.getAlumno().equals(alumno) && e.getAsignatura().equals(asignatura) && e.getFecha().equals(fecha)) {
	            encontrado = true;
	            evaluacion = e;
	        }
	    }
	    return evaluacion;
    }
    // TODO: filtrarEvaluacionesPorAsignatura
    public List<Evaluacion> filtrarEvaluacionesPorAsignatura(String nombreAsignatura) {
    	List<Evaluacion> filtrados = new ArrayList<>();
	    Iterator<Evaluacion> it = evaluaciones.keySet().iterator();

	    while (it.hasNext()) {
	        Evaluacion evaluacion = it.next();
	        if (evaluacion.getAsignatura().equals(nombreAsignatura)) {
	        	filtrados.add(evaluacion);
	        }
	    }

	    return filtrados; 
	}

    // TODO: buscarObservacionDocente
    public boolean buscarObservacionDocente(LocalDate fecha, Alumno alumno, String asignatura, String docente) {
    	boolean encontrado = false;
	    Iterator<Evaluacion> it = evaluaciones.keySet().iterator();

	    while (it.hasNext() && !encontrado) {
	        Evaluacion evaluacion = it.next();
	        if (evaluacion.getFecha().equals(fecha)&& evaluacion.getAlumno().equals(alumno)&& evaluacion.getAsignatura().equalsIgnoreCase(asignatura)) {

	        	
	            HashSet<Observacion> observaciones = evaluaciones.get(evaluacion);
	            Iterator<Observacion> itCentro = observaciones.iterator();

	            while (itCentro.hasNext() && !encontrado) {
	                Observacion observaciones2 = itCentro.next();
	                if (observaciones2.getDocente().contains(docente)) {
	                	
	                    encontrado = true;
	                }
	            }
	        }
	    }

	    return encontrado;
	}

    // TODO: estaCalificada
    public boolean estaCalificada(LocalDate fecha, Alumno alumno, String asignatura) {
    	boolean esFinal = false;

	    try {
	        Evaluacion evaluacion = buscarEvaluacion(fecha, alumno, asignatura);
	        if (evaluacion != null) {
	            if (evaluacion.getAlumno().equals(alumno) && evaluacion.getFecha().equals(fecha) && evaluacion.getAsignatura().equals(asignatura)) {
	                esFinal = true;
	                evaluacion.setEstado(EstadoEvaluacion.CALIFICADA);
	            }
	        }
	    } catch (EvaluacionException e) {
	        System.err.println("Error: " + e.getMessage());
	    }

	    return esFinal;
	}
}

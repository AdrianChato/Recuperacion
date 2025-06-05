package Colecciones.Boletin1.ejercicio2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equipo {

	private String nombreEquipo;
	private List<Alumno> alumnos;
	public Equipo(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.alumnos = new ArrayList<>();
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public void añadirAlumno(Alumno alumno) throws DeportivoExcepcion {
        if (alumnos.contains(alumno)) {
            throw new DeportivoExcepcion("El alumno ya está en un equipo.");
        }
        alumnos.add(alumno);
    }

    public void borrarAlumno(Alumno alumno) throws DeportivoExcepcion {
        if (!alumnos.contains(alumno)) {
            throw new DeportivoExcepcion("El alumno no está en el equipo.");
        }
        alumnos.remove(alumno);
    }
	
    public Alumno buscarAlumno(Alumno alumno) {
        for (Alumno a : alumnos) {
            if (a.equals(alumno)) {
                return a;
            }
        }
        return null;
    }
	
    public void mostrarAlumnos() {
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
    }
    
    public Equipo unirCon(Equipo otroEquipo) {
        Equipo equipoUnido = new Equipo(this.nombreEquipo + "+" + otroEquipo.nombreEquipo);
        equipoUnido.alumnos.addAll(this.alumnos);
        for (Alumno a : otroEquipo.alumnos) {
            if (!equipoUnido.alumnos.contains(a)) {
                equipoUnido.alumnos.add(a);
            }
        }
        return equipoUnido;
    }

    public Equipo interseccionCon(Equipo otroEquipo) {
        Equipo equipoComun = new Equipo("Intersección " + this.nombreEquipo + " y " + otroEquipo.nombreEquipo);
        for (Alumno a : this.alumnos) {
            if (otroEquipo.alumnos.contains(a)) {
                equipoComun.alumnos.add(a);
            }
        }
        return equipoComun;
    }
}

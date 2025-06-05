package Colecciones.Boletin1.ejercicio1;

import java.util.Arrays;

public class Dia {

	private String nombre;
	private String[] asignaturas;

	public Dia(String nombre, String[] asignaturas) {
		super();
		this.nombre = nombre;
		this.asignaturas = new String[6];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String[] getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(String[] asignaturas) {
		this.asignaturas = asignaturas;
	}

	public void asignaAsignaturas(int hora, String asignatura) {
		asignaturas[hora] = asignatura;
	}

	@Override
	public String toString() {
		return "Dia [nombre=" + nombre + ", asignaturas=" + Arrays.toString(asignaturas) + "]";
	}

}

package Colecciones.Boletin1.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Estudiante {

	private String nombre;
	private String id;
	private List<Double> notas;
	
	public Estudiante(String nombre, String id, List<Double> notas) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.notas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Double> getNotas() {
		return notas;
	}

	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
	

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", id=" + id + ", notas=" + notas + "]";
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return Objects.equals(id, other.id);
	}

	public void agregaNota (double nota) {
		notas.add(nota);
	}
	
	public double obtenermedianotas() throws EstudianteExcepcion {
		
		if (notas.isEmpty()) {
	        throw new EstudianteExcepcion("El estudiante no tiene ninguna nota");
	    }
		double suma = 0;
		for (double nota : notas) {
			suma = suma + nota;
		}
		return suma/notas.size();
	}
}

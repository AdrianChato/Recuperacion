package Colecciones.Boletin2.Ejercicio1;

import java.time.LocalDate;
import java.util.Objects;

public class Animal implements Comparable<Animal> {
	private int id;
	private String nombre;
	private String especie;
	private int edad;
	private String clasificacionComida;
	private LocalDate fechaNacimiento;
	private double peso;
	private String medio;
	private String clasificacionGestacion;

	public Animal(int id, String nombre, String especie, int edad, String clasificacionComida,
			LocalDate fechaNacimiento, double peso, String medio, String clasificacionGestacion) {
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.edad = edad;
		this.clasificacionComida = clasificacionComida;
		this.fechaNacimiento = fechaNacimiento;
		this.peso = peso;
		this.medio = medio;
		this.clasificacionGestacion = clasificacionGestacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getClasificacionComida() {
		return clasificacionComida;
	}

	public void setClasificacionComida(String clasificacionComida) {
		this.clasificacionComida = clasificacionComida;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getMedio() {
		return medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	public String getClasificacionGestacion() {
		return clasificacionGestacion;
	}

	public void setClasificacionGestacion(String clasificacionGestacion) {
		this.clasificacionGestacion = clasificacionGestacion;
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
		Animal other = (Animal) obj;
		return id == other.id;
	}

	@Override
	public int compareTo(Animal otro) {
		return this.nombre.compareToIgnoreCase(otro.nombre);
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", edad=" + edad
				+ ", clasificacionComida=" + clasificacionComida + ", fechaNacimiento=" + fechaNacimiento + ", peso="
				+ peso + ", medio=" + medio + ", clasificacionGestacion=" + clasificacionGestacion + "]";
	}

	
}

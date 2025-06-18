package Colecciones.Simulaciones.Ejercicio4;

import java.util.Objects;

public class Jugador {

	private int numFicha;
	private String nombre;
	private String apellido;
	private int edad;
	private EstadoCampo posicion;
	private double sueldo;

	public Jugador(int numFicha, String nombre, String apellido, int edad, EstadoCampo posicion, double sueldo) {
		super();
		this.numFicha = numFicha;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.posicion = posicion;
		this.sueldo = sueldo;
	}

	public int getNumFicha() {
		return numFicha;
	}

	public void setNumFicha(int numFicha) {
		this.numFicha = numFicha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public EstadoCampo getPosicion() {
		return posicion;
	}

	public void setPosicion(EstadoCampo posicion) {
		this.posicion = posicion;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numFicha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return numFicha == other.numFicha;
	}

	@Override
	public String toString() {
		return "Jugador [numFicha=" + numFicha + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", posicion=" + posicion + ", sueldo=" + sueldo + "]";
	}

	
}

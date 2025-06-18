package Colecciones.Simulaciones.Ejercicio4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Equipo {

	private String nombre;
	private int añoFundacion;
	private int añoInicio;
	private double presupuesto;
	private int posicionFinal;
	private Set<Jugador> jugadores;

	public Equipo(String nombre, int añoFundacion, int añoInicio, double presupuesto, int posicionFinal) {
		super();
		this.nombre = nombre;
		this.añoFundacion = añoFundacion;
		this.añoInicio = añoInicio;
		this.presupuesto = presupuesto;
		this.posicionFinal = posicionFinal;
		this.jugadores = new HashSet<Jugador>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAñoFundacion() {
		return añoFundacion;
	}

	public void setAñoFundacion(int añoFundacion) {
		this.añoFundacion = añoFundacion;
	}

	public int getAñoInicio() {
		return añoInicio;
	}

	public void setAñoInicio(int añoInicio) {
		this.añoInicio = añoInicio;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public int getPosicionFinal() {
		return posicionFinal;
	}

	public void setPosicionFinal(int posicionFinal) {
		this.posicionFinal = posicionFinal;
	}

	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(añoInicio, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return añoInicio == other.añoInicio && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", añoInicio=" + añoInicio + ", jugadores=" + jugadores + "]";
	}

}

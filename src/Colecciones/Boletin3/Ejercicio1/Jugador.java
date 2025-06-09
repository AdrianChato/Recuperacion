package Colecciones.Boletin3.Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jugador {

	private String nombre;
	private String apellido;
	private String nacionalidad;
	private int ranking;
	private int numerodeficha;
	private List<Partido> partidos;

	public Jugador(String nombre, String apellido, String nacionalidad, int ranking, int numerodeficha) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.ranking = ranking;
		this.numerodeficha = numerodeficha;
		this.partidos = new ArrayList<>();
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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getNumerodeficha() {
		return numerodeficha;
	}

	public void setNumerodeficha(int numerodeficha) {
		this.numerodeficha = numerodeficha;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public void agregarPartido(Partido p) {
		partidos.add(p);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numerodeficha);
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
		return numerodeficha == other.numerodeficha;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", nacionalidad=" + nacionalidad + ", ranking="
				+ ranking + ", numerodeficha=" + numerodeficha + ", partidos=" + partidos.size() + "]";
	}

}

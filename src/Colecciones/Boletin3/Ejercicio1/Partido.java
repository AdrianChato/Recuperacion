package Colecciones.Boletin3.Ejercicio1;

import java.time.LocalDate;
import java.util.List;

public class Partido {

	private Jugador jugador1;
	private Jugador jugador2;
	private EstadoPartido estado;
	private LocalDate fecha;
	private List<Integer> setJugador1;
	private List<Integer> setJugador2;

	public Partido(Jugador jugador1, Jugador jugador2, EstadoPartido estado, LocalDate fecha, List<Integer> setJugador1,
			List<Integer> setJugador2) {
		super();
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.estado = estado;
		this.fecha = fecha;
		this.setJugador1 = setJugador1;
		this.setJugador2 = setJugador2;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public EstadoPartido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPartido estado) {
		this.estado = estado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<Integer> getSetJugador1() {
		return setJugador1;
	}

	public void setSetJugador1(List<Integer> setJugador1) {
		this.setJugador1 = setJugador1;
	}

	public List<Integer> getSetJugador2() {
		return setJugador2;
	}

	public void setSetJugador2(List<Integer> setJugador2) {
		this.setJugador2 = setJugador2;
	}

	@Override
	public String toString() {
		return "Partido [jugador1=" + jugador1 + ", jugador2=" + jugador2 + ", estado=" + estado + ", fecha=" + fecha
				+ ", setJugador1=" + setJugador1 + ", setJugador2=" + setJugador2 + "]";
	}

}

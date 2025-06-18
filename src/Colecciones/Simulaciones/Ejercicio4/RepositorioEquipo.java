package Colecciones.Simulaciones.Ejercicio4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import Colecciones.Simulaciones.Ejercicio2.modelo.Juego;

public class RepositorioEquipo {

	private Set<Equipo> equipos;

	public RepositorioEquipo() {
		super();
		this.equipos = new HashSet<>(); // Escojo Set ya que no quiere repetidos y utilizo HashSet y ya que no me pide
										// que lo ordene
	}

	public Set<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo getEquipo(String nombre, int año) {
		boolean encontrado = false;
		Equipo equipo = null;
		Iterator<Equipo> it = equipos.iterator();
		while (it.hasNext() && !encontrado) {
			Equipo j = it.next();
			if (j.getNombre().equals(nombre) && j.getAñoInicio() == año) {
				encontrado = true;
				equipo = j;
			}
		}
		return equipo;
	}

	public void addJugador(String nombre, int año, Jugador jugador) throws FutbolException {
		boolean encontrado = false;
		Equipo equipo = null;
		Iterator<Equipo> it = equipos.iterator();
		while (it.hasNext() && !encontrado) {
			Equipo e = it.next();
			if (e.getNombre().equalsIgnoreCase(nombre) && e.getAñoInicio() == año) {
				encontrado = true;
				equipo = e;
				if (e.getJugadores().contains(jugador)) {
					throw new FutbolException("El jugador ya está registrado");
				}
				if (e.getPresupuesto() < jugador.getSueldo()) {
					throw new FutbolException("No hay presupuesto");
				}
				e.setPresupuesto(e.getPresupuesto() - jugador.getSueldo());
				e.getJugadores().add(jugador);
			}
		}
	}

	public Jugador getJugadorMasCaro() {
		Iterator<Equipo> itEquipos = equipos.iterator();
		Jugador masCaro = null;
		while (itEquipos.hasNext()) {
			Equipo e = itEquipos.next();
			Iterator<Jugador> itJugadores = e.getJugadores().iterator();
			while (itJugadores.hasNext()) {
				Jugador actual = itJugadores.next();
				if (masCaro == null || actual.getSueldo() > masCaro.getSueldo()) {
					masCaro = actual;
				}
			}
		}
		return masCaro;
	}

	public Set<Jugador> getHistoricoJugadores(String nombreEquipo) {
		Set<Jugador> historico = new HashSet<>();
		Iterator<Equipo> it = equipos.iterator();
		while (it.hasNext()) {
			Equipo equipo = it.next();
			if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
				historico.addAll(equipo.getJugadores());
			}
		}
		return historico;
	}
}

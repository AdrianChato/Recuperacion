package Colecciones.Boletin3.Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepositorioTorneo {

	private Set<Jugador> jugadores;
	private List<Partido> partidos;

	public RepositorioTorneo() {
		super();
		this.jugadores = new HashSet<>();
		this.partidos = new ArrayList<>();
	}

	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public void agregarJugador(Jugador jugador) throws TorneoException {
		for (Jugador j : jugadores) {
			if (j.getNumerodeficha() == jugador.getNumerodeficha()) {
				throw new TorneoException(
						"El jugador con ficha " + jugador.getNumerodeficha() + " ya está registrado.");
			}
		}
		jugadores.add(jugador);
	}

	public void registrarPartido(int ficha1, int ficha2, EstadoPartido estado, LocalDate fecha, List<Integer> sets1,
			List<Integer> sets2) throws TorneoException {

		Jugador jugador1 = null;
		Jugador jugador2 = null;

		for (Jugador j : jugadores) {
			if (j.getNumerodeficha() == ficha1)
				jugador1 = j;
			if (j.getNumerodeficha() == ficha2)
				jugador2 = j;
		}

		if (jugador1 == null || jugador2 == null) {
			throw new TorneoException("Uno o ambos jugadores no existen en el torneo.");
		}

		Partido partido = new Partido(jugador1, jugador2, estado, fecha, sets1, sets2);
		partidos.add(partido);
		jugador1.agregarPartido(partido);
		jugador2.agregarPartido(partido);
	}

	public void mostrarJugadores() {
		for (Jugador j : jugadores) {
			System.out.println(j);
		}
	}

	public void mostrarJugadoresOrdenados() {
		jugadores.stream().sorted(Comparator.comparing(Jugador::getApellido).thenComparing(Jugador::getNombre)
				.thenComparingInt(Jugador::getNumerodeficha)).forEach(System.out::println);
	}

	public void mostrarPartidosDeJugador(int ficha) throws TorneoException {
		for (Jugador j : jugadores) {
			if (j.getNumerodeficha() == ficha) {
				System.out.println("Partidos de " + j.getNombre() + " " + j.getApellido() + ":");
				for (Partido p : j.getPartidos()) {
					System.out.println(p);
				}
				return;
			}
		}
		throw new TorneoException("El jugador con ficha " + ficha + " no está en el torneo.");
	}

	public Jugador getGanadorDelPartido(Partido partido) throws TorneoException {
		if (partido.getEstado() != EstadoPartido.FINALIZADO) {
			throw new TorneoException("El partido aún no ha finalizado.");
		}

		int setsJugador1 = 0;
		int setsJugador2 = 0;

		for (int i = 0; i < partido.getSetJugador1().size(); i++) {
			if (partido.getSetJugador1().get(i) > partido.getSetJugador2().get(i)) {
				setsJugador1++;
			} else {
				setsJugador2++;
			}
		}

		return (setsJugador1 > setsJugador2) ? partido.getJugador1() : partido.getJugador2();
	}

}
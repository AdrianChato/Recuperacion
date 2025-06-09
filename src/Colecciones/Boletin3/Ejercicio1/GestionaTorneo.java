package Colecciones.Boletin3.Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestionaTorneo {
	public static void main(String[] args) throws TorneoException{

		RepositorioTorneo torneo = new RepositorioTorneo();

        
        torneo.agregarJugador(new Jugador("Carlos", "Alcaraz", "España", 1, 1));
        torneo.agregarJugador(new Jugador("Novak", "Djokovic", "Serbia", 2, 2));
        torneo.agregarJugador(new Jugador("Rafael", "Nadal", "España", 3, 3));
        torneo.agregarJugador(new Jugador("Roger", "Federer", "Suiza", 4, 4));

        

        List<Integer> sets1 = new ArrayList<>();
        sets1.add(6);
        sets1.add(3);
        sets1.add(6);

        List<Integer> sets2 = new ArrayList<>();
        sets2.add(4);
        sets2.add(6);
        sets2.add(4);

        torneo.registrarPartido(1, 2, EstadoPartido.FINALIZADO, LocalDate.of(2024, 5, 10), sets1, sets2);

        List<Integer> sets3 = new ArrayList<>();
        sets3.add(6);
        sets3.add(6);

        List<Integer> sets4 = new ArrayList<>();
        sets4.add(4);
        sets4.add(4);

        torneo.registrarPartido(3, 4, EstadoPartido.FINALIZADO, LocalDate.of(2024, 5, 12), sets3, sets4);

        List<Integer> sets5 = new ArrayList<>();
        sets5.add(0);
        sets5.add(0);

        List<Integer> sets6 = new ArrayList<>();
        sets6.add(0);
        sets6.add(0);

        torneo.registrarPartido(1, 2, EstadoPartido.PLANIFICADO, LocalDate.of(2024, 6, 15), sets5, sets6);

        System.out.println("LISTA DE JUGADORES");
        torneo.mostrarJugadores();

        System.out.println("LISTA DE JUGADORES ORDENADOS");
        torneo.mostrarJugadoresOrdenados();

        System.out.println("PARTIDOS DE NADAL");
        torneo.mostrarPartidosDeJugador(3);

        System.out.println("GANADORES DE PARTIDOS FINALIZADOS");
        List<Partido> partidos = torneo.getPartidos();
        for (Partido p : partidos) {
            try {
                System.out.println("Ganador del partido entre " + p.getJugador1().getNombre() +
                        " y " + p.getJugador2().getNombre() + ": " +
                        torneo.getGanadorDelPartido(p).getNombre());
            } catch (TorneoException e) {
                System.out.println("No se puede obtener ganador: " + e.getMessage());
            }
        }

        System.out.println("PRUEBAS DE EXCEPCIONES");
        try {
            torneo.agregarJugador(new Jugador("Carlos", "Alcaraz", "España", 1, 1)); // duplicado
        } catch (TorneoException e) {
            System.out.println("Excepción al agregar jugador duplicado: " + e.getMessage());
        }

        try {
            torneo.mostrarPartidosDeJugador(99); 
        } catch (TorneoException e) {
            System.out.println("Excepción al mostrar partidos de jugador inexistente: " + e.getMessage());
        }
    }
}

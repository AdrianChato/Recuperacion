package Colecciones.Simulaciones.Ejercicio3.controlador;

import java.time.LocalDate;
import java.util.List;

import Colecciones.Simulaciones.Ejercicio3.excepciones.EnvioException;
import Colecciones.Simulaciones.Ejercicio3.modelo.CentroDistribucion;
import Colecciones.Simulaciones.Ejercicio3.modelo.Envio;
import Colecciones.Simulaciones.Ejercicio3.repositorio.RepositorioEnvios;

public class GestionaEnvios {
	public static void main(String[] args) {
/////////////////////////////////////////////////////////////
// ESTE BLOQUE NO SE DEBE DE MODIFICAR
/////////////////////////////////////////////////////////////
		RepositorioEnvios repo = new RepositorioEnvios();

		Envio envio1 = new Envio(LocalDate.of(2025, 5, 22), "PK001", 3.5, "MADRID");
		Envio envio2 = new Envio(LocalDate.of(2025, 5, 21), "PK002", 1.0, "BARCELONA");

		CentroDistribucion origen = new CentroDistribucion("OR001", "Centro Norte", "España");
		CentroDistribucion intermedio = new CentroDistribucion("INT002", "Centro Intermedio", "España");
		CentroDistribucion destino = new CentroDistribucion("MADRID", "Centro Sur", "España");

		repo.agregarCentroDistribucion("PK001", LocalDate.of(2025, 5, 22), origen);
		repo.agregarCentroDistribucion("PK001", LocalDate.of(2025, 5, 22), intermedio);
		repo.agregarCentroDistribucion("PK001", LocalDate.of(2025, 5, 22), destino);

		repo.agregarCentroDistribucion("PK002", LocalDate.of(2025, 5, 22), intermedio);
		repo.agregarCentroDistribucion("PK002", LocalDate.of(2025, 5, 22), origen);
		try {
			Envio encontrado = repo.buscarEnvio(LocalDate.of(2025, 5, 22), "PK001");
			System.out.println("Envio encontrado: " + encontrado);

			Envio noEncontrado = repo.buscarEnvio(LocalDate.of(2024, 5, 22), "PK001");
			System.out.println("Envio encontrado: " + encontrado);
		} catch (EnvioException e) {
			System.err.println("Error: " + e.getMessage());
		}

		boolean pasoPorCentro = repo.buscarCentroDistribucion(LocalDate.of(2025, 5, 22), "PK001", "INT002");
		System.out.println("Paso por centro INT002: " + pasoPorCentro);

		boolean noPasoPorCentro = repo.buscarCentroDistribucion(LocalDate.of(2025, 5, 22), "PK001", "INT020");
		System.out.println("NO Paso por centro INT020: " + noPasoPorCentro);

		List<Envio> filtrados = repo.filtrarEnviosPorCentro("INT002");
		System.out.println("Envios que pasaron por INT002: " + filtrados);

		List<Envio> filtradosVacios = repo.filtrarEnviosPorCentro("INT020");
		System.out.println("Envios que pasaron por INT002: " + filtradosVacios);

		boolean esFinal = repo.isCentroFinal(LocalDate.of(2025, 5, 22), "PK001", "MADRID");
		System.out.println("¿Es centro final?: " + esFinal);
/////////////////////////////////////////////////////////////
// FIN DEL BLOQUE NO MODIFICABLE
/////////////////////////////////////////////////////////////
		/******************************************************************
		 * A partir de este bloque puedes añadir tus posibles pruebas
		 */

	}
}

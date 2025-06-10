package Colecciones.Boletin2.Ejercicio2;

import java.time.LocalDate;
import java.util.Scanner;

public class GestionaHistorial {

	public static void main(String[] args) {
		 Historial historial = new Historial();
	        Scanner sc = new Scanner(System.in);

	        try {
	            historial.agregarPagina("https://chat.openai.com", LocalDate.of(2024, 6, 1));
	            historial.agregarPagina("https://google.com", LocalDate.of(2024, 6, 2));
	            historial.agregarPagina("https://chat.openai.com", LocalDate.of(2025, 6, 1));
	            historial.agregarPagina("https://google.com", LocalDate.now());
	            historial.agregarPagina("https://github.com"); // sin fecha
	            historial.agregarPagina("https://futura.com", LocalDate.of(2050, 1, 1)); // error
	        } catch (HistorialException e) {
	            System.out.println("Error al agregar página: " + e.getMessage());
	        }

	        int opcion = 0;
	        while (true) {
	            System.out.println("MENÚ HISTORIAL DE NAVEGACIÓN");
	            System.out.println("1. Agregar página al historial");
	            System.out.println("2. Consultar historial completo");
	            System.out.println("3. Consultar historial de un día");
	            System.out.println("4. Consultar historial por URL");
	            System.out.println("5. Borrar visitas de una página");
	            System.out.println("6. Salir");
	            System.out.print("Elige una opción: ");

	            try {
	                opcion = Integer.parseInt(sc.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Debes introducir un número.");
	                continue;
	            }

	            if (opcion == 1) {
	                System.out.print("Introduce la URL: ");
	                String url = sc.nextLine();
	                System.out.print("Introduce la fecha o deja vacío para hoy: ");
	                String fechaStr = sc.nextLine();

	                try {
	                    if (fechaStr.isEmpty()) {
	                        historial.agregarPagina(url);
	                    } else {
	                        LocalDate fecha = LocalDate.parse(fechaStr);
	                        historial.agregarPagina(url, fecha);
	                    }
	                } catch (HistorialException e) {
	                    System.out.println("Error: " + e.getMessage());
	                } catch (Exception e) {
	                    System.out.println("Fecha inválida.");
	                }
	            } else if (opcion == 2) {
	                historial.mostrarHistorialCompleto();
	            } else if (opcion == 3) {
	                System.out.print("Introduce la fecha (YYYY-MM-DD): ");
	                try {
	                    LocalDate fecha = LocalDate.parse(sc.nextLine());
	                    historial.mostrarHistorialDeUnDia(fecha);
	                } catch (Exception e) {
	                    System.out.println("Fecha inválida.");
	                }
	            } else if (opcion == 4) {
	                System.out.print("Introduce la URL: ");
	                historial.mostrarHistorialPorUrl(sc.nextLine());
	            } else if (opcion == 5) {
	                System.out.print("Introduce la URL a borrar: ");
	                historial.borrarVisitasDeUnaPagina(sc.nextLine());
	                System.out.println("Visitas eliminadas.");
	            } else if (opcion == 6) {
	                System.out.println("Saliendo del programa.");
	                break;
	            } else {
	                System.out.println("Opción no válida.");
	            }
	        }

	        sc.close();
	    }
	}

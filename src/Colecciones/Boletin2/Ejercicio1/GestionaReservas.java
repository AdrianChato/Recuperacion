package Colecciones.Boletin2.Ejercicio1;

import java.time.LocalDate;

public class GestionaReservas {

	public static void main(String[] args) {
        ReservaAnimal reserva = new ReservaAnimal("Selva Viva", "Amazonas", 500000);

        reserva.añadirAnimal(new Animal(1, "León", "Felino", 5, "Carnívoro",
                LocalDate.of(2019, 3, 21), 180.5, "Tierra", "Vivíparo"));

        reserva.añadirAnimal(new Animal(2, "Tortuga", "Reptil", 80, "Herbívoro",
                LocalDate.of(1943, 8, 1), 150.0, "Agua", "Ovíparo"));

        reserva.añadirAnimal(new Animal(3, "Águila", "Ave", 15, "Carnívoro",
                LocalDate.of(2010, 6, 10), 6.5, "Aire", "Ovíparo"));

        reserva.añadirAnimal(new Animal(4, "Mono", "Primate", 8, "Omnívoro",
                LocalDate.of(2017, 2, 28), 35.0, "Tierra", "Vivíparo"));

        reserva.añadirAnimal(new Animal(1, "Leopardo", "Felino", 6, "Carnívoro",
                LocalDate.of(2018, 5, 1), 90.0, "Tierra", "Vivíparo"));

        System.out.println("\nAnimales ordenados por nombre:");
        reserva.mostrarAnimalesOrdenadosPorNombre();

        System.out.println("\nAnimales ordenados por nombre y fecha de nacimiento:");
        reserva.mostrarAnimalesPorNombreYFechaNacimiento();

        boolean modificado = reserva.modificarNombreAnimal(2, "Tortuga Gigante");
        if (modificado) {
            System.out.println("\nAnimal con ID 2 modificado correctamente.");
        }

        System.out.println("\nAnimales actualizados:");
        reserva.mostrarAnimalesOrdenadosPorNombre();
    }
}
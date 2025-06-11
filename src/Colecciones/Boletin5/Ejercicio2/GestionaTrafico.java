package Colecciones.Boletin5.Ejercicio2;

import java.time.LocalDate;
import java.util.List;

public class GestionaTrafico {

	public static void main(String[] args) {
		 RegistroTrafico registro = new RegistroTrafico();

	        Vehiculo v1 = new Vehiculo("VIN123", "1234ABC", "Toyota", "Corolla", 2015, "Juan");
	        Vehiculo v2 = new Vehiculo("VIN456", "5678DEF", "Ford", "Fiesta", 2018, "María");
	        Vehiculo v3 = new Vehiculo("VIN789", "9101GHI", "Seat", "Ibiza", 2020, "Juan");

	        registro.registrarVehiculo(v1);
	        registro.registrarVehiculo(v2);
	        registro.registrarVehiculo(v3);

	        registro.rematricular("VIN123", "9999ZZZ", LocalDate.of(2023, 5, 10));
	        registro.rematricular("VIN123", "8888XXX", LocalDate.of(2024, 6, 1));
	        registro.rematricular("VIN789", "7777WWW", LocalDate.of(2024, 6, 1));

	        System.out.println("Vehículo VIN123:");
	        System.out.println(registro.buscarVehiculo("VIN123"));
	        System.out.println("Historial:");
	        for (Rematriculacion r : registro.obtenerHistorial("VIN123")) {
	            System.out.println(r);
	        }

	        System.out.println("Vehículos de Juan:");
	        List<Vehiculo> vehiculosJuan = registro.obtenerVehiculosPorPropietario("Juan");
	        for (Vehiculo v : vehiculosJuan) {
	            System.out.println(v);
	        }

	        System.out.println("Vehículos rematriculados en 2024:");
	        List<Vehiculo> rematriculados2024 = registro.obtenerVehiculosPorAñoRematriculacion(2024);
	        for (Vehiculo v : rematriculados2024) {
	            System.out.println(v);
	        }
	    }
	}

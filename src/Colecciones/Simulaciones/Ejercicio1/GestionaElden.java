package Colecciones.Simulaciones.Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestionaElden {

	public static void main(String[] args) {
		 RegistroSinLuz registro = new RegistroSinLuz();

	        SinLuz s1 = registro.registrarSinLuz("Ranni");
	        SinLuz s2 = registro.registrarSinLuz("Blaidd");

	        try {
	            List<String> enemigos = new ArrayList<>();
	            enemigos.add("Dragón");
	            enemigos.add("Murciélagos");

	            Encuentro e1 = new Encuentro("Dragón Agheel", LocalDate.of(2025, 6, 10), 8, enemigos);
	            registro.agregaEncuentro(e1, s1.getId());

	            System.out.println(registro.getSinLuz(s1.getId()));
	        } catch (EldenException e) {
	            System.out.println("Error: " + e.getMessage());
	        }

	        System.out.println("Listado ordenado:");
	        for (SinLuz s : registro.listarSinLuzOrdenado()) {
	            System.out.println(s.getNombre());
	        }
	    }
	}

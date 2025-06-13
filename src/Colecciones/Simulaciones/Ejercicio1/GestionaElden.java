package Colecciones.Simulaciones.Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestionaElden {

	public static void main(String[] args) {
		 // Creo tres Sinluz con nombres diferentes
        SinLuz ardyn = new SinLuz("Ardyn");
        SinLuz selene = new SinLuz("Selene");
        SinLuz kael = new SinLuz("Kael");

        // Creo el repositorio y añado los Sinluz usando su nombre como clave
        RegistroSinLuz repo = new RegistroSinLuz();
        repo.getSinluzPorId().put(ardyn.getId(), ardyn);
        repo.getSinluzPorId().put(selene.getId(), selene);
        repo.getSinluzPorId().put(kael.getId(), kael);

        // Creo los encuentros
        Encuentro e1 = new Encuentro("Asalto al Bastión Carmesí", LocalDate.of(2025, 3, 10), 8);
        Encuentro e2 = new Encuentro("Emboscada en el Bosque Umbrío", LocalDate.of(2025, 3, 14), 5);
        Encuentro e3 = new Encuentro("Duelo en la Cripta Helada", LocalDate.of(2025, 3, 18), 7);
        Encuentro e4 = new Encuentro("Resistencia en la Torre Abandonada", LocalDate.of(2025, 3, 20), 6);
        Encuentro e5 = new Encuentro("Invasión en la Villa Marchita", LocalDate.of(2025, 3, 23), 9);
        Encuentro e6 = new Encuentro("Caza en el Lago Sombrío", LocalDate.of(2025, 3, 25), 4);
        Encuentro e7 = new Encuentro("Asalto final al Nexo del Caos", LocalDate.of(2025, 3, 30), 10);

        try {
            // Agrego encuentros a los Sinluz válidos
            repo.agregaEncuentro(e1, ardyn.getId());
            repo.agregaEncuentro(e2, selene.getId());
            repo.agregaEncuentro(e3, kael.getId());
            repo.agregaEncuentro(e4, ardyn.getId());
            repo.agregaEncuentro(e5, selene.getId());
            repo.agregaEncuentro(e6, kael.getId());
            repo.agregaEncuentro(e7, ardyn.getId());

            // Intento agregar a un Sinluz con id inexistente
            repo.agregaEncuentro(new Encuentro("Encuentro perdido", LocalDate.now(), 7), 999);

        } catch (EldenException e) {
            // Capturo y muestro la excepción sin detener el programa
            System.out.println(e.getMessage());
        }

        // Imprimo todos los Sinluz y sus encuentros
        Iterator<SinLuz> it = repo.getSinluzPorId().values().iterator();
        while (it.hasNext()) {
            SinLuz s = it.next();
            System.out.println(s);
        }

        // Imprimo solo los encuentros con dificultad mayor a 6
        System.out.println("Encuentros con dificultad mayor a 6:");
        repo.mostrarEncuentrosPorDificultad(6);
    }
}
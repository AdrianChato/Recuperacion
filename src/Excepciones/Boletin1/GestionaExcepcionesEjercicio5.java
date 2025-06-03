package Excepciones.Boletin1;

import java.util.Scanner;

public class GestionaExcepcionesEjercicio5 {
	public static void main(String[] args) {
		GestionaExcepcionesEjercicio5 g = new GestionaExcepcionesEjercicio5();
		System.out.println("Pon un numero");
		Scanner input = new Scanner(System.in);
        int numeroprueba = input.nextInt();

        try {
            g.metodo1(numeroprueba);
        } catch (MiException e) {
            System.out.println(e);
        }
    }

	
	public void metodo1(int numero) throws MiException {
        if (numero % 2 != 0) {
            throw new MiException();
        } else {
            System.out.println("El numero es par");
        }
    }
}

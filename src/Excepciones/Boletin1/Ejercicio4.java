package Excepciones.Boletin1;

import java.util.Random;

public class Ejercicio4 {
	public static void main(String[] args) {
		Random aleatorio = new Random();
		
		int [] divisiones = new int [20];
		
		for (int i = 0; i<20; i++) {
			try {
				int num1 = aleatorio.nextInt(11);
				int num2 = aleatorio.nextInt(11);
				
				divisiones[i] = num1/num2;
				System.out.println(divisiones[i]);
			}
			catch (ArithmeticException e) {
				e.printStackTrace();
			}
		}
		try {
			divisiones = null;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		try {
			divisiones[100] = 0;
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}

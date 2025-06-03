package Excepciones.Boletin1;

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	try {
		System.out.println("Introduce un número");
		int num = input.nextInt();
		while (num<=0) {
			System.out.println("Introduce un número");
			num = input.nextInt();
		}
			throw new ArithmeticException("Es un número positivo");
	}
		catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}
	
	}

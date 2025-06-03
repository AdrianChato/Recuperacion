package Excepciones.Boletin1;

public class Ejercicio2 {
	public static void main(String[] args) {
		Ejercicio2 e = new Ejercicio2();
		try {
			e.m1();
			System.out.println("Despues de3 m1");
		} catch (MiException e1) {
			System.out.println("En el catch");
			e1.printStackTrace();
		}
		System.out.println("Despues de3 m1");
		
	}
	void m1() throws MiException 
	{ 
	          System.out.println("m1");
	          throw new MiException("Hola baby");
	      }
}

package Excepciones.Boletin1;

public class MiException extends Exception{

	public MiException(String mensaje) {
		super();
	}
	
	public MiException() {
		super();
	}

	@Override
	public String toString() {
		return "MiException [], es un numero impar";
	}

	
}

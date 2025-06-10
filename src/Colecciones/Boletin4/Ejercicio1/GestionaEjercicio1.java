package Colecciones.Boletin4.Ejercicio1;

public class GestionaEjercicio1 {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		Contacto c1 = new Contacto("Ana", "García", "ana@gmail.com", "Calle Falsa 123", 123456789);
		Contacto c2 = new Contacto("Luis", "Pérez", "luis@gmail.com", "Avenida Siempre Viva 456", 987654321);
		Contacto c3 = new Contacto("Ana", "García", "ana2@gmail.com", "Otra dirección 789", 111222333);
		agenda.agregarContacto(c1);
		agenda.agregarContacto(c2);
		agenda.agregarContacto(c3);
		System.out.println("Contactos en la agenda:");
		agenda.mostrarContactos();
		System.out.println("Buscando contacto Ana García:");
		agenda.buscarContacto("Ana", "García");
		agenda.eliminarContacto(c2);
		System.out.println("Contactos después de eliminar Luis Pérez:");
		agenda.mostrarContactos();

	}

}

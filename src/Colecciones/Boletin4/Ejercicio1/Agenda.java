package Colecciones.Boletin4.Ejercicio1;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Agenda {

	private Set<Contacto> contactos;

	public Agenda() {
		super();
		this.contactos = new TreeSet<>();
	}

	public Set<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(Set<Contacto> contactos) {
		this.contactos = contactos;
	}

	public void agregarContacto(Contacto c) {
		contactos.add(c);
	}

	public void eliminarContacto(Contacto c) {
		if (contactos.contains(c)) {
			contactos.remove(c);
		} else {
			System.out.println("Este contacto no existe en la agenda");
		}
	}

	public void buscarContacto(String nombre, String apellidos) {
		Iterator<Contacto> it = contactos.iterator();
		while (it.hasNext()) {
			Contacto c = it.next();
			if (c.getNombre().equalsIgnoreCase(nombre) &&
					c.getApellidos().equalsIgnoreCase(apellidos)) {
				System.out.println("Teléfono: " + c.getTelefono());
				System.out.println("Email: " + c.getEmail());
				return;
			}
		}
		System.out.println("Contacto no encontrado.");
	}

	public void mostrarContactos() {
		Iterator<Contacto> it = this.contactos.iterator();
		if (!it.hasNext()) {
			System.out.println("No hay contactos");
			return;
		}
		while (it.hasNext()) {

			System.out.println(it.next());
		}
	}
}

package Colecciones.Boletin4.Ejercicio1;

import java.util.Objects;

public class Contacto implements Comparable<Contacto>{

	private String nombre;
	private String apellidos;
	private String email;
	private String direccion;
	private int telefono;

	public Contacto(String nombre, String apellidos, String email, String direccion, int telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Contacto o) {
		int cmp = this.nombre.compareToIgnoreCase(o.nombre);
		if (cmp == 0) {
			return this.apellidos.compareToIgnoreCase(o.apellidos);
		}
		return cmp;
	}

	
}

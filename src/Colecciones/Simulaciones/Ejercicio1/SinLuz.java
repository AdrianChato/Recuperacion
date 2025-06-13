package Colecciones.Simulaciones.Ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SinLuz {
	private int id;
	private String nombre;
	private List<Encuentro> encuentros;

	public SinLuz( String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.encuentros = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Encuentro> getEncuentros() {
		return encuentros;
	}

	public void setEncuentros(List<Encuentro> encuentros) {
		this.encuentros = encuentros;
	}

	public void agregarEncuentro(Encuentro e) {
		encuentros.add(e);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof SinLuz))
			return false;
		SinLuz sinLuz = (SinLuz) o;
		return id == sinLuz.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "SinLuz [id=" + id + ", nombre=" + nombre + ", encuentros=" + encuentros + "]";
	}

	public void tieneEncuentro(int dificultad) {

    	boolean encontrado = false;

    	SinLuz s = null;

    	Iterator<Encuentro> it = encuentros.iterator();



        while (it.hasNext()) {

            Encuentro e = it.next();



            // Compruebo si la dificultad del encuentro es mayor que la que pide

            if (e.getDificultad() > dificultad) {

          

                // Si lo es, lo muestro por pantalla

                System.out.println(e);

            }

    }
}
}
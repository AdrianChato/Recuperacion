package PruebaTreeSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Set <Persona> s = new TreeSet<>();
		ComparadorPorNombre a = new ComparadorPorNombre();
		s.add(new Persona("35345678i", "Juan"));
		s.add(new Persona("22345178i", "Ana"));
		s.add(new Persona("12345678i", "Pepe"));
		s.add(new Persona("22345178i", "Ana"));
		List <Persona> lista = new ArrayList<Persona>(s);
		Collections.sort(lista, a);
		System.out.println(lista);
		
		
	}

}

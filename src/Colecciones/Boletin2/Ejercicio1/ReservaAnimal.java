package Colecciones.Boletin2.Ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReservaAnimal {
		private String nombre;
	    private String lugar;
	    private double presupuestoAnual;
	    private List<Animal> animales;

	    public ReservaAnimal(String nombre, String lugar, double presupuestoAnual) {
	        this.nombre = nombre;
	        this.lugar = lugar;
	        this.presupuestoAnual = presupuestoAnual;
	        this.animales = new ArrayList<>();
	    }

	    public boolean añadirAnimal(Animal animalNuevo) {
	        for (Animal animal : animales) {
	            if (animal.getId() == animalNuevo.getId()) {
	                System.out.println("Ya existe un animal con este ID.");
	                return false;
	            }
	        }
	        animales.add(animalNuevo);
	        return true;
	    }

	    public boolean modificarNombreAnimal(int id, String nuevoNombre) {
	        for (Animal animal : animales) {
	            if (animal.getId() == id) {
	                animales.set(animales.indexOf(animal),
	                    new Animal(id, nuevoNombre, animal.getEspecie(), animal.getEdad(),
	                        animal.getClasificacionComida(), animal.getFechaNacimiento(),
	                        animal.getPeso(), animal.getMedio(), animal.getClasificacionGestacion())
	                );
	                return true;
	            }
	        }
	        System.out.println("No se encontró animal con ese ID.");
	        return false;
	    }

	    public void mostrarAnimalesOrdenadosPorNombre() {
	        List<Animal> copia = new ArrayList<>(animales);
	        Collections.sort(copia, new Comparator<Animal>() {
	            @Override
	            public int compare(Animal a1, Animal a2) {
	                return a1.getNombre().compareToIgnoreCase(a2.getNombre());
	            }
	        });

	        for (Animal animal : copia) {
	            System.out.println(animal);
	        }
	    }

	    public void mostrarAnimalesPorNombreYFechaNacimiento() {
	        List<Animal> copia = new ArrayList<>(animales);
	        Collections.sort(copia, new Comparator<Animal>() {
	            @Override
	            public int compare(Animal a1, Animal a2) {
	                int resultado = a1.getNombre().compareToIgnoreCase(a2.getNombre());
	                if (resultado == 0) {
	                    return a1.getFechaNacimiento().compareTo(a2.getFechaNacimiento());
	                }
	                return resultado;
	            }
	        });

	        for (Animal animal : copia) {
	            System.out.println(animal);
	        }
	    }
	}
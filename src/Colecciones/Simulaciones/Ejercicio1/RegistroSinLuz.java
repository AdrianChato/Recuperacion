package Colecciones.Simulaciones.Ejercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RegistroSinLuz {
	private Map<Integer, SinLuz> sinluzPorId;
	private int contadorId;

	public RegistroSinLuz() {
		sinluzPorId = new HashMap<>();
		contadorId = 1;
	}

	public Map<Integer, SinLuz> getSinluzPorId() {
		return sinluzPorId;
	}

	public void setSinluzPorId(Map<Integer, SinLuz> sinluzPorId) {
		this.sinluzPorId = sinluzPorId;
	}

	public int getContadorId() {
		return contadorId;
	}

	public void setContadorId(int contadorId) {
		this.contadorId = contadorId;
	}

	public SinLuz getSinLuz(int id) throws EldenException {

		boolean encontrado = false;

		SinLuz s = null;

		// Uso un iterador para recorrer todos los valores del TreeMap

		Iterator<SinLuz> it = sinluzPorId.values().iterator();

		while (it.hasNext() && !encontrado) {

			SinLuz sinluz = it.next(); // obtengo el siguiente Sinluz

			if (sinluz.getId() == id) {

				encontrado = true;

				s = sinluz;

			}

		}

		if (!encontrado)

			throw new EldenException("No existe el SinLuz con el id: " + id);

		return s;

	}

	public void agregaEncuentro(Encuentro e, int idSinLuz) throws EldenException {
		SinLuz s = this.getSinLuz(idSinLuz);
		if (s == null) {
			throw new EldenException("No existe el SinLuz con el id: " + idSinLuz);
		}
		s.agregarEncuentro(e);
	}

	public List<SinLuz> listarSinLuzOrdenado() {
		List<SinLuz> lista = new ArrayList<>(sinluzPorId.values());
		lista.sort(Comparator.comparing(SinLuz::getNombre));
		return lista;
	}

	public void mostrarEncuentrosPorDificultad(int dificultad) {

		// Recorro todos los Sinluz del registro

		Iterator<SinLuz> itSinluz = sinluzPorId.values().iterator();

		while (itSinluz.hasNext()) {

			SinLuz sinluz = itSinluz.next();

			sinluz.tieneEncuentro(dificultad);

		}

	}

}

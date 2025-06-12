package Colecciones.Simulaciones.Ejercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistroSinLuz {
	private Map<Integer, SinLuz> sinluzPorId;
    private int contadorId;

    public RegistroSinLuz() {
        sinluzPorId = new HashMap<>();
        contadorId = 1;
    }

    public SinLuz registrarSinLuz(String nombre) {
        SinLuz s = new SinLuz(contadorId++, nombre);
        sinluzPorId.put(s.getId(), s);
        return s;
    }

    public SinLuz getSinLuz(int id) throws EldenException {
        SinLuz s = sinluzPorId.get(id);
        if (s == null) {
            throw new EldenException("No existe el SinLuz con el id: " + id);
        }
        return s;
    }

    public void agregaEncuentro(Encuentro e, int idSinLuz) throws EldenException {
        SinLuz s = sinluzPorId.get(idSinLuz);
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
}

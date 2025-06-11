package Colecciones.Boletin5.Ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistroTrafico {
	private Map<String, Vehiculo> vehiculos; 
    private Map<String, List<Rematriculacion>> historialRematriculaciones; 

    public RegistroTrafico() {
        vehiculos = new HashMap<>();
        historialRematriculaciones = new HashMap<>();
    }

    public boolean registrarVehiculo(Vehiculo v) {
        if (!vehiculos.containsKey(v.getVin())) {
            vehiculos.put(v.getVin(), v);
            historialRematriculaciones.put(v.getVin(), new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean rematricular(String vin, String nuevaMatricula, LocalDate fecha) {
        Vehiculo v = vehiculos.get(vin);
        if (v != null) {
            List<Rematriculacion> lista = historialRematriculaciones.get(vin);

            for (Rematriculacion r : lista) {
                if (r.getFecha().equals(fecha)) {
                    return false; 
                }
            }

            Rematriculacion nueva = new Rematriculacion(vin, v.getMatriculaActual(), nuevaMatricula, fecha);
            lista.add(nueva);
            v.setMatriculaActual(nuevaMatricula);
            return true;
        }
        return false;
    }

    public Vehiculo buscarVehiculo(String vin) {
        return vehiculos.get(vin);
    }

    public List<Rematriculacion> obtenerHistorial(String vin) {
        return historialRematriculaciones.getOrDefault(vin, new ArrayList<>());
    }

    public List<Vehiculo> obtenerVehiculosPorPropietario(String propietario) {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : vehiculos.values()) {
            if (v.getPropietario().equalsIgnoreCase(propietario)) {
                resultado.add(v);
            }
        }

        resultado.sort(Comparator.comparing(Vehiculo::getMatriculaActual));
        return resultado;
    }

    public List<Vehiculo> obtenerVehiculosPorAñoRematriculacion(int año) {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Map.Entry<String, List<Rematriculacion>> entry : historialRematriculaciones.entrySet()) {
            for (Rematriculacion r : entry.getValue()) {
                if (r.getFecha().getYear() == año) {
                    Vehiculo v = vehiculos.get(entry.getKey());
                    if (!resultado.contains(v)) {
                        resultado.add(v);
                    }
                }
            }
        }
        return resultado;
    }
}

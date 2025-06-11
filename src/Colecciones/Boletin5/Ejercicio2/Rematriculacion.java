package Colecciones.Boletin5.Ejercicio2;

import java.time.LocalDate;

public class Rematriculacion {
	private String vin;
	private String matriculaAnterior;
	private String matriculaNueva;
	private LocalDate fecha;

	public Rematriculacion(String vin, String anterior, String nueva, LocalDate fecha) {
		this.vin = vin;
		this.matriculaAnterior = anterior;
		this.matriculaNueva = nueva;
		this.fecha = fecha;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMatriculaAnterior() {
		return matriculaAnterior;
	}

	public void setMatriculaAnterior(String matriculaAnterior) {
		this.matriculaAnterior = matriculaAnterior;
	}

	public String getMatriculaNueva() {
		return matriculaNueva;
	}

	public void setMatriculaNueva(String matriculaNueva) {
		this.matriculaNueva = matriculaNueva;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Rematriculacion [vin=" + vin + ", matriculaAnterior=" + matriculaAnterior + ", matriculaNueva="
				+ matriculaNueva + ", fecha=" + fecha + "]";
	}

	
}

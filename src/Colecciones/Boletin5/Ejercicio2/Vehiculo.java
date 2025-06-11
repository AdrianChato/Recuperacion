package Colecciones.Boletin5.Ejercicio2;

import java.util.Objects;

public class Vehiculo {
	private String vin;
	private String matriculaActual;
	private String marca;
	private String modelo;
	private int añoFabricacion;
	private String propietario;

	public Vehiculo(String vin, String matricula, String marca, String modelo, int año, String propietario) {
		this.vin = vin;
		this.matriculaActual = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.añoFabricacion = año;
		this.propietario = propietario;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMatriculaActual() {
		return matriculaActual;
	}

	public void setMatriculaActual(String matriculaActual) {
		this.matriculaActual = matriculaActual;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAñoFabricacion() {
		return añoFabricacion;
	}

	public void setAñoFabricacion(int añoFabricacion) {
		this.añoFabricacion = añoFabricacion;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	

	@Override
	public String toString() {
		return "Vehiculo [vin=" + vin + ", matriculaActual=" + matriculaActual + ", marca=" + marca + ", modelo="
				+ modelo + ", añoFabricacion=" + añoFabricacion + ", propietario=" + propietario + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Vehiculo))
			return false;
		Vehiculo v = (Vehiculo) o;
		return vin.equals(v.vin);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vin);
	}
}

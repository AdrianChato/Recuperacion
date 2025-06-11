package Colecciones.Boletin5.Ejercicio1;

import java.time.LocalDate;

public class EntradaVIP {
	public enum Tipo {
		SILVER, GOLD, PLATINIUM
	}

	public enum Estado {
		ENVIADA, CONFIRMADA, CANCELADA
	}

	private String codigo;
	private LocalDate fecha;
	private Tipo tipo;
	private Estado estado;

	public EntradaVIP(String codigo, LocalDate fecha, Tipo tipo) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.tipo = tipo;
		this.estado = Estado.ENVIADA;
	}

	public void confirmar() {
		this.estado = Estado.CONFIRMADA;
	}

	public void cancelar() {
		this.estado = Estado.CANCELADA;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "EntradaVIP [codigo=" + codigo + ", fecha=" + fecha + ", tipo=" + tipo + ", estado=" + estado + "]";
	}

	
}

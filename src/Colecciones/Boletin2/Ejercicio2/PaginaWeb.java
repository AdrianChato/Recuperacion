package Colecciones.Boletin2.Ejercicio2;

import java.time.LocalDate;

public class PaginaWeb {

	private String url;
	private LocalDate fechaVisita;

	public PaginaWeb(String url, LocalDate fechaVisita) {
		super();
		this.url = url;
		this.fechaVisita = fechaVisita;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDate getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(LocalDate fechaVisita) {
		this.fechaVisita = fechaVisita;
	}

	@Override
	public String toString() {
		return "PaginaWeb [url=" + url + ", fechaVisita=" + fechaVisita + "]";
	}

}
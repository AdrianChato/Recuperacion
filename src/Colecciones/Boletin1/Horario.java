package Colecciones.Boletin1;

import java.util.ArrayList;
import java.util.List;

public class Horario {

	private List <Dia> dias;

	public Horario(List<Dia> dias) {
		super();
		this.dias = new ArrayList<>();
	}

	public List<Dia> getDias() {
		return dias;
	}

	public void setDias(List<Dia> dias) {
		this.dias = dias;
	}
	
	public void agregaDia(Dia dia) {
		dias.add(dia);
	}

	@Override
	public String toString() {
		return "Horario [dias=" + dias + "]";
	}
	
	
}

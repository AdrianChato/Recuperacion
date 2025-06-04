package Colecciones.Boletin1;

import java.util.ArrayList;
import java.util.List;

public class Instituto {

	private List <Grupo> listagrupos;

	public Instituto(List<Grupo> listagrupos) {
		super();
		this.listagrupos = new ArrayList<>();
	}

	public List<Grupo> getListagrupos() {
		return listagrupos;
	}

	public void setListagrupos(List<Grupo> listagrupos) {
		this.listagrupos = listagrupos;
	}
	
	public void añadegrupo(Grupo grupo) {
		listagrupos.add(grupo);
	}
	
	public Grupo buscargrupopordescripcion(String Descripcion) throws GrupoExcepcion {
		for (Grupo grupo : listagrupos) {
			if (grupo.getDescripcion().equalsIgnoreCase(Descripcion)) {
				return grupo;
			}
				throw new GrupoExcepcion("Grupo no encontrado");
			
		}
		return null;
		
	}
}

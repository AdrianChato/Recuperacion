package Colecciones.Boletin2.Ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Historial {

	private List <PaginaWeb> paginasVisitadas;

	public Historial() {
		super();
		this.paginasVisitadas = new ArrayList<>();
	}

	public List<PaginaWeb> getPaginasVisitadas() {
		return paginasVisitadas;
	}

	public void setPaginasVisitadas(List<PaginaWeb> paginasVisitadas) {
		this.paginasVisitadas = paginasVisitadas;
	}
	
	public void agregarPagina(String url, LocalDate fecha) throws HistorialException {
        if (fecha.isAfter(LocalDate.now())) {
            throw new HistorialException("No se puede registrar una fecha futura.");
        }
        paginasVisitadas.add(new PaginaWeb(url, fecha));
        ordenarPorFecha();
    }

    public void agregarPagina(String url) throws HistorialException {
        agregarPagina(url, LocalDate.now());
    }

    private void ordenarPorFecha() {
        Collections.sort(paginasVisitadas, new Comparator<PaginaWeb>() {
            @Override
            public int compare(PaginaWeb p1, PaginaWeb p2) {
                return p1.getFechaVisita().compareTo(p2.getFechaVisita());
            }
        });
    }

    public void mostrarHistorialCompleto() {
        for (PaginaWeb pagina : paginasVisitadas) {
            System.out.println(pagina);
        }
    }

    public void mostrarHistorialDeUnDia(LocalDate fecha) {
        for (PaginaWeb pagina : paginasVisitadas) {
            if (pagina.getFechaVisita().equals(fecha)) {
                System.out.println(pagina);
            }
        }
    }

    public void mostrarHistorialPorUrl(String urlBuscada) {
        for (PaginaWeb pagina : paginasVisitadas) {
            if (pagina.getUrl().equalsIgnoreCase(urlBuscada)) {
                System.out.println(pagina);
            }
        }
    }

    public void borrarVisitasDeUnaPagina(String urlABorrar) {
        List<PaginaWeb> nuevasPaginas = new ArrayList<>();

        for (PaginaWeb pagina : paginasVisitadas) {
            if (!pagina.getUrl().equalsIgnoreCase(urlABorrar)) {
                nuevasPaginas.add(pagina);
            }
        }

        paginasVisitadas = nuevasPaginas; 
    }
}
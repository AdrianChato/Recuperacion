package Colecciones.Boletin1;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
	
	private String descripcion;
	private String nombreTutor;
	private String clase;
	private List<Estudiante> estudiantes;
	private Horario horario;
	
	public Grupo(String descripcion, String nombreTutor, String clase, List<Estudiante> estudiantes, Horario horario) {
		super();
		this.descripcion = descripcion;
		this.nombreTutor = nombreTutor;
		this.clase = clase;
		this.estudiantes = new ArrayList<>();
		this.horario = horario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreTutor() {
		return nombreTutor;
	}

	public void setNombreTutor(String nombreTutor) {
		this.nombreTutor = nombreTutor;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Grupo [descripcion=" + descripcion + ", nombreTutor=" + nombreTutor + ", clase=" + clase
				+ ", estudiantes=" + estudiantes + ", horario=" + horario + "]";
	}
	
	public void añadirestudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}
	
	public double obtenerpromediogrupo() {
	    double sumarmedia = 0;
	    int total = 0;
	    for (Estudiante estudiante : estudiantes) {
	        try {
	            double promedio = estudiante.obtenermedianotas();
	            sumarmedia = sumarmedia + promedio;
	            total= estudiantes.size();
	        } catch (EstudianteExcepcion e) {
	            System.out.println("Error con el estudiante " + estudiante.getNombre() + ": " + e.getMessage());
	        }
	    }

	    return sumarmedia / total;
	}

}

package Colecciones.Boletin1.ejercicio1;

import java.util.ArrayList;

public class GestionaEjercicio1 {
	public static void main(String[] args) {
        Horario horario = new Horario(new ArrayList<>());
        Dia lunes = new Dia("Lunes", new String[6]);
        lunes.asignaAsignaturas(0, "Programacion");
        lunes.asignaAsignaturas(1, "BBDD");
        lunes.asignaAsignaturas(2, "Entorno");
        horario.agregaDia(lunes);

        Grupo grupo1A = new Grupo("1A", "Tutor Soraya", "Aula 101", new ArrayList<>(), horario);

        Estudiante est1 = new Estudiante("Sergio López", "E001", new ArrayList<>());
        est1.agregaNota(8.0);
        est1.agregaNota(9.0);

        Estudiante est2 = new Estudiante("Carlos Saez", "E002", new ArrayList<>());
        est2.agregaNota(7.5);
        est2.agregaNota(6.5);

        grupo1A.añadirestudiante(est1);
        grupo1A.añadirestudiante(est2);

        Instituto inst = new Instituto(new ArrayList<>());
        inst.añadegrupo(grupo1A);

        System.out.println("Grupo creado: " + grupo1A.getDescripcion());
        System.out.println("Tutor: " + grupo1A.getNombreTutor());
        System.out.println("Horario:" + grupo1A.getHorario());

        System.out.println("Estudiantes del grupo:");
        for (Estudiante est : grupo1A.getEstudiantes()) {
            System.out.println(est);
        }

        System.out.println("Promedio del grupo: " + grupo1A.obtenerpromediogrupo());

        try {
            Grupo buscado = inst.buscargrupopordescripcion("1A");
            System.out.println("Grupo encontrado: " + buscado.getDescripcion());
        } catch (GrupoExcepcion e) {
            System.out.println("Error al buscar el grupo: " + e.getMessage());
        }
    }
}
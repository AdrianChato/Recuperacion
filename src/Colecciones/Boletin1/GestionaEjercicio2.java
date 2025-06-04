package Colecciones.Boletin1;

public class GestionaEjercicio2 {
	public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Adrian Gómez", "12345678A");
        Alumno alumno2 = new Alumno("Mario Pérez", "23456789B");
        Alumno alumno3 = new Alumno("Juanka Ramírez", "34567890C");
        Alumno alumno4 = new Alumno("Fernando Fernández", "45678901D");
        Alumno alumno5 = new Alumno("Anastasia Torres", "56789012E");

        Equipo equipo1 = new Equipo("Alcala");
        Equipo equipo2 = new Equipo("Algaba");

        try {
            equipo1.añadirAlumno(alumno1);
            equipo1.añadirAlumno(alumno2);
            equipo1.añadirAlumno(alumno3);

            equipo2.añadirAlumno(alumno3);
            equipo2.añadirAlumno(alumno4);
            equipo2.añadirAlumno(alumno5);
        } catch (DeportivoExcepcion e) {
            System.out.println("Error al añadir alumno: " + e.getMessage());
        }

        System.out.println("Equipo 1 (" + equipo1.getNombreEquipo() + "):");
        equipo1.mostrarAlumnos();
        System.out.println("Equipo 2 (" + equipo2.getNombreEquipo() + "):");
        equipo2.mostrarAlumnos();

        System.out.println("Buscando a Mario Pérez en equipo 1:");
        Alumno encontrado = equipo1.buscarAlumno(alumno2);
        System.out.println(encontrado != null ? "Encontrado: " + encontrado : "No encontrado");

        Equipo equipoUnido = equipo1.unirCon(equipo2);
        System.out.println("Equipo unido (" + equipoUnido.getNombreEquipo() + "):");
        equipoUnido.mostrarAlumnos();

        Equipo equipoComun = equipo1.interseccionCon(equipo2);
        System.out.println("Alumnos en común:");
        equipoComun.mostrarAlumnos();

        System.out.println("Intentando borrar un alumno no existente (debería dar error):");
        try {
            Alumno alumnoNoExiste = new Alumno("Rendon López", "99999999Z");
            equipo1.borrarAlumno(alumnoNoExiste);
        } catch (DeportivoExcepcion e) {
            System.out.println("Error, no existe: " + e.getMessage());
        }
    }
}

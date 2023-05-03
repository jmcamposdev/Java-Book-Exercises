package unit07.Actividad10.Personal;

import java.time.LocalDate;

public class JefeEstacion {
    String nombre;
    String dni;
    LocalDate nombramiento;

    public JefeEstacion(String nombre, String dni, LocalDate nombramiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.nombramiento = nombramiento;
    }
}

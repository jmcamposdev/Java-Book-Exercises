package unit13.Actividad01;

import java.time.LocalDate;

public class Cliente {
    private final String nombre;
    private LocalDate fechaNacimiento;
    private int edad;
    public Cliente(String nombre) {
        this.nombre = nombre;
    }
    public Cliente (String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public Cliente(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public int getEdad() {
        return edad;
    }
}


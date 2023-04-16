package unit11.Actividad29_Ampliacion;

import unit11.Actividad22_Aplicacion.Empleado;

import java.io.Serializable;
import java.time.LocalDate;

public class Familiar implements Serializable {
    private String dni;
    private String nombre;
    private LocalDate fechaNacimiento;

    public Familiar(String dni, String nombre, LocalDate fechaNacimiento) {
        if (!Empleado.validarNIFCalc(dni)) {
            throw new IllegalArgumentException("El DNI no es válido.");
        }
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return nombre + " (" + dni + ") - " + fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Familiar familiar = (Familiar) o;

        return dni.equals(familiar.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }
}

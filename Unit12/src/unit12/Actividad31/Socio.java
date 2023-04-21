package unit12.Actividad31;

import java.io.Serializable;
import java.time.LocalDate;

public class Socio implements Serializable {
    private String apodo;
    private String nombre;
    private LocalDate fechaIngreso;

    public Socio(String apodo, String nombre, LocalDate fechaIngreso) {
        if (apodo.isBlank()) {
            throw new RuntimeException("El apodo no puede estar vacío");
        }
        if (nombre.isBlank()) {
            throw new RuntimeException("El nombre no puede estar vacío");
        }
        if (fechaIngreso == null) {
            throw new RuntimeException("La fecha de ingreso no puede ser nula");
        }

        this.apodo = apodo;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
    }

    public String getApodo() {
        return apodo;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return apodo + " - " + nombre + " - " + fechaIngreso;
    }
}

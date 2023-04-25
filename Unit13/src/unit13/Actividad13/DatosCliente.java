package unit13.Actividad13;

import unit13.Actividad01.Cliente;

import java.time.LocalDate;

public class DatosCliente {
    private String nombre;
    private LocalDate fechaNacimiento;

    public DatosCliente(Cliente c) {
        this.nombre = c.getNombre();
        this.fechaNacimiento = c.getFechaNacimiento();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int edad() {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.edad();
    }
}

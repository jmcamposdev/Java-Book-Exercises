package unit13.Actividad19_Aplicacion;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente implements Comparable<Cliente> {
    private String dni;
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaAlta;
    private double cuota;
    private int numFamiliares;

    public Cliente(String dni, String nombre, LocalDate fechaNacimiento, LocalDate fechaAlta, double cuota, int numFamiliares) {
        if (dni == null || dni.isBlank()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacío");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        if (fechaAlta == null) {
            throw new IllegalArgumentException("La fecha de alta no puede ser nula");
        }
        if (cuota < 0) {
            throw new IllegalArgumentException("La cuota no puede ser negativa");
        }
        if (numFamiliares < 0) {
            throw new IllegalArgumentException("El número de familiares no puede ser negativo");
        }
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaAlta = fechaAlta;
        this.cuota = cuota;
        this.numFamiliares = numFamiliares;
    }

    public String getNombre () {
        return this.nombre;
    }
    public double getCuota() {
        return cuota;
    }

    public int edad() {
        return LocalDate.now().getYear() - this.fechaNacimiento.getYear();
    }
    public int antiguedad() {
        return LocalDate.now().getMonthValue() - this.fechaAlta.getMonthValue();
    }


    @Override
    public String toString() {
        return this.dni + " " + this.nombre + " " + this.fechaNacimiento + " " + this.fechaAlta + " " + this.cuota + " " + this.numFamiliares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        return Objects.equals(dni, cliente.dni);
    }

    @Override
    public int hashCode() {
        return dni != null ? dni.hashCode() : 0;
    }

        @Override
        public int compareTo(Cliente o) {
            return this.dni.compareTo(o.dni);
        }
}

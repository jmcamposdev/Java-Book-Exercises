package unit12.Actividad11;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Socio implements Comparable<Socio>, Serializable {
    public static final String NIF_PATTERN = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke]$";
    private String dni;
    private String nombre;
    private LocalDate fechaAlta;

    public Socio (String dni, String nombre, LocalDate fechaAlta) {
        if (!dni.matches(NIF_PATTERN)) {
            throw new IllegalArgumentException("El dni no puede estar vacío.");
        }
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        this.dni = dni;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    public Socio (String dni) {
        if (!dni.matches(NIF_PATTERN)) {
            throw new IllegalArgumentException("El dni no puede estar vacío.");
        }
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDni(String dni) {
        if (dni.matches(NIF_PATTERN))
            this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Socio socio = (Socio) o;

        return dni.equals(socio.dni);
    }

    @Override
    public String toString() {
        return nombre + " | " + dni + " | " + fechaAlta;
    }

    public int antiguedad() {
        return (int) ChronoUnit.YEARS.between(this.fechaAlta,LocalDate.now());
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public int compareTo(Socio o) {
        return this.dni.compareTo(o.dni);
    }
}


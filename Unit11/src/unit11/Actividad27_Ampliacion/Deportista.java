package unit11.Actividad27_Ampliacion;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Deportista implements Serializable {
    private static final String NIF_PATTERN = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke]$";

    private static final char[] LETRAS_NIF = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    private final String dni;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Deportes deporte;

    public Deportista(String dni, String nombre, LocalDate fechaNacimiento, Deportes deporte) {
        if (!validarNIFCalc(dni)) {
            throw new IllegalArgumentException("El DNI introducido no es válido.");
        }
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.deporte = deporte;
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

    public Deportes getDeporte() {
        return deporte;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDeporte(Deportes deporte) {
        this.deporte = deporte;
    }

    public static boolean validarNIFCalc(String nif){
        if (!nif.matches(NIF_PATTERN)) // Comprobamos que sea válido el formato
            return false;
        nif = nif.toUpperCase(); // Lo pasamos a mayúsculas
        int numeros = Integer.parseInt(nif.substring(0,8)); // Obtenemos todos los dígitos menos la letra
        char letra = LETRAS_NIF[numeros % 23]; // Calculamos la letra
        return letra == nif.charAt(8); // Comprobamos que sean iguales
    }

    @Override
    public String toString() {
        return this.dni + " " + this.nombre + " | " + this.fechaNacimiento + " | " + this.deporte.getDeporte();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deportista that = (Deportista) o;

        return Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return dni != null ? dni.hashCode() : 0;
    }
}

package unit11.Actividad31_Ampliacion;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente implements Comparable<Cliente>, Serializable {
    private static final String NIF_PATTERN = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke]$";
    private static final char[] LETRAS_NIF = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};


    private final String nombre;
    private final LocalDate fechaNacimiento;
    private final String DNI;
    private final double saldo;

    public Cliente(String nombre, LocalDate fechaNacimiento, String DNI, double saldo) {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        if (!validarNIFCalc(DNI)) {
            throw new IllegalArgumentException("El DNI no es válido");
        }
        if (saldo <= 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }

        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.DNI = DNI;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDNI() {
        return DNI;
    }

    public double getSaldo() {
        return saldo;
    }

    /**
     * Método para validar un NIF
     * Comprueba el formato/sintaxis y valida el Dígito de Control (Letra)
     * @param nif El NIF introducido
     * @return True si es válido u false en caso contrario
     */
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
        return nombre + " - " + fechaNacimiento + " - " + DNI + " - " + saldo;
    }

    @Override
    public  int compareTo(Cliente o) {
        return this.DNI.compareTo(o.DNI);
    }
}

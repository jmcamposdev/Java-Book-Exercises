package unit11.Actividad22_Aplicacion;

import java.io.Serializable;

public class Empleado implements Serializable {
    private static final String NIF_PATTERN = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke]$";

    private static final char[] LETRAS_NIF = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};

    private String dni;
    private String nombre;
    private double sueldo;

    public Empleado(String dni, String nombre, double sueldo) {
        if (!validarNIFCalc(dni))
            throw new IllegalArgumentException("El DNI no es válido");

        this.dni = dni;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return this.nombre + " (" + this.dni + ") - " + this.sueldo + "€";
    }


    public static boolean validarNIFCalc(String nif){
        if (!nif.matches(NIF_PATTERN)) // Comprobamos que sea válido el formato
            return false;
        nif = nif.toUpperCase(); // Lo pasamos a mayúsculas
        int numeros = Integer.parseInt(nif.substring(0,8)); // Obtenemos todos los dígitos menos la letra
        char letra = LETRAS_NIF[numeros % 23]; // Calculamos la letra
        return letra == nif.charAt(8); // Comprobamos que sean iguales
    }
}

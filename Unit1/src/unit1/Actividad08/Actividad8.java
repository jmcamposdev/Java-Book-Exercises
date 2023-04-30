package unit1.Actividad08;

import java.util.Scanner;

/*
    Realizar una aplicación que solicite al usuario su edad y le indique si es mayor de edad o no.
    Mediante un literal booleano, mostrará por pantalla true o false.
 */
public class Actividad8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isMayorEdad;
        int edad;

        System.out.print("Introduce tu edad: ");
        edad = sc.nextInt();

        isMayorEdad = edad >= 18;
        System.out.println("¿Es mayor de edad? " + isMayorEdad);
    }
}

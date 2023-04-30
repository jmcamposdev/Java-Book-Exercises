package unit02.Actividad01;

import java.util.Scanner;

/*
    Diseñar una aplicación que solicite al usuario un número e indique si es par o impar.
 */
public class Actividad1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        // Pedimos el número
        System.out.print("Introduce un número: ");
        num = sc.nextInt();

        // Comprobamos si es par o impar
        if (num % 2 == 0) {
            System.out.println("El número " + num + " es par.");
        } else {
            System.out.println("El número " + num + " es impar.");
        }
    }
}

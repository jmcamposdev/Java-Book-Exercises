package unit03.Actividad09;

import java.util.Scanner;

/*
    Implementar una aplicación que pida al usuario un número comprendido entre 1 y 10.
    Hay que mostrar la tabla de multiplicar de dicho número. Asegúrate de que el número
    esta en el rango.
 */
public class Actividad9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        // Pedimos un número entre 1 y 10
        do {
            System.out.print("Introduce un número entre 1 y 10: ");
            numero = sc.nextInt();
            if (numero < 1 || numero > 10) { // Si el número no está en el rango
                // Mostramos un mensaje de error
                System.out.println("El número introducido no está en el rango.");
            }
        } while (numero < 1 || numero > 10); // Mientras el número no esté en el rango

        // Mostramos la tabla de multiplicar del número
        System.out.println("La tabla de multiplicar de " + numero + " es:");
        for (int i = 1; i <= 10; i++) {
            // Mostramos el número y el resultado de multiplicarlo por i
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }
}

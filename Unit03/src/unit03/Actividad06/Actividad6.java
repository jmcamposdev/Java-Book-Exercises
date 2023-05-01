package unit03.Actividad06;

import java.util.Scanner;

/*
    Escribir uan aplicación para aprender a contar, que pedirá un número n y mostrará los números desde 1 hasta n.
 */
public class Actividad6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        // Pedimos el número
        System.out.print("Introduce un número: ");
        num = sc.nextInt();

        // Mostramos los números
        System.out.println("Los números del 1 al " + num + " son:");
        for (int i = 1; i <= num; i++) {
            System.out.println(i);
        }


    }
}

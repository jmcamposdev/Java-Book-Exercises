package unit03.Actividad08;

import java.util.Scanner;

/*
    Pedir 10 números por teclado y mostrar la media
 */
public class Actividad8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int suma = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            suma += sc.nextInt();
        }

        System.out.println("La media de los números introducidos es: " + (suma / 10));
    }
}

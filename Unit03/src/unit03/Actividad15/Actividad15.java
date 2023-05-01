package unit03.Actividad15;

import java.util.Scanner;

/*
    Pedir por consola un número n y dibujar un triángulo rectángulo de n elementos de lado.
    Utilizando para ello el carácter asterisco (*).
 */
public class Actividad15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numLados;

        do {
            System.out.println("Ingrese la longitud del traingulo: ");
            numLados = sc.nextInt();
            if (numLados < 0) {
                System.out.println("La longitud debe ser mayor a 0");
            }
        } while (numLados < 0);

        for (int i = numLados; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

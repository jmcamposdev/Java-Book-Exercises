package unit03.Actividad21_Aplicacion;

import java.util.Scanner;

/*
    Solicita al usuario un número n y dibuja un triángulo de base y altura n.
 */
public class Actividad21 {
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

        for (int i = 0; i < numLados; i++) {
            for (int j = 0; j < numLados - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

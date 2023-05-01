package unit03.Actividad19_Aplicacion;

import java.util.Scanner;

/*
    Realiza un programa que nos pida un número n y nos diga cuántos números hay entre 1 y n que sean
    primos. Un número primo es aquel que sólo es divisible por 1 y por sí mismo.
 */
public class Actividad19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, contador = 0;
        boolean esPrimo;

        // Pedir número
        System.out.print("Introduce un número: ");
        n = sc.nextInt();

        // Contar números primos
        for (int i = 1; i <= n; i++) {
            esPrimo = true;

            for (int j = 2; j < i && esPrimo; j++) {
                if (i % j == 0) {
                    esPrimo = false;
                }
            }

            if (esPrimo) {
                System.out.println("El número " + i + " es primo");
                contador++;
            }
        }

        // Mostrar resultado
        System.out.println("Hay " + contador + " números primos entre 1 y " + n);
    }
}

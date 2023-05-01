package unit03.Actividad01;

import java.util.Scanner;

/*
    Diseñar un programa que muestre, para cada número introducido por teclado, si es par, si es positivo, y su cuadrado.
    El proceso terminará cuando el número introducido por teclado sea 0.
 */
public class Actividad1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, cuadrado;
        boolean isPar, isPositive;

        // Pedimos el número
        System.out.print("Introduce un número: ");
        num = sc.nextInt();

        // Mientras el número sea distinto de 0
        while (num != 0) {
            // Comprobamos si es par
            isPar = num % 2 == 0;

            // Comprobamos si es positivo
            isPositive = num > 0;

            // Calculamos el cuadrado
            cuadrado = num * num;

            // Mostramos los resultados
            System.out.println("El número " + num + " es " + (isPar ? "par" : "impar") + ", " + (isPositive ? "positivo" : "negativo") + " y su cuadrado es " + cuadrado);

            // Pedimos el número
            System.out.print("Introduce un número: ");
            num = sc.nextInt();
        }

    }
}

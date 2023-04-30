package unit02.Actividad15_Aplicacion;

import java.util.Scanner;

/*
    Escribe una aplicación que solicite al usuario un número entero . La aplicación
    tendrá que indicar si el número es capicúa o no.
 */
public class Actividad15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero, numeroInvertido = 0, resto, numeroOriginal;

        System.out.print("Introduce un número: ");
        numero = sc.nextInt();

        numeroOriginal = numero;

        while (numero != 0) {
            resto = numero % 10;
            numeroInvertido = numeroInvertido * 10 + resto;
            System.out.println(numeroInvertido);
            numero /= 10;
        }

        if (numeroOriginal == numeroInvertido) {
            System.out.println("El número " + numeroOriginal + " es capicúa");
        } else {
            System.out.println("El número " + numeroOriginal + " no es capicúa");
        }
    }
}

package unit02.Actividad04;

import java.util.Scanner;

/*
    Implementar un progrma que pida or teclado un número decimal e indique si es
    un número casi-cero, que osn aquello, positivos o negativos, que se acercan a 0 por
    menos de 1 unidad anque curiosamente el 0 no se considera número casi-cero.
    Ejemplos de números casi-cero son: 0.1, -0.1.
 */
public class Actividad4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num;

        // Pedimos el número
        System.out.print("Introduce un número: ");
        num = sc.nextDouble();

        // Comprobamos si es casi-cero
        if (num > -1 && num < 1 && num != 0) {
            System.out.println("El número " + num + " es casi-cero.");
        } else {
            System.out.println("El número " + num + " no es casi-cero.");
        }
    }
}

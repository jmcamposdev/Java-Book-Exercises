package unit1.Actividad09;

import java.util.Scanner;

/*
    Escribir un programa que pieda un número al usuario e indique mediante un literal booleano
    si es par o no.
 */
public class Actividad9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isPar;
        int num;

        System.out.print("Introduce un número: ");
        num = sc.nextInt();

        isPar = num % 2 == 0;
        System.out.println("¿Es par? " + isPar);
    }
}

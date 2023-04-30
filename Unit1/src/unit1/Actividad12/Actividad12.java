package unit1.Actividad12;

import java.util.Scanner;

/*
    Escribir un programa que pida un número al usuario y muestre por pantalla su valor absoluto.
 */
public class Actividad12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int valorAbsoluto;

        // Pedir el número
        System.out.print("Introduce un número: ");
        num = sc.nextInt();

        // También se puede hacer con Math.abs(num)
        valorAbsoluto = num < 0 ? num * -1 : num;

        // Mostar el resultado
        System.out.println("El valor absoluto de " + num + " es " + valorAbsoluto);
    }
}

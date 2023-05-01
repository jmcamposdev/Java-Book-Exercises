package unit03.Actividad22_Aplicacion;

import java.util.Scanner;

/*
    Para dos números dados a, b es posible buscar el máximo común divisor (MCD) mediante un algoritmo
    ineficiente, pero sencillo: desde el menor de a y b, ir buscando decreciente el primer número que divide a ambos
    simultáneamente. Realiza un programa que calcula el máximo común divisor de dos números enteros positivos
 */
public class Actividad22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, mcd = 0;
        boolean mcdEncontrado = false;

        // Pedimos los dos números
        System.out.print("Introduce el primer número: ");
        a = sc.nextInt();

        System.out.print("Introduce el segundo número: ");
        b = sc.nextInt();

        // Buscamos el MCD
        for (int i = Math.min(a, b); i > 0 && !mcdEncontrado; i--) {
            if (a % i == 0 && b % i == 0) {
                mcd = i;
                mcdEncontrado = true;
            }
        }

        System.out.println("El MCD de " + a + " y " + b + " es " + mcd);
    }
}

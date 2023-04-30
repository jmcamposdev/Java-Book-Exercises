package unit02.Actividad09;

import java.util.Scanner;

/*
    Escribir una aplicación que inque cuántas cifras tiene un número entero introducido por teclado.
    Que estará comprendido entre 0 y 99999.
 */
public class Actividad9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, cifras = 0;

        // Pedimos el número
        System.out.print("Introduce un número: ");
        num = sc.nextInt();

        // Comprobamos cuántas cifras tiene
        if (num == 0) { // Si el número es 0, tiene 1 cifra
            cifras = 1;
        } else {
            // Mientras el número sea mayor que 0, dividimos entre 10 y sumamos 1 a cifras
            while (num > 0) {
                num /= 10;
                cifras++;
            }
        }

        System.out.println("El número tiene " + cifras + " cifras.");
    }
}

package unit02.Actividad06;

import java.util.Scanner;

// Realizar de nuevo el Ejercicio 3 considerando que los números pueden ser iguales.
public class Actividad6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;

        // Pedimos los números
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();

        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();

        // Comprobamos cuál es mayor
        if (num1 == num2) {
            System.out.println("Los números son iguales.");
        } else if (num1 > num2) {
            System.out.println(num1 + " es mayor que " + num2 );
        } else {
            System.out.println(num2 + " es mayor que " + num1 );
        }
    }
}

package unit02.Actividad03;

import java.util.Scanner;

/*
    Solicitar dos números distintos y decir cuál es el mayor de los dos.
 */
public class Actividad3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;

        // Pedimos los números
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();

        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();

        // Comprobamos cuál es mayor
        if (num1 > num2) {
            System.out.println(num1 + " es mayor que " + num2 );
        } else if (num1 < num2) {
            System.out.println(num2 + " es mayor que " + num1 );
        } else {
            System.out.println("Los números son iguales.");
        }
    }
}

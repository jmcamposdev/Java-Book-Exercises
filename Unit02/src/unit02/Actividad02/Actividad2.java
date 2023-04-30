package unit02.Actividad02;

import java.util.Scanner;

/*
    Pedir dos números y decir si son iguales o no.
 */
public class Actividad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;

        // Pedimos los números
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();

        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();

        // Comprobamos si son iguales
        if (num1 == num2) {
            System.out.println("Los números son iguales.");
        } else {
            System.out.println("Los números no son iguales.");
        }
    }
}

package unit03.Actividad11;

import java.util.Scanner;

/*
    Pedir un úmero y calcular su factorial. Por ejemplo el factorial de 5 se denota 5! y se calcula como:
    5! = 5 * 4 * 3 * 2 * 1 = 120
 */
public class Actividad11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number, factorial = 1;

        // Pedir número
        System.out.print("Introduce un número: ");
        number = sc.nextInt();

        // Calcular factorial
        for (int i = number; i > 0; i--) {
            factorial *= i;
        }

        // Mostrar resultado
        System.out.println("El factorial de " + number + " es " + factorial);
    }
}

package unit03.Actividad20_Aplicacion;

import java.util.Scanner;

/*
    Diseña una aplicación que dibuje el triángulo de Pascal, para n filas. Numerando las filas y elementos desde 0.
 */
public class Actividad20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numFilas;

        do {
            System.out.println("Ingrese el número de filas: ");
            numFilas = sc.nextInt();
            if (numFilas < 0) {
                System.out.println("El número de filas debe ser mayor a 0");
            }
        } while (numFilas < 0);

        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(binomial(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static int binomial(int n, int m) {
        return factorial(n) / (factorial(m) * factorial(n - m));
    }

    private static int factorial(int n) {
        int factorial = 1;
        for (int i = n; i > 0; i--) {
            factorial *= i;
        }
        return factorial;
    }
}

package unit04.Actividad02;

import java.util.Scanner;

/*
    Escribe una función que se pasan dos enteros y muestre todos los números comprendidos entre ellos.
 */
public class Actividad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2;

        // Pedimos los dos números
        System.out.print("Introduce el primer número: ");
        n1 = sc.nextInt();

        System.out.print("Introduce el segundo número: ");
        n2 = sc.nextInt();

        // Mostramos los números comprendidos entre ellos
        mostrarNumeros(n1, n2);
    }

    private static void mostrarNumeros(int n1, int n2) {

        for (int i = Math.min(n1, n2); i <= Math.max(n1, n2); i++) {
            System.out.println(i);
        }
    }
}

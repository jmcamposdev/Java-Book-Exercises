package unit04.Actividad04;

import java.util.Scanner;

/*
    Diseñar una función que recibe como parámetros dos números enteros y devuelve el mayor de ellos.
 */
public class Actividad4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2;

        // Pedimos los números
        System.out.print("Introduce el primer número: ");
        n1 = sc.nextInt();

        System.out.print("Introduce el segundo número: ");
        n2 = sc.nextInt();

        // Mostramos el mayor
        System.out.printf("El mayor es: %d", mayor(n1, n2));
    }

    private static int mayor(int n1, int n2) {
        // Se podría hacer con un if, pero como ya hemos visto el operador ternario, lo usamos
        // O también con la función Math.max()
        return n1 > n2 ? n1 : n2;
    }
}

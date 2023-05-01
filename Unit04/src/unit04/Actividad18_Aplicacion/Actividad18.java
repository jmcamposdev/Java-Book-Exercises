package unit04.Actividad18_Aplicacion;

import java.util.Scanner;

import static unit04.Actividad06.Actividad6.esPrimo;

/*
    Implementa la función divisoresPrimos() que muestra por cosola todos
    los divisores primos de un número entero positivo que se le pasa como parámetro.
 */
public class Actividad18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // Pedimos el número
        System.out.print("Introduce un número: ");
        n = sc.nextInt();

        // Mostramos los divisores primos
        System.out.println("Divisores primos:");
        divisoresPrimos(n);
    }

    public static void divisoresPrimos(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && esPrimo(i)) {
                System.out.println(i);
            }
        }
    }
}

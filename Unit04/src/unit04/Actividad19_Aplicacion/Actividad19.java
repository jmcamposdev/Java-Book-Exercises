package unit04.Actividad19_Aplicacion;

import java.util.Scanner;

/*
    Escribe una función que decida si dos números enteros positivos son amigos
    Dos números a y b son amigos si la suma de los divisores propios de a es igual a b
    Y viceversa, la suma de los divisores propios de b es igual a.

    Ejemplo:
        220 y 284 son amigos
        220 = 1 + 2 + 4 + 5 + 10 + 11 + 20 + 22 + 44 + 55 + 110 = 284
        284 = 1 + 2 + 4 + 71 + 142 = 220




 */
public class Actividad19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b;

        // Pedimos los números
        System.out.print("Introduce el primer número: ");
        a = input.nextInt();

        System.out.print("Introduce el segundo número: ");
        b = input.nextInt();

        // Mostramos el resultado
        if (sonAmigos(a, b)) {
            System.out.println("Los números " + a + " y " + b + " son amigos");
        } else {
            System.out.println("Los números " + a + " y " + b + " no son amigos");
        }
    }

    private static boolean sonAmigos(int a, int b) {
        return sumaDivisoresPropios(a) == b && sumaDivisoresPropios(b) == a;
    }

    private static int sumaDivisoresPropios(int a) {
        int suma = 0;

        for (int i = 1; i < a; i++) {
            if (a % i == 0) {
                suma += i;
            }
        }

        return suma;
    }
}

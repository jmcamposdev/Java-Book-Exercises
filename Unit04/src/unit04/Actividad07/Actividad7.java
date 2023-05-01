package unit04.Actividad07;

import unit04.Actividad06.Actividad6;

/*
    Escribir una función a la que se le pase un número entero y devuelve el número de divisores
    primos que tiene.
 */
public class Actividad7 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " tiene " + divisoresPrimos(i) + " divisores primos");
        }
    }

    public static int divisoresPrimos(int n) {
        int divisoresPrimos = 0;
        for (int i = 1; i <= n; i++) {
            if (Actividad6.esPrimo(i) && n % i == 0) {
                divisoresPrimos++;
            }
        }
        return divisoresPrimos;
    }

}

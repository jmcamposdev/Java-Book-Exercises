package unit13.Actividad09;

import java.util.ArrayList;
import java.util.List;

/*
    Implementar el método
        static boolean esPrimo (Integer n)
    que devuelve true si n es primo y false en caso contrario.
    Escribir un programa que genere 100 números aleatorios menores que
    1000 y que muestre por pantalla todos los que sean primos.
    1. Ordenados de menor a mayor.
    2. Ordenados de mayor a menor.
    3. Solo los compredidos entre 200 y 800.
 */
public class Actividad9 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lista.add((int) (Math.random() * 1000));
        }

        // Apartado 1.
        System.out.println("Ordenados de Menor a Mayor:");
        lista.stream()
                .filter(Actividad9::esPrimo)
                .sorted(Integer::compare)
                .forEach(n -> System.out.print(n + " "));
        System.out.println(" \n");

        // Apartado 2
        System.out.println("Ordenados de Mayor a Menor: ");
        lista.stream()
                .filter(Actividad9::esPrimo)
                .sorted((a,b) -> b - a)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // Apartado 3
        lista.stream()
                .filter(n -> esPrimo(n) && (n >= 200 && n <= 800))
                .forEach(n -> System.out.print(n + " "));
    }

    public static boolean esPrimo (Integer n) {
        boolean primo = true;
        for (int i = 2; primo && i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                primo = false;
            }
        }
        return primo;
    }
}

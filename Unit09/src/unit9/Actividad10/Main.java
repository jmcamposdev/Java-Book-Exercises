package unit9.Actividad10;

import java.util.Arrays;
import java.util.Comparator;

/*
    Implementar una clase comparadores que permita ordenar números enteros de menor a mayor.
    Crea una tabla de 20 números aleatorios comprendidos entre 1 y 100. y ordenarlos en sentido decreciente.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] numeros = new Integer[20];
        // Rellenamos el array con números aleatorios entre 1 y 100
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random() * 100 + 1);
        }
        // Mostramos el array sin ordenar
        System.out.println("Array sin ordenar:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        // Mostramos el array ordenado
        System.out.println("\nArray ordenado:");
        Arrays.sort(numeros, new OrdenarNumerosCreciente()); // Ordenamos el array usando el comparador OrdenarNumerosCreciente
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        // Mostramos el array ordenado de forma decreciente
        System.out.println("\nArray ordenado de forma decreciente:");
        Comparator<Integer> comparador = new OrdenarNumerosCreciente(); // Creamos un comparador OrdenarNumerosCreciente
        comparador = comparador.reversed(); // Invertimos el comparador
        Arrays.sort(numeros, comparador); // Ordenamos el array usando el comparador invertido
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

    }
}

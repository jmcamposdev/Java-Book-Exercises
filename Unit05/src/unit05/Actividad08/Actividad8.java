package unit05.Actividad08;

import java.util.Arrays;
import java.util.Scanner;

/*
   Leer y almacenar n números enteros en una tabla, a partir de la que se construirá otras dos tablas:
   con los elementos con valores pares e impares de la primera, respectivamente. Las tablas
   pares e impares deben mostrarse ordenadas.
 */
public class Actividad8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] tabla;
        int[] tablaPares = new int[0], tablaImpares = new int[0];
        int n;

        // Pedimos el número de elementos de la tabla
        System.out.print("Introduce el número de elementos de la tabla: ");
        n = sc.nextInt();

        // Instanciamos la tabla
         tabla = new int[n];

        // Pedimos los elementos de la tabla
        for (int i = 0; i < tabla.length; i++) {
            System.out.print("Introduce el elemento " + (i+1) + ": ");
            tabla[i] = sc.nextInt();
        }

        // Recorremos la tabla y contamos los pares e impares
        for (int num : tabla) {
            if (num % 2 == 0) {
                tablaPares = Arrays.copyOf(tablaPares, tablaPares.length + 1);
                tablaPares[tablaPares.length - 1] = num;
            } else {
                tablaImpares = Arrays.copyOf(tablaImpares, tablaImpares.length + 1);
                tablaImpares[tablaImpares.length - 1] = num;
            }

        }

        // Mostramos la tabla
        System.out.println("Tabla: ");
        for (int j : tabla) System.out.print(j + " ");

        // Mostramos la tabla de pares
        System.out.println("\nTabla de pares: ");
        for (int tablaPare : tablaPares) System.out.print(tablaPare + " ");

        // Mostramos la tabla de impares
        System.out.println("\nTabla de impares: ");
        for (int tablaImpare : tablaImpares) System.out.print(tablaImpare + " ");

    }
}

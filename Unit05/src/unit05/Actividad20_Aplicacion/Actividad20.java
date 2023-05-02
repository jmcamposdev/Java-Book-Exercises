package unit05.Actividad20_Aplicacion;

import java.util.Scanner;

/*
    Escribe un programa que solicite los elementos de una matriz de tamaño 4 x 4.
    La aplicación debe decidir si la matriz introducida corresponde a una matriz mágica,
    que es aquella donde la suma de los elementos de cualquier fila o de cualquier columna valen lo mismo.
 */
public class Actividad20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[4][4];

        // Leer los elementos de la matriz
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Fila " + (i + 1));
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Elemento " + (j + 1) + ": ");
                matriz[i][j] = sc.nextInt();
            }
        }

        // Mostrar la matriz
        System.out.println("Matriz");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Comprobar si es mágica
        if (esMagica(matriz)) {
            System.out.println("La matriz es mágica");
        } else {
            System.out.println("La matriz no es mágica");
        }
    }


    public static boolean esMagica (int[][] matriz) {
        boolean esMagica = true;
        int sumaFila = 0;

        // Suma de la primera fila
        for (int i = 0; i < matriz[0].length; i++) {
            sumaFila += matriz[0][i];
        }

        // Suma de las filas
        for (int i = 1; i < matriz.length && esMagica; i++) {
            int sumaFila2 = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFila2 += matriz[i][j];
            }
            if (sumaFila2 != sumaFila) {
                esMagica = false;
            }
        }

        // Suma de las columnas
        for (int i = 0; i < matriz[0].length && esMagica; i++) {
            int sumaColumna2 = 0;
            for (int j = 0; j < matriz.length; j++) {
                sumaColumna2 += matriz[j][i];
            }
            if (sumaColumna2 != sumaFila) {
                esMagica = false;
            }
        }

        return esMagica;
    }
}

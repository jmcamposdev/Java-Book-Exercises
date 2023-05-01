package unit05.Actividad05;

/*
    Escribir una función int[] rellenarPares (int longitud, int fin), que crea y devuelve
    una tabla ordenada de la longitud especificada, que se encuentra rellena con números pares
    aleatorios comprendidos en el rango desde 2 hasta fin (inclusive)
 */

import java.util.Arrays;

public class Actividad5 {
    public static void main(String[] args) {
        int[] arrayNumeros = rellenarPares(10, 100);
        System.out.println(Arrays.toString(arrayNumeros));

    }
    public static int[] rellenarPares (int longitud, int fin){
        int[] array = new int[longitud];
        int numeroAleatorio;
        for (int i = 0; i < longitud ; i++) {
            do {
                numeroAleatorio = (int) (Math.random()*fin+1);
            } while (numeroAleatorio%2!=0);
            array[i] = numeroAleatorio;
        }
        Arrays.sort(array);
        return array;
    }
}

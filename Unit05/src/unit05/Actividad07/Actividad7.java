package unit05.Actividad07;

import java.util.Arrays;

/*
    Implementar la función: int[] sinRepetidos(int[] t) que construye y devuelve una tabla
    de la longitud apropiada, con los elementos de t, donde se han eliminado los elementos repetidos.
 */
public class Actividad7 {
    public static void main(String[] args) {
        int[] t = {1,2,6,32,5,246,4573,43,15,1346,24,6,346,14,5};

        int[] sinRepetidos = sinRepetidos(t);

        for (int sinRepetido : sinRepetidos) {
            System.out.println(sinRepetido);
        }
    }

    private static int[] sinRepetidos(int[] t) {
        int[] sinRepetidos = new int[0];

        for (int j : t) {
            int indice = Arrays.binarySearch(sinRepetidos, j);
            if (indice <= -1) {
                sinRepetidos = Arrays.copyOf(sinRepetidos, sinRepetidos.length + 1);
                sinRepetidos[sinRepetidos.length - 1] = j;
                Arrays.sort(sinRepetidos);
            }
        }
        return sinRepetidos;
    }
}

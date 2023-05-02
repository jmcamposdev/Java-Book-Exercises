package unit05.Actividad22_Aplicacion;

import java.util.Arrays;

/*
    La fusión de dos tablas ordenadas consiste en copiar todos sus elementos (de ambas tablas) en una tercera que deberá seguir ordenada.
    Podemos realizar una fusión «ineficiente» copiando los elementos de ambas tablas (sin tener en cuenta el orden) en la tabla final y ordenar esta.
    Existe una manera óptima de realizar la fusión en la que se elige en cada momento el primer elemento no copiado de alguna de las tablas y
    se añade a la tabla final, que seguirá ordenada sin necesidad de ordenación alguna.
Busca información sobre el algoritmo de fusión e impleméntalo en Java.
 */
public class Actividad22 {
    public static void main(String[] args) {
        int[] tabla1 = {1, 3, 5, 7, 9};
        int[] tabla2 = {2, 4, 6, 8, 10, 5};

        int[] tabla3 = mergeTabla(tabla1, tabla2);
        System.out.println("Tabla 1: " + Arrays.toString(tabla1));
        System.out.println("Tabla 2: " + Arrays.toString(tabla2));
        System.out.println("Tabla 3: " + Arrays.toString(tabla3));
    }

    private static int[] mergeTabla(int[] tabla1, int[] tabla2) {
        int[] tabla3 = tabla1; // Copiamos la tabla1 en la tabla3

        for (int j : tabla2) { // Recorremos la tabla2
            int index = Arrays.binarySearch(tabla3, j); // Buscamos el elemento de la tabla2 en la tabla3
            if (index < 0) { // Si no lo encuentra, devuelve un número negativo
                index = -index - 1; // Obtenemos el índice donde debería estar el elemento
            }
            // Copiamos la tabla3 en la tabla3, desde el índice hasta el final, en la tabla3, desde el índice + 1 hasta el final
            tabla3 = Arrays.copyOf(tabla3, tabla3.length + 1);
            System.arraycopy(tabla3, index, tabla3, index + 1, tabla3.length - index - 1); // Desplazamos los elementos
            tabla3[index] = j; // Insertamos el elemento de la tabla2 en la tabla3
        }
        return tabla3;
    }
}

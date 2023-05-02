package unit05.Actividad19_Aplicacion;

import java.util.Arrays;

/*
    5.17. Implementa la función: int [] suma (int t [I, int numBlementos),
    que crea y devuelve una tabla con las sumas de los numElementos elementos consecutivos de t.
    Veamos un ejemplo, sea t = [10, 1, 5, 8, 9, 2]. Si los elementos de t se agrupan de 3 en 3, se harán las sumas:
        10 + 1 + 5. Igual a 16.
        1 + 5 + 8. Igual a 14.
        5 + 8 + 9. Igual a 22.
        8 + 9 + 2. Igual a 19.
    Por lo tanto, la función devolverá una tabla con los resultados: [16, 14, 22, 19).
 */
public class Actividad19 {
    public static void main(String[] args) {
        int[] t = {10, 1, 5, 8, 9, 2};

        System.out.println(Arrays.toString(suma(t,3)));


    }

    public static int[] suma (int[] t, int numElementos) {
        int[] suma = new int[0]; // Creamos el array

        for (int i = 0; i < t.length; i++) { // Iteramos todos los elementos
            if (t.length - i >= numElementos) {  // Si existen 3 elementos
                int numero = 0; // Almacenamos la suma
                int maxIndex = i + 2; // El índice maximo
                for (int j = i; j <= maxIndex; j++) { // Iteramos las n veces
                    numero += t[j];
                }
                suma = Arrays.copyOf(suma, suma.length+1); // Añadimos un elemento más
                suma[suma.length-1] = numero; // Añadimos el elemento
            }
        }
        return suma;
    }
}

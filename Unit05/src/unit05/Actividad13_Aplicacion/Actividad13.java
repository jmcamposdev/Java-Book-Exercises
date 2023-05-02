package unit05.Actividad13_Aplicacion;

import java.util.Arrays;

/*
    Realiza la función: int [] buscarTodos (int t [], int clave), que crea y devuelve
    una tabla con todos los índices de los elementos donde se encuentra la clave de búsqueda.
    En el caso de que clave no se encuentre en la tabla t, la función devolverá una tabla vacía.
 */
public class Actividad13 {
    public static void main(String[] args) {
        int[] array = {12,3,4,5,55,6,5,2};
        System.out.println("El array es: "+ Arrays.toString(array));
        System.out.println("Buscamos los indices del valor 5");
        System.out.println("El nuevo array es: "+ Arrays.toString(buscarTodos(array,5)));

    }

    public static int[] buscarTodos (int[] t, int clave) {
        int[] nuevoArray = new int[0];
        for (int i = 0; i < t.length; i++) {
            if (t[i] == clave) {
                nuevoArray = Arrays.copyOf(nuevoArray,nuevoArray.length+1);
                nuevoArray[nuevoArray.length-1] = i;
            }
        }
        return nuevoArray;
    }
}

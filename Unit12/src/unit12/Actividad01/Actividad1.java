package unit12.Actividad01;

import java.util.Arrays;

/*
    Implementar un método genérico estático que realize la inserción de un objeto al final de una tabla,
    ambos del mismo tipo genérico, que se pasan como parámetro. Devuelve una nueva tabla con el resultado de la inserción.
 */
public class Actividad1 {
    public static void main(String[] args) {
        String[] tabla = {"Hola", "Mundo"};
        String[] nuevaTabla = insertar(tabla, "!");
        System.out.println(Arrays.toString(nuevaTabla));
        System.out.println("--------------------");
        Integer[] tabla2 = {1, 2, 3};
        Integer[] nuevaTabla2 = insertar(tabla2, 4);
        System.out.println(Arrays.toString(nuevaTabla2));
    }

    public static <T> T[] insertar(T[] tabla, T objeto) {
        T[] nuevaTabla = Arrays.copyOf(tabla, tabla.length + 1);
        nuevaTabla[nuevaTabla.length -1 ] = objeto;
        return nuevaTabla;
    }
}

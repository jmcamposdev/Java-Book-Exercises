package unit13.Actividad04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
    Implementar un método estático al que se pasa como parámetro una tabla de tipo genérico y un predicado.
    El método devuelve otra tabla con los elementos de la tabla original que verifique la condición
    del predicado. Aplicarlo a una tabla de 50 enteros entre 1 y 100, que devuelva los múltiplos de 3.

    Actividad Propuesta 1
    Implementa un método estático al que se pasa como parámetro una lista de tipo genérico y un predicado.
    El método devuelve otra lista con los elementos de la lista original que ve verifique la condición del predicado.
    Aplicarlo a una lista de 50 enteros entre 1 y 100, que devuelva los múltiplos de 3.
 */
public class Actividad4 {
    public static void main(String[] args) {
        Integer[] enteros = new Integer[50];
        for (int i = 0; i < 50; i++) {
            enteros[i] = Math.round((float) Math.random() * 100);
        }
        Arrays.sort(enteros);
        Integer[] filtrada = filtrar(enteros, x -> (x % 3 == 0));
        System.out.println("Tabla entera: " +  Arrays.toString(enteros));
        System.out.println("Tabla multiplos de 3: " +  Arrays.toString(filtrada));
    }

    static <T> T[] filtrar (T[] tabla, Predicate<T> filtro) {
        T[] filtrada = Arrays.copyOf(tabla, 0);
        for (T e : tabla) {
            if (filtro.test(e)) {
                filtrada = Arrays.copyOf(filtrada, filtrada.length+1);
                filtrada[filtrada.length - 1] = e;
            }
        }
        return filtrada;
    }

    static <T> List<T> filtrar (List<T> lista, Predicate<T> filtro) {
        ArrayList<T> filtrada = new ArrayList<>();
        lista.forEach(e -> {
            if (filtro.test(e)) filtrada.add(e);
        } );
        return filtrada;
    }
}

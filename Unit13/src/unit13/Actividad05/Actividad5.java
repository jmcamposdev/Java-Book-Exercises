package unit13.Actividad05;

import java.util.Arrays;
import java.util.function.Function;

/*
    Implementar el método estático
        static <T, V> VI] transformar (T[] original, V[] transf, Function<T, V> £)
    Al que se pasan dos tablas de tipo T y V respectivamente,
    y devuelve la segunda tabla con los elementos de la primera transformados mediante la función que va en el tercer pará metro.
    Escribir un programa donde se usa este método para obtener una tabla con las raíces cuadradas de los elementos de otra.
 */
public class Actividad5 {
    public static void main(String[] args) {
        Integer[] lista = new Integer[50];
        for (int i = 0; i < 50; i++) {
            lista[i] = Math.round((float) Math.random() * 100);
        }
        Double[] raices = transformar(lista, new Double[0], y -> Math.sqrt(y));
        System.out.println("Tabla entera: " +  Arrays.toString(lista));
        System.out.println("Tabla raíces: " +  Arrays.toString(raices));
    }

    public static <T, V> V[] transformar (T[] original, V[] transf, Function<T, V> f) {
        V[] transforma = Arrays.copyOf(transf, original.length);
        for (int i = 0; i < original.length; i++) {
            transforma[i] = f.apply(original[i]);
        }
        return transforma;
    }
}

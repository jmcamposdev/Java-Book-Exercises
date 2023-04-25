package unit13.Actividad26_Aplicacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/*
    Implementa un programa en el que a partir de dos lista de enteros ordenados en sentido creciente
    se obtenga una única lista también ordenada, fusión de las dos anteriores. Desarrolla el algoritmo
    de forma no destructiva, es decir, sin modificar las listas originales.
 */
public class Actividad26 {
    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lista1.add((int) Math.round(Math.random() * 10));
            lista2.add((int) Math.round(Math.random() * 10));
        }
        Collections.sort(lista1);
        Collections.sort(lista2);

        List<Integer> listaConcatenda = Stream.concat(lista1.stream(), lista2.stream())
                .sorted()
                .toList();

        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);
        System.out.println("Lista concatenada: " + listaConcatenda);
    }
}

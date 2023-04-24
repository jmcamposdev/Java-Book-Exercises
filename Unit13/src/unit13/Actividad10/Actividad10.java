package unit13.Actividad10;

import unit13.Actividad09.Actividad9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Repetir el apartado 1 de la Actividad 9, pero en vez de mostrar los números se devuelven en:
    1. Lista
    2. Tabla
 */
public class Actividad10 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lista.add((int) (Math.random() * 1000));
        }

        // Lista
        List<Integer> listaPrimos = lista.stream()
                .filter(Actividad9::esPrimo)
                .sorted()
                .toList();
        System.out.println("Lista: " + listaPrimos);

        // Tabla
        Integer[] tablaPrimos = lista.stream()
                .filter(Actividad9::esPrimo)
                .sorted()
                .toArray(Integer[]::new);
        System.out.println("Tabla: " + Arrays.toString(tablaPrimos));
    }
}

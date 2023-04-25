package unit13.Actividad16_Aplicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
    Fusiona dos listas, cada una con 20 enteros aleatorios entre 1 y 100
    en un Stream ordenado sin repeticiones. Muestra el resultado por pantalla.
 */
public class Actividad16 {
    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lista1.add((int) (Math.random() * 100) + 1);
            lista2.add((int) (Math.random() * 100) + 1);
        }

        List<Integer> concatenada = Stream.concat(lista1.stream(), lista2.stream())
                .distinct()
                .sorted()
                .toList();

        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);
        System.out.println("Lista concatenada: " + concatenada);
    }
}

package unit12.Actividad30_Aplicacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Implementa una función a la que se le pasen dos listas de enteros ordenadas en sentido creciente
    y nos devuelva una única lista, también ordenada, fusión de las dos anteriores.
    Desarrolla el algoritmo de forma no destructiva, es decir, que las listas utilizadas como parámetros de entrada se mantengan intactas.
 */
public class Actividad30 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        // Fill the lists with random numbers
        for (int i = 0; i < 10; i++) {
            list1.add((int) (Math.random() * 100));
            list2.add((int) (Math.random() * 100));
        }
        // Order the lists
        Collections.sort(list1);
        Collections.sort(list2);
        // Print the lists
        System.out.println("First list:" + list1);
        System.out.println("Second list:" + list2);
        // Print the merged list
        System.out.println("Merge list: " + merge(list1, list2));
    }

    public static List<Integer> merge (List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList<>(list1);
        list.addAll(list2);
        Collections.sort(list);
        return list;
    }
}

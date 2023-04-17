package unit12.Actividad08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
    Implementar un programa en el  que se insertan 20 números aleatorios en una colección.
    Esta se ordenará de menor a mayor convirtiéndola antes en tabla y volviéndola a convertir en colección.
    Repetir el proceso para ordenarla de mayor a menor.
 */
public class Actividad8 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            lista.add((int) (Math.random() * 10 +1));
        }

        System.out.println(lista);
        Integer[] tabla = lista.toArray(new Integer[0]);
        Arrays.sort(tabla);
        ArrayList<Integer> listaCreciente = new ArrayList<>();
        listaCreciente.addAll(Arrays.asList(tabla));
        System.out.println(listaCreciente);

        Comparator<Integer> ordenEnteros = Comparator.naturalOrder();
        Comparator<Integer> ordenDecreciente = ordenEnteros.reversed();

        Arrays.sort(tabla, ordenDecreciente);
        ArrayList<Integer> listaDecreciente = new ArrayList<>();
        listaDecreciente.addAll(Arrays.asList(tabla));
        System.out.println(listaDecreciente);
    }
}

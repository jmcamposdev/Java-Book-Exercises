package unit12.Actividad39_Ampliacion;

import java.util.Comparator;

public class Actividad39 {
    public static void main(String[] args) {
        Comparator<Integer> comparador = Integer::compareTo;
        comparador = comparador.reversed();
        ListaOrdenada<Integer> lista = new ListaOrdenada<>(comparador);
        for (int i = 0; i < 100; i++) {
            lista.añadir((int) (Math.random() * 100));
        }
        System.out.println(lista);
        System.out.println(lista.size());

    }
}

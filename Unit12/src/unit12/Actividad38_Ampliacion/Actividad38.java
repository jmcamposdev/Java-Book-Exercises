package unit12.Actividad38_Ampliacion;

import java.util.ArrayList;
import java.util.List;

/*
    Implementa la función
        static <E> List<E> clonaLista (List<E>)
    que realice una copia exacta de una lista.
 */
public class Actividad38 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lista.add(i);
        }
        System.out.println("Lista original: " + lista);
        List<Integer> listaClonada = clonaLista(lista);
        System.out.println("Lista clonada: " + listaClonada);
    }

    // Esta función no realiza una copia profunda de los elementos de la lista.
    public static <E> List<E> clonaLista (List<E> lista) {
        return new ArrayList<>(lista);
    }
}

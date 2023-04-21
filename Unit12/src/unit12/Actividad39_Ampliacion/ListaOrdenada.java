package unit12.Actividad39_Ampliacion;

import java.util.*;

/*
    Define la clase ListaOrdenada, que almacena una serie de objetos de tipo genérico 3 de forma ordenada, pudiéndose repetir.
    Los elementos se ordenarán según el orden natural de E o bien con el criterio de orden definido en un comparador que se le pasa al constructor.
 */
public class ListaOrdenada <E> extends ArrayList<E> {
    private Comparator<E> comparator;

    public ListaOrdenada() {
        this.comparator = (Comparator<E>) Comparator.naturalOrder();
    }
    public ListaOrdenada(Comparator<E> comparator) {
        this();
        this.comparator = comparator;
    }

    public boolean añadir(E elemento) {

        if (this.isEmpty()) {
            this.add(elemento);
        } else {
            int indice = Collections.binarySearch(this, elemento, comparator);
            if (indice < 0) {
                indice = -indice - 1;
            }
            this.add(indice, elemento);
        }
        return true;
    }

}

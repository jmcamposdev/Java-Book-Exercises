package unit12.Actividad12;

import java.util.HashSet;
import java.util.Set;

/*
    Implementar un método estático que lleve a cabo la unión de dos conjuntos de elementos
    genéricos. La unión es un nuevo conjunto con todos los elementos que pertenezcan, al menos
    a uno de los dos conjuntos.
    Hacer lo mismo con la inserción, formada porlos elementos comunes a los dos conjuntos.
    Los prototipos de los métodos son
    static <E> Set<E> union (Set<E> conjunto1, Set<E> conjunto2)
    static <E> Set<E> insercion  (Set<E> conjunto1, Set<E> conjunto2)
 */
public class Actividad12 {
    public static void main(String[] args) {

    }

    public static <E> Set<E> union (Set<E> conjunto1, Set<E> conjunto2) {
        Set<E> union = new HashSet<>(conjunto1);
        union.addAll(conjunto2);
        return  union;
    }

    public static <E> Set<E> insercion  (Set<E> conjunto1, Set<E> conjunto2) {
        Set<E> insercion = new HashSet<>(conjunto1);
        insercion.retainAll(conjunto2);
        return insercion;
    }
}

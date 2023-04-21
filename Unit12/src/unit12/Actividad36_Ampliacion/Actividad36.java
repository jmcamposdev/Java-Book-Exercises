package unit12.Actividad36_Ampliacion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Implementa una función
        <T> List<T> eliminaRepetidos (List<T› lista)
    A la que se pase una lista de objetos y devuelva una copia sin elementos repetidos.
 */
public class Actividad36 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lista.add((int) (Math.random() * 10));
        }
        System.out.println("Lista Original: " + lista);
        System.out.println("Lista sin repetidos: " + eliminaRepetidos(lista));

    }

    public static <T> List<T> eliminaRepetidos (List<T> lista) {
        Set<T> set = new HashSet<>(lista);
        return new ArrayList<>(set);
    }
}

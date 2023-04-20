package unit12.Actividad21_Aplicacion;

import java.util.*;

/*
    Implementa un método genérico al que se le pasa una lista de valores de la clase genérica T
    y devuelve otra donde se han eliminado las repeticiones.
 */
public class Actividad21 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            lista.add((int) (Math.random() * 10 + 1));
        }
        System.out.println("Sin ordenar: " + lista);
        List<Integer> listaSinRepetidos = eliminarRepetidos(lista);
        System.out.println("Sin repetidos: " + listaSinRepetidos);
    }

    public static <T> List<T> eliminarRepetidos(List<T> lista) {
        Set<T> conjunto = new HashSet<>(lista);
        return new ArrayList<>(conjunto);
    }
}

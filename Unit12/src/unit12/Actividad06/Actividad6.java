package unit12.Actividad06;

import unit12.Actividad05.Actividad5;

import java.util.ArrayList;
import java.util.Iterator;

/*
    Implementar una aplicación donde se insertan 100 números enteros aleatorios entre 1 y 10 (incluidos),
    que pueden estar repetidos, en una colección. Después se eliminan todos los elementos que valen 5
    Mostrar la colección antes y después de la eliminación.
 */
public class Actividad6 {
    public static void main(String[] args) {
        ArrayList<Integer> listaGenerada = Actividad5.crearArrayListAleatorio(100,1,10);
        System.out.println("Lista Generada: "+listaGenerada);
        eliminarTodosLosCinco(listaGenerada);
        System.out.println("Lista sin 5: "+ listaGenerada);
    }

    private static void eliminarTodosLosCinco (ArrayList<Integer> lista) {
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next() == 5) {
                it.remove();
            }
        }
    }
}

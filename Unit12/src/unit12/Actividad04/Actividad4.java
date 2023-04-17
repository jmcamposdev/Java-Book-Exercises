package unit12.Actividad04;

import Functions.GetData;

import java.util.ArrayList;
import java.util.Iterator;

/*
    Implementar una aplicación que pida por consola números enteros no negativos hasta que
     se introduce -1. Los números se irán insertando en una colección, pudiéndose repetir. Al terminal
     se mostrará la colección por pantalla

     A continuación se mostrarán todos los valores pares de la colección. Por último se eliminarán todos los
     múltiplos de 3 y se mostrará por pantalla la colección resultante..
 */
public class Actividad4 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        int numero;
        boolean salida;
        do {
            numero = GetData.getInt("Introduce un número entero positivo: ", -1, Integer.MAX_VALUE);
            salida = numero == -1;
            if (!salida) {
                lista.add(numero);
            }
        } while (!salida);

        mostrarLista(lista); // Mostramos toda la lista
        mostrarPares(lista); // Mostramos los pares
        eliminarImpares(lista); // Eliminamos los impares
        System.out.println("Lista sin multiplos de 3:");
        mostrarLista(lista); // Mostramos la lista sin los multiplos de 3


    }

    private static <T> void mostrarLista (ArrayList<T> lista) {
        System.out.println("Colección:");
        for (T e : lista) {
            System.out.print(e+" ");
        }
        System.out.println(" ");
    }

    private static <T> void mostrarPares (ArrayList<T> lista) {
        System.out.println("Pares:");
        for (T e : lista) {
            if ((Integer) e % 2 == 0) {
                System.out.print(e+" ");
            }
        }
        System.out.println(" ");
    }

    private static void eliminarImpares (ArrayList<Integer> lista) {
        // Se puede hacer con removeIf, pero no lo hago para que se vea el uso de iteradores.
        // lista.removeIf(e -> e % 3 == 0);
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next() % 3 == 0) {
                it.remove();
            }
        }
    }
}

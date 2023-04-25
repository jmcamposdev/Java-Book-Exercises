package unit13.Actividad15_Aplicacion;

import java.util.ArrayList;
import java.util.List;

/*
    A partir de una lista con enteros entre 1 al 100, crear un Stream con
    los múltiplos de 7. Muéstralos por pantalla.
 */
public class Actividad15 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lista.add(i+1);
        }

        List<Integer> multiplosDe7 = lista.stream()
                .filter(x -> x % 7 == 0)
                .toList();

        System.out.println("Lista de enteros entre 1 y 100: " + lista);
        System.out.println("Lista de múltiplos de 7: " + multiplosDe7);
    }
}

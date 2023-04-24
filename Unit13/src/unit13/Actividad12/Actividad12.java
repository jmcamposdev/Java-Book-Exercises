package unit13.Actividad12;

import java.util.ArrayList;

/*
    Crear una lista con 40 números enteros aleatorios entre -20 y 20. A partir de ella
    crear dos Stream, uno con los números positivos y otro con los negativos, todos ellos sin repetir.

    Mostrar por pantalla el número de elementos de cada Stream. Crear otro Stream para contar los números
    que están comprendidos entre -10 y 10 incluidos, sin repeticiones.
 */
public class Actividad12 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        // Generar números aleatorios entre -20 y 20
        for (int i = 0; i < 40; i++) {
            lista.add((int) (Math.random() * 41) - 20);
        }

        // Numero Positivos
        long numeroPositivos = lista.stream()
                .filter(n -> n > 0)
                .distinct()
                .count();
        System.out.println("Positivos: " + numeroPositivos);

        // Números negativos
        long numeroNegativos = lista.stream()
                .filter(n -> n < 1)
                .distinct()
                .count();
        System.out.println("Negativos: " + numeroNegativos);

        // Entre 10 y -10
        long rango = lista.stream()
                .filter(n -> n >= -10 && n <= 10)
                .distinct()
                .count();
        System.out.println("Entre 10 y -10: " + rango);
    }
}

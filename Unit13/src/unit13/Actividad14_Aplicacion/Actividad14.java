package unit13.Actividad14_Aplicacion;

import unit13.Actividad09.Actividad9;

import java.util.ArrayList;

/*
    A partir de una lista de 100 enteros aleatorios menores que 1000.
    - Calcula cuantos son primos.
    - Determina cuál es el mayor, el menor, la suma de todos ellos y el promedio.
 */
public class Actividad14 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lista.add((int) (Math.random() * 1000));
        }
        long numeroPrimos = lista.stream()
                .filter(Actividad9::esPrimo)
                .count();

        int mayor = lista.stream()
                .reduce(0, Integer::max);

        int menor = lista.stream()
                        .mapToInt(Integer::intValue)
                        .min()
                        .getAsInt();

        int suma = lista.stream()
                        .reduce(0, Integer::sum);

        double promedio = suma/ (lista.size()+0.0);
        System.out.printf("""
                Lista de 100 enteros aleatorios menores que 1000: %s
                Número de primos: %d
                Mayor: %d
                Menor: %d
                Suma: %d
                Promedio: 2.%f""",lista,numeroPrimos,mayor,menor,suma,promedio);
    }
}

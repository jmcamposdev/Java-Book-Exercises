package unit13.Actividad33_Ampliacion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
    Usando Stream obtén una lista de todos los números impares, múltiplos de 3 o de 5, menores que 1000;

 */
public class Actividad33 {
    public static void main(String[] args) {
        System.out.println("Lista de números impares, múltiplos de 3 o de 5, menores que 1000:");
        System.out.println(getOddMultiplesOf3Or5(1000));
    }

    private static List<Integer> getOddMultiplesOf3Or5(int limit) {
        return IntStream.range(0, limit)
                .filter(i -> i % 2 != 0)
                .filter(i -> i % 3 == 0 || i % 5 == 0)
                .boxed()
                .collect(Collectors.toList());
    }
}

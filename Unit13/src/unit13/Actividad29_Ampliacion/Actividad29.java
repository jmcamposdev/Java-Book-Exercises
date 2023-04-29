package unit13.Actividad29_Ampliacion;

import java.util.ArrayList;
import java.util.List;

/*
    Escribe los números primos menores que 100 por médio de la criba de Eratóstenes. A
    partir de una lista con los número del 2 al 100, eliminamos los múltiplos de los números
    primos menores que 10: 2, 3, 5 y 7. El resultado es una lista de números primos.
 */
public class Actividad29 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 2; i <= 100; i++) {
            lista.add(i);
        }

        List<Integer> primos = lista.stream()
                .filter(n -> {
                    for (int i = 2; i < n; i++) {
                        if (n % i == 0) return false;
                    }
                    return true;
                })
                .toList();

        System.out.println("Lista: " + lista);
        System.out.println("Primos: " + primos);
    }
}

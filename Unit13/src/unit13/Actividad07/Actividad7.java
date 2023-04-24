package unit13.Actividad07;

import unit13.Actividad05.Actividad5;

import java.util.ArrayList;

/*
    Añadir a la clase Calculos el método
        static Double raiz3 (Double x)
    que calcula la raíz cúbica de x.
    Con el método transformar (), implementado en la Actividad 5, obtener una tabla con las raíces cúbicas
    de los elementos de una tabla de números reales que se le pasa como parámetro.

    Actividad Propuesta 2:
    Añade a Calculos el método static Double raizN (Double base, Integer n)
    que calcula la raíz n-ésima de base.
    Usando el método raizN (), halla la raíz cuarta de los elementos de una tabla de n
    números reales.
 */
public class Actividad7 {
    public static void main(String[] args) {
        ArrayList<Double> enteros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            enteros.add(Math.random() * 100);
        }
        ArrayList<Double> raices = (ArrayList<Double>) Actividad5.transformar(enteros, Calculos::raiz3);
        ArrayList<Double> raices4 = (ArrayList<Double>) Actividad5.transformar(enteros, e -> Calculos.raizN(e, 4));
        System.out.println("Numeros: " + enteros);
        System.out.println("Raices: " + raices);
        System.out.println("Raices4: " + raices4);
    }
}

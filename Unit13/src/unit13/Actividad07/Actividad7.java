package unit13.Actividad07;

import unit13.Actividad05.Actividad5;

import java.util.ArrayList;

/*
    Añadir a la clase Calculos el método
        static Double raiz3 (Double x)
    que calcula la raíz cúbica de x.
    Con el método transformar (), implementado en la Actividad 5, obtener una tabla con las raíces cúbicas
    de los elementos de una tabla de números reales que se le pasa como parámetro.
 */
public class Actividad7 {
    public static void main(String[] args) {
        ArrayList<Double> enteros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            enteros.add(Math.random() * 100);
        }
        ArrayList<Double> raices = (ArrayList<Double>) Actividad5.transformar(enteros, Calculos::raiz3);
        System.out.println("Numeros: " + enteros);
        System.out.println("Raices: " + raices);
    }
}

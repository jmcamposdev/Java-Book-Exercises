package unit05.Actividad01;

import java.util.Arrays;

/*
    Crear un array de 10 posiciones se inicializa con números aleatorios comprendidos entre 0 y 100.
    Mostrar la suma de todos los números del array.
 */

public class Actividad1 {
    public static void main(String[] args) {
        int[] valores = new int[10];
        int suma = 0;
        for (int i = 0; i < valores.length; i++) {
            valores[i]= (int) (Math.random() * 100) +1;
        }
        for (int valore : valores) {
            suma += valore;
        }
        System.out.println("La suma de los valores aleatorios es: "+suma);
        System.out.println("El array es: "+ Arrays.toString(valores));
    }
}


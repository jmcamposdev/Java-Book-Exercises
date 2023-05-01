package unit05.Actividad06;

import java.util.Arrays;

/*
    Definir una función que tome como parámetro dos tablas, la primera con 6 números
    de una apuesta de la primitiva, y la segunda ordenada con los 6 números de la combinación
    ganadora, La función devolverá el número de aciertos
 */
public class Actividad6 {
    public static void main(String[] args) {
        int[] numeros = {9,4,2,61,6};
        int[] combinacion = {61,4,90,2};
        // Ordenamos los Arrays, ya que es necesario
        Arrays.sort(numeros);
        Arrays.sort(combinacion);
        System.out.println("El numero de aciertos es: "+primitiva(numeros,combinacion));
    }
    public static int primitiva (int[] apuesta, int[] combinacionGanadora){
        int acierto = 0;
        for (int numero: apuesta) {
            // Utilizamos la busqueda dicotómica con el metodo binarySearch
            // deben de estar los arrays ordenados.
            if (Arrays.binarySearch(combinacionGanadora,numero) >= 0){
                acierto++;
            }
        }
        return acierto;
    }
}

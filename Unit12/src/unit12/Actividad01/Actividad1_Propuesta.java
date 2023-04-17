package unit12.Actividad01;

import java.util.Arrays;

/*
    Implementa un método genérico estático al que se le pasan como parámetro dos tablas
    con elementos del mismo tipo genérico y devuelve una nueva tabla con los elementos de
    ambas tablas concatenados. (los de la segunda tabla se añaden al final de la primera).
 */
public class Actividad1_Propuesta {
    public static void main(String[] args) {
        String [] tabla1 = {"Hola", "Mundo"};
        String [] tabla2 = {"!", "Adios"};
        String [] tablaConcatenada = concatenar(tabla1, tabla2);
        System.out.println(Arrays.toString(tablaConcatenada));

        Integer [] tabla3 = {1, 2, 3};
        Integer [] tabla4 = {4, 5, 6};
        Integer [] tablaConcatenada2 = concatenar(tabla3, tabla4);
        System.out.println(Arrays.toString(tablaConcatenada2));
    }

    public static <T> T[] concatenar (T[] primeraTabla, T[] segundaTabla) {
        T[] tablaConcatenada = Arrays.copyOf(primeraTabla, primeraTabla.length + segundaTabla.length);
        System.arraycopy(segundaTabla, 0, tablaConcatenada, primeraTabla.length, segundaTabla.length);
        return tablaConcatenada;
    }
}

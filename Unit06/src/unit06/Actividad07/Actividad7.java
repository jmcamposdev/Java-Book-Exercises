package unit06.Actividad07;

import java.util.Scanner;

/*
    Diseñar un programa que solicite al usuario una frase y una palabra. A continuación buscará cuantas veces aparece la palabra en la frase.
 */
public class Actividad7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        String palabra;
        int indice;
        int contador = 0;

        // Pedimos la frase
        System.out.print("Ingrese una frase: ");
        frase = sc.nextLine();

        // Pedimos la palabra
        System.out.print("Ingrese una palabra: ");
        palabra = sc.next();

        // Buscamos la palabra
        indice = frase.indexOf(palabra);
        while (indice != -1){
            contador++;
            indice = frase.indexOf(palabra, indice+1);
        }

        // Mostramos el resultado
        System.out.println("La palabra "+palabra+" aparece "+contador+" veces en la frase");
    }
}

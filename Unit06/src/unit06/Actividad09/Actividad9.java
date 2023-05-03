package unit06.Actividad09;

import java.util.Scanner;

/*
    Introducir por teclado una frase palabra a palabra, y mostrar la frase completa separando las palabras
    introducidas con espacios en blanco. Terminar de leer la frase cuando alguna de las palabras sea la cadena "fin"
    independientemente de como esté escrita.
 */
public class Actividad9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder frase = new StringBuilder();
        String palabra = "";

        // Pedimos las palabras
        while (!palabra.equals("fin")) { // Mientras la palabra no sea "fin"
            System.out.print("Ingrese una palabra: ");
            palabra = sc.next();

            if (!palabra.equals("fin")) { // Si la palabra no es "fin"
                frase.append(palabra).append(" "); // Agregamos la palabra a la frase
            }
        }

        // Mostramos la frase
        System.out.println("La frase es: "+frase);
    }
}

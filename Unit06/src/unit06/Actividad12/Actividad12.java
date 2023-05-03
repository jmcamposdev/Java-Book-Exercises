package unit06.Actividad12;

import java.util.Scanner;

/*
    Un anagrama es una palabra que resulta del cambio del orden de los caracteres de otra.
    Pide dos palabras y comprueba si son anagramas una de otra
 */
public class Actividad12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabra1, palabra2;

        // Pedimos las palabras
        System.out.print("Ingrese la primer palabra: ");
        palabra1 = sc.next();
        System.out.println("Ingrese la segunda palabra: ");
        palabra2 = sc.next();

        if (validasAnagrama(palabra1,palabra2)){ // Si son anagramas
            System.out.println("Es un anagrama");
        } else{
            System.out.println("No es un anagrama");
        }
    }

    public static boolean validasAnagrama (String palabra1, String palabra2){
        boolean esAnagrama = true;
        if (palabra1.length() == palabra2.length()){ // Si tienen la misma longitud
            for (int i = 0; i < palabra1.length() && esAnagrama; i++) { // Recorremos la palabra1
                if (palabra2.indexOf(palabra1.charAt(i)) == -1){ // Si la letra no está en la palabra2
                    esAnagrama = false; // No es un anagrama
                }
            }
        }
        return esAnagrama;
    }

}

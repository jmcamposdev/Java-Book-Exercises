package unit06.Actividad11;

import java.util.Scanner;

/*
    Tenemos que codificar la palabra introducida por teclado, convirtiendo cada letra del conjunto1
    en su correspondiente del conjunto2 el resto de las letras no se modifican. Los conjuntos se utilizan para
    codificar tanto mayúsculas como minúsculas, mostrando siempre la codificación en minúsculas,
 */
public class Actividad11 {
    public static void main(String[] args) {
        // Conjuntos de caracteres
        final char[] conjunto1 = {'e','i','k','m','p','q','r','s','t','u','v'};
        final char[] conjunto2 = {'p','v','i','u','m','t','e','r','k','q','s'};
        Scanner sc = new Scanner(System.in);
        String palabra;
        StringBuilder palabraCodificada = new StringBuilder();
        System.out.println("Ingrese la palabra a codificar: ");
        palabra = sc.next().toLowerCase();

        // Codificamos la palabra
        for (int i = 0; i < palabra.length(); i++) {
            palabraCodificada.append(codifica(conjunto1, conjunto2, palabra.charAt(i)));
        }

        // Mostramos la palabra codificada
        System.out.println("La palabra codificada es: "+palabraCodificada);
    }

    public static char codifica(char[] conjunto1,char[] conjunto2, char c){
        char codificado; // Caracter codificado
        String conj1 = String.valueOf(conjunto1); // Convertimos el conjunto1 a String
        int pos = conj1.indexOf(c); // Obtenemos la posición del caracter en el conjunto1
        if (pos != -1){ // Si el caracter está en el conjunto1
            codificado = conjunto2[pos]; // Obtenemos el caracter codificado
        } else { // Si el caracter no está en el conjunto1
            codificado = c; // El caracter codificado es el mismo
        }
        return codificado; // Devolvemos el caracter codificado
    }
}


package unit06.Actividad25_Aplicacion;

import java.util.Scanner;

/*
    Implementar un programa que lea una frase y muestre todas sus palabras ordenadas alfabéticamente.
    Supondremos que cada palabra está separada de la siguiente por un único espacio en blanco.
 */
public class Actividad25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        String[] palabras;
        String[] fraseOrdenada;

        // Pedimos la frase
        System.out.print("Introduce una frase: ");
        frase = sc.nextLine();

        // Separamos la frase en palabras
        palabras = frase.split(" ");

        // Ordenamos las palabras - Todo esto serie mucho mas sencillo utilizando streams o ArrayList pero no los hemos visto todavía
        fraseOrdenada = ordenarPalabras(palabras);

        // Mostramos la frase ordenada
        System.out.println("Frase ordenada: ");
        for (String palabra : fraseOrdenada) {
            System.out.println(palabra);
        }
    }

    private static String[] ordenarPalabras(String[] palabras) {
        String[] palabrasOrdenadas = new String[palabras.length]; // Array para guardar las palabras ordenadas
        String palabraMenor; // Palabra menor encontrada
        int indicePalabraMenor; // Índice de la palabra menor encontrada

        for (int i = 0; i < palabras.length; i++) { // Recorremos todas las palabras
            palabraMenor = palabras[i]; // Suponemos que la palabra menor es la primera
            indicePalabraMenor = i; // Suponemos que la palabra menor es la primera
            for (int j = i + 1; j < palabras.length; j++) { // Recorremos las palabras restantes
                if (palabras[j].compareTo(palabraMenor) < 0) { // Si encontramos una palabra menor
                    palabraMenor = palabras[j]; // Guardamos la palabra menor
                    indicePalabraMenor = j; // Guardamos el índice de la palabra menor
                }
            }
            palabrasOrdenadas[i] = palabraMenor; // Guardamos la palabra menor en el array de palabras ordenadas
            palabras[indicePalabraMenor] = palabras[i]; // Intercambiamos la palabra menor con la primera
        }

        return palabrasOrdenadas;
    }
}

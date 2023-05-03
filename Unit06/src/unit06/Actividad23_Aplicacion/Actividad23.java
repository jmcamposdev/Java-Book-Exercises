package unit06.Actividad23_Aplicacion;

import java.util.Scanner;

/*
    Escribe una aplicación que convierte una frase (que puede estar escrita con cualquier combinación
    de mayúsculas y minúsculas) en el nombre de una variable que utilize la nomenclatura Camel.
    Por ejemplo "Me GUsta merendAR gaLLEtas" se convertirá en "meGustaMerendarGalletas".
 */
public class Actividad23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        String fraseCamel;

        // Pedimos la frase
        System.out.print("Introduce una frase: ");
        frase = sc.nextLine();

        // Convertimos la frase a Camel
        fraseCamel = convertirCamel(frase);

        // Mostramos la frase convertida
        System.out.println("Frase convertida a Camel: " + fraseCamel);
    }

    private static String convertirCamel(String frase) {
        StringBuilder fraseCamel = new StringBuilder();
        frase = frase.toLowerCase(); // Convertimos la frase a minúsculas
        String[] palabras = frase.split(" "); // Separamos la frase en palabras

        fraseCamel.append(palabras[0]); // La primera palabra no se modifica
        for (int i = 1; i < palabras.length; i++) { // Las siguientes palabras se modifican
            // La primera letra de cada palabra se convierte a mayúscula
            fraseCamel.append(palabras[i].substring(0, 1).toUpperCase()).append(palabras[i].substring(1));
        }

        return fraseCamel.toString();
    }
}

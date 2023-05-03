package unit06.Actividad04;

import java.util.Scanner;

/*
    Diseñar una aplicación que pida al usuario que introduzca una frase por teclado
    e indique cuántos espacios en blanco tiene.
 */
public class Actividad4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        char caracter;
        int espaciosEnBlanco = 0;

        // Pedimos la frase
        System.out.print("Ingrese una frase: ");
        frase = sc.nextLine();

        // Contamos los espacios en blanco
        for (int i = 0; i < frase.length(); i++) {
            caracter = frase.charAt(i); // Obtenemos el caracter
            if (Character.isWhitespace(caracter)){ // Si es un espacio en blanco
                espaciosEnBlanco++; // Aumentamos el contador
            }
        }
        // Mostramos el resultado
        System.out.println("La frase tiene "+espaciosEnBlanco+" espacios en blanco");
    }
}

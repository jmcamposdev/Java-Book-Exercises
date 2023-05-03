package unit06.Actividad13;

import java.util.Scanner;

/*
    Diseñar un algoritmo que lea del teclado una frase e indique, para cada letra que aparece en la frase, cuántas veces se repite.
    Se consideran iguales las letras mayúsculas y las minúsculas para realizar la cuenta.
 */
public class Actividad13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeroDeVeces = new int['z' - 'a' +1];
        String frase;

        // Pedimos la frase y la pasamos a minúsculas
        System.out.println("Ingrese la frase: ");
        frase = sc.nextLine().toLowerCase();

        // Contamos las letras
        for (int i = 0; i < frase.length(); i++) { // Recorremos la frase
            if (Character.isLetter(frase.charAt(i))){ // Si es una letra
                numeroDeVeces[frase.charAt(i) - 'a']++; // Aumentamos el contador
            }
        }

        // Mostramos el resultado
        for (int i = 0; i < numeroDeVeces.length; i++) {
            if (numeroDeVeces[i] != 0){
                System.out.println("La letra "+(char) (i + 'a') + " se ha repetido: "+numeroDeVeces[i]);
            }
        }

    }
}

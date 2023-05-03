package unit06.Actividad03;

/*
    Diseña el juego Acierta la contraseña. La mecánica del juego es la siguiente: el primer jugador introduce la contraseña;
    a continuación el segundo jugador debe teclear palabras hasta acertarla. Realiza dos versiones:
    La primera se facilita el juego indicando si la palabra introducida es mayor o menor alfabéticamente que la contraseña
    La segunda el programa mostrará la longitud de la contraseña y una cadena con los caracteres acertados en sus lugares respectivos y asteriscos en los no acertados
 */

import java.util.Scanner;

public class Actividad3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos la contraseña
        System.out.print("Ingresa la contraseña a intentar adivinar: ");
        String contraseña = sc.next();

        // Pedimos la palabra
        String palabra;
        String pista;
        System.out.print("Intenta adivinar: ");
        palabra = sc.next();

        // Comparamos las cadenas
        while (!contraseña.equals(palabra)){
            pista = " ";
            for (int i = 0; i < contraseña.length(); i++) { // Recorremos la contraseña
                if (i >= palabra.length()){ // Si la palabra es menor que la contraseña
                    pista += "*";
                } else { // Si la palabra es mayor que la contraseña
                    if (contraseña.charAt(i) == palabra.charAt(i)){ // Si la palabra es igual que la contraseña
                        pista += contraseña.charAt(i); // Añadimos la letra a la pista
                    } else {
                        pista += "*"; // Añadimos un asterisco a la pista
                    }
                }

            }
            // Mostramos la pista
            System.out.println("La pista: "+pista);
            System.out.print("Intenta adivinar: ");
            palabra = sc.next();
        }
        System.out.println("Has acertado");
    }

}
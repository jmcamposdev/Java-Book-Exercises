package unit06.Actividad14;

import java.util.Scanner;

/*
    Implementar el juego del anagrama, que consiste en que un jugador escribe una palabra y la aplicación muestra un anagrama
    ( cambio del orden de los caracteres) generado al azar a continuación otro jugador tiene que acertar cuál es el text original.
    La aplicación debe permitir que el texto introducido por el jugador 1 no sea la cadena vacía.
 */
public class Actividad14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabraOriginal;
        String palabraDesordenada;
        String palabraAdivinar;
        // Pedimos la palabra
        do {
            System.out.println("Ingrese el nombre de la palabra a adivinar: ");
            palabraOriginal = sc.next();
        } while (palabraOriginal.isEmpty());

        // Creamos el anagrama
        palabraDesordenada = crearAnagrama(palabraOriginal);
        // Pedimos la palabra
        do {
            System.out.println("La palabra desordenada es: "+palabraDesordenada);
            System.out.println("Ingrese la palabra: ");
            palabraAdivinar = sc.next();
        } while (!palabraOriginal.equals(palabraAdivinar));
        System.out.println("Has adivinado la palabra.");

    }

    public static String crearAnagrama (String palabraOriginal){
        char[] anagrama = palabraOriginal.toCharArray(); // Convertimos la palabra en un array de caracteres
        String palabraDesordenada; // Creamos la palabra desordenada
        for (int i = 0; i < anagrama.length; i++) { // Recorremos el array
            // Generamos dos índices aleatorios entre 0 y la longitud del array
            int indice1 = (int) (Math.random() * anagrama.length);
            int indice2 = (int) (Math.random() * anagrama.length);

            // Intercambiamos los caracteres
            char aux = anagrama[indice1];
            anagrama[indice1] = anagrama[indice2];
            anagrama[indice2] = aux;
        }

        palabraDesordenada = String.valueOf(anagrama);
        return palabraDesordenada;
    }
}

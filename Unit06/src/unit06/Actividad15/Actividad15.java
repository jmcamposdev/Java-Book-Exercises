package unit06.Actividad15;

import java.util.Scanner;

/*
    Lo mismo que el ejercicio anterior solo que decimos las letras en la posición correcta.
 */
public class Actividad15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabraOriginal;
        String palabraDesordenada;
        String palabraAdivinar;

        // Pedimos la palabra
        do {
            System.out.print("Ingrese el nombre de la palabra a adivinar: ");
            palabraOriginal = sc.next();
        } while (palabraOriginal.isEmpty());

        palabraDesordenada = crearAnagrama(palabraOriginal);

        // Pedimos la palabra
        do {
            System.out.println("La palabra desordenada es: "+palabraDesordenada);
            System.out.println("Ingrese la palabra: ");
            palabraAdivinar = sc.next();
            System.out.println("Has acertado: "+letrasCorrecta(palabraOriginal,palabraAdivinar)); // Mostramos las letras correctas
        } while (!palabraOriginal.equals(palabraAdivinar));
        System.out.println("Has adivinado la palabra.");
    }

    public static String crearAnagrama (String palabraOriginal){
        char[] anagrama = palabraOriginal.toCharArray();
        String palabraDesordenada;
        for (int i = 0; i < anagrama.length; i++) {
            int indice1 = (int) (Math.random() * anagrama.length);
            int indice2 = (int) (Math.random() * anagrama.length);
            char aux = anagrama[indice1];
            anagrama[indice1] = anagrama[indice2];
            anagrama[indice2] = aux;
        }
        palabraDesordenada = String.valueOf(anagrama);
        return palabraDesordenada;
    }

    public static String letrasCorrecta (String palabraOriginal,String intentoUsuario){
        String letrasCorrectas = "";
        char[] arrayCorrecto = palabraOriginal.toCharArray();
        char[] arrayUsuario = intentoUsuario.toCharArray();
        int longitud = Math.min(arrayCorrecto.length,arrayUsuario.length);

        for (int i = 0; i < longitud; i++) {
            if (arrayCorrecto[i] == arrayUsuario[i]){
                letrasCorrectas += arrayCorrecto[i];
            } else {
                letrasCorrectas += "*";
            }
        }

        return letrasCorrectas;
    }
}

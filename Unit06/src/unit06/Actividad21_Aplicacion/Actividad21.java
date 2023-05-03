package unit06.Actividad21_Aplicacion;

import java.util.Scanner;

/*
    Lee una palabra o frase y muestra el proceso en el que cada letra se sustituye
    por otro símbolo no alfabético.
 */
public class Actividad21 {
    private static final char[] alfabetoMin = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static final String[] alfabetoCod = {"@", "8", "(", "|)", "€", "|=", "9", "#", "!", "_|", "|<", "£", "/\\\\/\\\\", "/\\\\/", "0", "¶", "O_", "®", "$", "†", "(_)", "\\/", "\\/\\/", "×", "¥", "2"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabra;
        String palabraCodificada = "";

        // Pedimos la palabra
        System.out.print("Introduce una palabra o frase: ");
        palabra = sc.nextLine().toLowerCase();

        // Codificamos la palabra
        palabraCodificada = codificarPalabra(palabra);

        // Mostramos la palabra codificada
        // System.out.println("Palabra codificada: " + palabraCodificada);
    }

    private static String codificarPalabra(String palabra) {
        StringBuilder palabraCodificada = new StringBuilder();
        String abecedario = String.valueOf(alfabetoMin);
        int indice;
        for (int i = 0; i < palabra.length(); i++) {
            indice = abecedario.indexOf(palabra.charAt(i));
            if (indice != -1) {
                palabraCodificada.append(alfabetoCod[indice]);
            } else {
                palabraCodificada.append(palabra.charAt(i));
            }
            System.out.println("Palabra codificada: " + palabraCodificada);
        }

        return palabraCodificada.toString();
    }
}

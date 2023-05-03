package unit06.Actividad16_Aplicacion;

import java.util.Scanner;

/*
    Escribe un programa descodificador que muestre un texto descodificado con el programa
    de la Actividad 11.
 */
public class Actividad16 {
    public static void main(String[] args) {
        final char[] conjunto1 = {'e','i','k','m','p','q','r','s','t','u','v'};
        final char[] conjunto2 = {'p','v','i','u','m','t','e','r','k','q','s'};
        Scanner sc = new Scanner(System.in);
        String textoCodificado;
        StringBuilder textoDescodificado = new StringBuilder();

        // Pedimos el texto codificado
        System.out.print("Introduce el texto codificado: ");
        textoCodificado = sc.nextLine().toLowerCase();

        // Descodificamos el texto
        for (int i = 0; i < textoCodificado.length(); i++) {
            textoDescodificado.append(descodificarTexto(conjunto1, conjunto2, textoCodificado.charAt(i)));
        }

        // Mostramos el texto descodificado
        System.out.println("El texto descodificado es: "+textoDescodificado);
    }

    private static char descodificarTexto(char[] conjunto1, char[] conjunto2, char c) {
        String descodificacion = String.valueOf(conjunto2);
        char descodificado;
        int pos = descodificacion.indexOf(c);

        if (pos != -1) {
            descodificado = conjunto1[pos];
        } else {
            descodificado = c;
        }
        return descodificado;
    }
}

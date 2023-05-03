package unit06.Actividad05;

import java.util.Scanner;

/*
    Diseñar una función a la que se le pase una cadena de caracteres y la devuelva invertida.
 */
public class Actividad5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        String cadenaInvertida;

        // Pedimos la cadena
        System.out.print("Ingrese una cadena: ");
        cadena = sc.nextLine();

        // Invertimos la cadena
        cadenaInvertida = invertirCadena(cadena);

        // Mostramos la cadena invertida
        System.out.println("La cadena invertida es: "+cadenaInvertida);
    }

    private static String invertirCadena(String cadena) {
        // Esta opción es más eficiente
        return new StringBuilder(cadena).reverse().toString();

        // Esta opción es menos eficiente
        /*
        String cadenaInvertida = "";
        for (int i = cadena.length()-1; i >= 0; i--) {
            cadenaInvertida += cadena.charAt(i);

        }
        return cadenaInvertida;
         */
    }

}

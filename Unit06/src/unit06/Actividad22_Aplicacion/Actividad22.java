package unit06.Actividad22_Aplicacion;

import java.util.Scanner;

/*
    Construir un programa que convierta una palabra en secuencias de n letras. Por ejemplo
    la palabra "destornillador" dividida en secuencia de 4 será "dest", "esto", "stor", "tor",
 */
public class Actividad22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabra;
        String palabraDividida;
        int n;

        // Pedimos la palabra
        System.out.print("Introduce una palabra: ");
        palabra = sc.next();
        // Pedimos el número de letras por secuencia
        System.out.print("Introduce el número de letras por secuencia: ");
        n = sc.nextInt();

        // Mostramos la palabra dividida en secuencias de n
        System.out.println("Palabra dividida en secuencias de " + n + ":");
        // Esto es mas avanzado, pero es una forma de hacerlo con streams
        //palabraDividida = Arrays.stream(dividirPalabra(palabra, n)).reduce("", (a, b) -> a + b + "\n");

        // Esto es más sencillo
        palabraDividida = String.join("\n", dividirPalabra(palabra, n));

        // Mostramos la palabra dividida
        System.out.println(palabraDividida);

    }

    public static String[] dividirPalabra(String palabra, int n) {
        String[] secuencias = new String[(int) Math.ceil(palabra.length() / (n+0.0))];
        int indice = 0;
        for (int i = 0; i < palabra.length(); i += n) {
            secuencias[indice] = palabra.substring(i, Math.min(i + n, palabra.length()));
            indice++;
        }
        return secuencias;
    }
}

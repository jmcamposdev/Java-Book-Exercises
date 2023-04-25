package unit13.Actividad18_Aplicacion;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
    Repite la Actividad 17, pero en vez de mostrar por pantalla las palabras,
    construye una cadena con las palabras de más de tres letras y muéstrala por pantalla.
 */
public class Actividad18 {
    public static void main(String[] args) {
        System.out.print("Ingrese una frase:");
        String frase = new Scanner(System.in).nextLine();

        String palabras = Arrays.stream(frase.split(" "))
                .filter(x -> x.length() > 3)
                .sorted()
                .collect(Collectors.joining(" "));

        System.out.println("Palabras de más de 3 letras ordenadas alfabéticamente: " + palabras);
    }
}

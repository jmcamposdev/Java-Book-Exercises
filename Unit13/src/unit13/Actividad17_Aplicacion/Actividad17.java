package unit13.Actividad17_Aplicacion;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
    A partir de una cadena con palabras separadas por espacios introducida por teclado,
    construye una tabla con las palabras. A partir de ella, crea un Stream con las palabras
    ordenadas por orden alfabético y muéstralas por pantalla..
 */
public class Actividad17 {
    public static void main(String[] args) {
        System.out.print("Ingrese una frase: ");
        String frase = new Scanner(System.in).nextLine();

        List<String> palabras = Arrays.stream(frase.split(" "))
                .sorted()
                .toList();

        System.out.println("Palabras ordenadas alfabéticamente: " + palabras);
    }
}

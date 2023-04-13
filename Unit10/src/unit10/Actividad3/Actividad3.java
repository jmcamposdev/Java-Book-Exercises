package unit10.Actividad3;

import java.io.BufferedReader;
import java.io.FileReader;

/*
    Repetir la Actividad 2 usando un flujo de texto con buffer.
*/

public class Actividad3 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        // Usamos un try-with-resources lo que nos ahorra tener que cerrar el BufferedReader ya que JVM lo cierra al terminal el try
        try (BufferedReader lector = new BufferedReader(new FileReader("./src/unit10/Actividad1/Actividad1.java"))) {
            String line; // Obtenemos la línea
            while ((line = lector.readLine()) != null) { // Mientras la línea no sea null es decir existe texto
                text.append(line).append("\n"); // Añadimos el texto
            }
        } catch (Exception e) {
            System.out.println("No existe el fichero");
        }
        System.out.println(text);
    }
}

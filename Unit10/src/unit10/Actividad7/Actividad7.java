package unit10.Actividad7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
   Para escribir en un fichero vamos a escribir:
    "En un lugar de La Mancha,
    de cuyo nombre no quiero acordarme..."

    La primera Línea caracter a caracter y la segunda en una sola sentencia.
 */
public class Actividad7 {
    public static void main(String[] args) {
        String cad = "En un lugar de La Mancha,";
        String cad2 = "de cuyo nombre no quiero acordarme...";
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("./src/unit10/Actividad7/LaMancha.txt"))) {
            for (int i = 0; i < cad.length(); i++) { // Caracter a caracter
                escritor.write(cad.charAt(i));
            }
            escritor.newLine(); // Salto de línea
            escritor.write(cad2); // En una sola sentencia
            System.out.println("Se ha escrito en el Fichero: LaMancha.txt");
        } catch (IOException e) {
            System.out.println("No existe el fichero");
        }
    }
}

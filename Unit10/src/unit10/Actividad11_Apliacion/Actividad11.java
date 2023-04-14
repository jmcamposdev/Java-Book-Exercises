package unit10.Actividad11_Apliacion;

import java.io.File;
import java.io.IOException;

/*
    Escribe un programa que solicite al usuario el nombre de un fichero de texto y mestre su cotenido en pantalla
    Si no se proporciona ningun nombre de fichero la aplicación utilizará por defecto prueba.txt.
 */
public class Actividad11 {
    public static void main(String[] args) {
        System.out.println("Este programa lee el contenido de un fichero de texto y lo muestra en pantalla.");
        System.out.println("----------------------------------------------");
        System.out.print("Ingrese la ruta absoluta del fichero:");
        File selectedFile = new File(new java.util.Scanner(System.in).nextLine());
        if (!selectedFile.exists()) {
            selectedFile = new File("./src/unit10/Actividad11_Apliacion/prueba.txt");
            System.out.println("Se ha cargado el fichero por defecto.");
        }
        
        try (java.io.BufferedReader lector = new java.io.BufferedReader(new java.io.FileReader(selectedFile))) {
            System.out.println("Contenido del fichero:");
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("No se ha encontrado el fichero");
        }

    }
}

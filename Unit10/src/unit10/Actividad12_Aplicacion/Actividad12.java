package unit10.Actividad12_Aplicacion;

import Functions.GetData;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
    Diseña una aplicación que pida al usuario su nombre y edad.
    Estos datos deben guardarse en el fichero datos.txt.
    Si este fichero existe, deben añadirse al final en una nueva línea, y en caso de no existir, debe crearse.
 */
public class Actividad12 {
    public static void main(String[] args) {
        System.out.println("Este programa pide al usuario su nombre y edad y los guarda en un fichero.");
        System.out.println("-----------------------------------------------------------------------");
        String nombre = GetData.getString("Ingrese su nombre: ");
        int edad = GetData.getInt("Ingrese su edad:", 0, 99);
        File file = new File("./src/unit10/Actividad12_Aplicacion/datos.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("No se ha posidido crear el Fichero");
            }
            
        }
        
        try (java.io.BufferedWriter escritor = new java.io.BufferedWriter(new java.io.FileWriter(file, true))) {
            escritor.write(nombre + " " + edad);
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("No se puede escribir en el fichero");;
        }
    }
}

package unit11.Actividad01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
    Escribir en un archivo datos.dat los valores de una tabla de diez enteros.
 */
public class Actividad1 {
    public static void main(String[] args) {
        int[] tabla = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        File fichero = new File("src/unit11/Actividad01/datos.dat");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            // This can also be done with oos.writeObject(table); which saves the whole array and is a better option.
            // For the activity that requires saving element by element later on, oos.writeObject() will be used;
            for (int i : tabla) {
                oos.writeInt(i);
            }
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

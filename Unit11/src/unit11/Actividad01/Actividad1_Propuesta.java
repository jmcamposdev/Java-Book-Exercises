package unit11.Actividad01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
    Repita la Actividad1 escribiendo la tabla de enteros en el archvivo datos.dat,
    y no los enteros individuales.
 */
public class Actividad1_Propuesta {
    public static void main(String[] args) {
        int[] tabla = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        File fichero = new File("src/unit11/Actividad01/datos.dat");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(tabla); // This saves the whole array and is a better option.
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

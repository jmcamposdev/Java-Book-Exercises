package unit11.Actividad04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
    Leer de un archivo datos.dat 10 números enteros, guardándolos en un atabla de tipo int.
 */
public class Actividad4 {
    public static void main(String[] args) {
        File archivo = new File("src/unit11/Actividad04/datos.dat");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            int[] tabla = new int[10];
            for (int i = 0; i < 10; i++) {
                tabla[i] = ois.readInt();
            }
            System.out.println("Se ha leído la tabla del fichero binario.");
            for (int i = 0; i < 10; i++) {
                System.out.print(tabla[i]+" ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

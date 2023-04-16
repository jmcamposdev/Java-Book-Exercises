package unit11.Actividad05;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/*
    Leer una tabla de enteros de n archivo datos.dat y mostrarla por pantalla.
 */
public class Actividad5 {
    public static void main(String[] args) {
        File archivo = new File("src/unit11/Actividad05/datos.dat");

        try (ObjectInputStream fujoEntrada = new ObjectInputStream(new FileInputStream(archivo))) {
            int[] tabla = (int[]) fujoEntrada.readObject();
            System.out.println("La tabla leída es:");
            System.out.println(Arrays.toString(tabla));
        } catch (ClassNotFoundException e) {
            System.out.println("Error al leer el objeto.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

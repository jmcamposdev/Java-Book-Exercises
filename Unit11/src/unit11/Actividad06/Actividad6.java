package unit11.Actividad06;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
    Recuperar la estrofa del archivo cancionPirata.dat dde la Actividad 2 y mostrarla por pantalla.
 */
public class Actividad6 {
    public static void main(String[] args) {
        File archivo = new File("src/unit11/Actividad02/cancionPirata.dat");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            String estrofa = (String) ois.readObject();
            System.out.println(estrofa);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al leer el objeto.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }

    }
}

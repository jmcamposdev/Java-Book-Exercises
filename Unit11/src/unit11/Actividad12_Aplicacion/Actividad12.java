package unit11.Actividad12_Aplicacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
    Abre el fichero de la Actividad 11, lee el valor double contenido en él y muestra por pantalla.
 */
public class Actividad12 {
    public static void main(String[] args) {
        File fichero = new File("src/unit11/Actividad11_Aplicacion/numeroDouble.dat");
        if (fichero.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                double numero = ois.readDouble();
                System.out.println("El número leído es: " + numero);
            } catch (IOException e) {
                System.out.println("Error al leer el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}

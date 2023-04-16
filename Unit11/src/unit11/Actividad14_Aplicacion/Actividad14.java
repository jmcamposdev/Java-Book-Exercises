package unit11.Actividad14_Aplicacion;

import java.io.*;
import java.util.Scanner;

/*
    Introduce por teclado una frase y guárdala en un archivo binario. A continuación recupérala y muestral por pantalla.
 */
public class Actividad14 {
    private static final File fichero = new File("src/unit11/Actividad14_Aplicacion/frase.dat");
    public static void main(String[] args) {
        System.out.print("Introduce una frase:");
        String frase = new Scanner(System.in).nextLine();
        escribirFrase(frase);
        String fraseLeida = leerFrase();
        if (fraseLeida != null) {
            System.out.println("Frase leida:");
            System.out.println(fraseLeida);
        }
    }

    private static String leerFrase() {
        String frase = null;
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(fichero))) {
            frase = (String) oos.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el fichero");
        }
        return frase;
    }

    private static void escribirFrase(String frase) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(frase);
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }
    }
}

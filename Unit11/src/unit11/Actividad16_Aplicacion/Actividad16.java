package unit11.Actividad16_Aplicacion;

import java.io.*;
import java.util.ArrayList;

/*
    Implementa una aplicación que gestione una lista de nombres ordenada por orden alfabético.
    Al arrancar se leerá de un fichero los nombres insertados anteriormente y se pedirán nombres nuevos hasta que se introduzca la cadena «fin».
    Cada nombre que se introduzca deberá añadirse a los que ya había, de forma que la lista permanezca ordenada.
    Al terminar se guardará en el fichero la lista actualizada.
 */
public class Actividad16 {
    private static final File fichero = new File("src/unit11/Actividad16_Aplicacion/nombres.dat");
    private static ArrayList<String> nombres = new ArrayList<>();
    public static void main(String[] args) {
        String userInput = "";
        cargarNombresDeFichero(); // Cargamos los nombres del fichero

        while (!userInput.equals("fin")) {
            System.out.print("Introduce un nombre:");
            userInput = new java.util.Scanner(System.in).nextLine();
            if (!userInput.equals("fin")) {
                nombres.add(userInput); // Añadimos el nombre a la lista
            }
        }
        nombres.sort(String::compareToIgnoreCase); // Ordenamos los nombres
        guardarNombresEnFichero(); // Guardamos los nombres en el fichero
    }

    private static void guardarNombresEnFichero() {
        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(fichero))) {
            ois.writeObject(nombres);
            System.out.println("Se ha guardado correctamente el fichero");
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }
    }

    private static void cargarNombresDeFichero() {
        if (fichero.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                nombres = (ArrayList<String>) ois.readObject();
                System.out.println("Se ha cargado correctamente el fichero");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer el fichero");
            }
        }

    }
}

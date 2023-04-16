package unit11.Actividad17_Aplicacion;

import java.io.*;
import java.util.Scanner;

/*
    Escribe un texto, línea a línea, de forma que, cada vez que se pulse Intro, se guarde la línea en un archivo binario.
    El proceso se termina cuando introduzcamos una línea vacía.
    Después el programa lee el texto completo del archivo y lo muestra por pantalla.
 */
public class Actividad17 {
    private static final File fichero = new File("src/unit11/Actividad17_Aplicacion/texto.dat");
    public static void main(String[] args) {
        borraFichero(); // Borramos el fichero si existe
        escribirFichero(); // Escribimos el fichero
        leerFichero(); // Leemos el fichero
    }

    private static void escribirFichero() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero, true))) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Escribe el texto, pulse Intro para guardar la línea y vacío para terminar:");
            String linea;
            do { // Escribimos el fichero
                linea = sc.nextLine();
                if (!linea.isEmpty()) {
                    oos.writeObject(linea);
                }
            } while (!linea.isEmpty());
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }
    }

    private static void leerFichero() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            System.out.println("Leyendo el fichero:");
            String linea;
            while (true) {
                linea = (String) ois.readObject();
                System.out.println(linea);
            }
        } catch (EOFException e) {
            System.out.println("Fin del fichero");
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el fichero");
        }
    }

    private static void borraFichero() {
        if (fichero.exists()) {
            fichero.delete();
        }
    }
}

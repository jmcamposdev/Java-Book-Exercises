package unit11.Actividad13_Aplicacion;

import java.io.*;

/*
    Escribe un programa que lea de un fichero binario una tabla de números double y después muestre
    el contenido de la tabla por pantalla.
 */
public class Actividad13 {
    private static final File fichero = new File("src/unit11/Actividad13_Aplicacion/tablaDouble.dat");
    public static void main(String[] args) {
        leerTabla();
    }

    private static void leerTabla() {
        double[] tabla;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            tabla = (double[]) ois.readObject();
            for (double d : tabla) {
                System.out.println(d);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el fichero");
        }
    }

    private static void escribirTabla() {
        double[] tabla = {1.2, 3.4, 5.6, 7.8, 9.0, 11.2, 13.4, 15.6, 17.8, 19.0};
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(tabla);
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }
    }
}


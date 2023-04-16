package unit11.Actividad07;

import Functions.GetData;

import java.io.*;

/*
    Graba en el fichero numeros.dat una serie de números enteros no negativos introducidos por teclado.
    La serie acabará cuando escribamos -1. Abrir de nuevo numeros.dat para lectura y leer todos los números
    hasta el final del fichero, mostrándolos por pantalla y copiándolos en un segundo fichero numerosCopia.dat.
 */
public class Actividad7 {
    public static void main(String[] args) {
        File archivo = new File("src/unit11/Actividad07/numeros.dat");
        File archivoCopia = new File("src/unit11/Actividad07/numerosCopia.dat");

        // Escribir todos los números en el fichero.
        try (ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(archivo))) {
            int numero = GetData.getInt("Introduce un número entero: ", -1);
            while (numero != -1){
                flujoSalida.writeInt(numero);
                numero = GetData.getInt("Introduce un número entero: ", -1);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(archivo));
            ObjectOutputStream flujoSalidaCopia = new ObjectOutputStream(new FileOutputStream(archivoCopia))) {
            int numero;
            while (true) {
                numero = flujoEntrada.readInt();
                System.out.print(" " + numero + "");
                flujoSalidaCopia.writeInt(numero);
            }
        } catch (EOFException e) {
            System.out.println("\nFin de fichero.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

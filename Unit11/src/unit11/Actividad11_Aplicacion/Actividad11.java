package unit11.Actividad11_Aplicacion;

import Functions.GetData;

import java.io.*;

/*
    Pide un valor double por consola y guárdalo en un archivo binario.
 */
public class Actividad11 {
    public static void main(String[] args) {
        File archivo = new File("src/unit11/Actividad11_Aplicacion/numeroDouble.dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            double numero = GetData.getDouble("Introduce un número real: ",1);
            oos.writeDouble(numero);
            System.out.println("Se ha escrito el número en el fichero binario.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo.");
        }
    }
}

package unit11.Actividad03;

import Functions.GetData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
    Pedir un entero n por consola y, a continuación, pedir n números de tipos double,
    que iremos insertando un una tabla. Guardar la tabla en un archivo binario.
 */
public class Actividad3 {
    public static void main(String[] args) {
        File archivo = new File("src/unit11/Actividad03/tableNumeros.dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            int n = GetData.getInt("Introduce un número entero: ",1);
            double[] tabla = new double[n];
            for (int i = 0; i < n; i++) {
                tabla[i] = GetData.getDouble("Introduce un número real: ",1);
            }
            oos.writeObject(tabla);
            System.out.println("Se ha escrito la tabla en el fichero binario.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

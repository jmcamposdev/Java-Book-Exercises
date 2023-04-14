package unit10.Actividad08;

import java.io.*;
import java.util.Scanner;

/*
    Escribir un programa que duplique el contenido de un fichero cuyo nombre se pide al usuario.
    El fichero copia tendrá el mismo nombre con el prefijo copia_de_
 */
public class Actividad8 {
    public static void main(String[] args) throws IOException {
        System.out.print("Ingrese la ruta absoluta del fichero: ");
        File ficheroBase = new File(new Scanner(System.in).next());
        File ficheroCopia = new File(ficheroBase.getParent()+"/copia_de_"+ficheroBase.getName());
        
        try (BufferedReader lectorOriginal = new BufferedReader(new FileReader(ficheroBase));
             BufferedWriter escritorCopia = new BufferedWriter(new FileWriter(ficheroCopia))) {
            String linea;
            while ((linea = lectorOriginal.readLine()) != null) {
                escritorCopia.write(linea);
                escritorCopia.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se ha encotrado el fichero o la ruta es errónea");
        }
    }
}

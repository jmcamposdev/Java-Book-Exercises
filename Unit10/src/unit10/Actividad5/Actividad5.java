package unit10.Actividad5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
    Crear con un editor de texto llamado NumerosRealesLineas.txt en la carpeta del proyecto.
    Escribir en el fichero una serie de números separados por líneas. Convertir las cadenas leídas en números
    de tipo double por medio de Scanner, y mostrando al final la suma de todos ellos.
 */
public class Actividad5 {
    public static void main(String[] args) {
        double suma = 0;
        try (Scanner lector = new Scanner(new File("./src/unit10/Actividad5/NumerosRealesLineas.txt"))) {
            while (lector.hasNextLine()) {
                suma += lector.nextDouble();
            }
            
            System.out.println("La suma de los números es: " + suma);
        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero");
        } catch(ArithmeticException e) {
            System.out.println("Se esperava que todo el contendio fuesen números.");
        }
        
    }
}

package unit10.Actividad4;

import java.io.BufferedReader;
import java.io.FileReader;

/*
    Crear con un editor de texto llamado NumerosReales.txt en la carpeta del proyecto
    de Netbeans. Escribir en el una serie de números realices separados por espacios simples.

    Implementar un programa que acceda al fichero lea los números y calcule la suma y la media
    aritmética de los mismos. Mostrar el resultado por pantalla.
 */
public class Actividad4 {
    public static void main(String[] args) {
        int suma = 0;
        int media = 0;
        try (BufferedReader lector = new BufferedReader(new FileReader("./src/unit10/Actividad4/NumerosReales.txt"))) {
            String line = lector.readLine();
            String[] numeros = line.split(" ");
            for (String numero : numeros) {
                suma += Integer.parseInt(numero);
            }
            media = suma / numeros.length;
        } catch (Exception e) {
            System.out.println("No existe el fichero");
        }

        System.out.println("La suma de los números es: " + suma);
        System.out.println("La media de los números es: " + media);


    }
}


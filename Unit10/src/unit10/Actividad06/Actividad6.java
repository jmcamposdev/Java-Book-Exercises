package unit10.Actividad06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
    Crear con un editor del fichero de texto Enteros.txt en la carpeta del proyecto.
    Escribir en él una serie de números separados por una secuencia de espacios y tabulaciones e
    incluso lineas en blanco.
    Implementar un programa que accceda a Enteros.txt con un Objeto Scanner a traves de un flujo de entrada
    lea los números y calcula su suma y su media aritmética. Mostrar el resultado por pantalla.
 */
public class Actividad6 {
    public static void main(String[] args) {
        int suma = 0;
        int contadorDeNumeros = 0;
        int media = 0;
        try (Scanner lector = new Scanner(new File("./src/unit10/Actividad6/Enteros.txt"))) {
            while (lector.hasNext()) {
                suma += lector.nextInt();
                contadorDeNumeros++;
            }
            media = suma / contadorDeNumeros;
            System.out.println("La suma de los números es: " + suma);
            System.out.println("La media de los números es: " + media);
        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero");
        } catch (ArithmeticException e) {
            System.out.println("Se esperaba que todo el contenido fuesen números enteros");
        }
        
    }
}

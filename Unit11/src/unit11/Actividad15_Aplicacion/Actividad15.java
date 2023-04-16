package unit11.Actividad15_Aplicacion;

import java.io.*;

/*
    Implementa un programa que lea números enteros desde un fichero numeros.dat y los
    vaya guardando en los ficheros pares.dat e impares.dat según sea su paridad.
 */
public class Actividad15 {
    private static final File fichero = new File("src/unit11/Actividad15_Aplicacion/numeros.dat");
    private static final File ficheroPares = new File("src/unit11/Actividad15_Aplicacion/pares.dat");
    private static final File ficheroImpares = new File("src/unit11/Actividad15_Aplicacion/impares.dat");
    public static void main(String[] args) {
        leerNumeros();
    }

    private static void leerNumeros() {
        int arraySize;
        int numero;
        // Leemos el fichero numeros.dat y guardamos los números pares en pares.dat y los impares en impares.dat
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
             ObjectOutputStream oosPares = new ObjectOutputStream(new FileOutputStream(ficheroPares));
             ObjectOutputStream oosImpares = new ObjectOutputStream(new FileOutputStream(ficheroImpares))) {
            arraySize = ois.readInt(); // Leemos el tamaño del array
            for (int i = 0; i < arraySize; i++) { // Leemos los números del array
                numero = ois.readInt();
                if (numero % 2 == 0) { // Si el número es par lo guardamos en pares.dat
                    oosPares.writeInt(numero);
                } else { // Si el número es impar lo guardamos en impares.dat
                    oosImpares.writeInt(numero);
                }
            }
        } catch (IOException e) { // Si hay algún error al leer el fichero
            System.out.println("Error al leer el fichero");
        }
    }

    private static void escribirNumeros() {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeInt(numeros.length); // Guardamos el tamaño del array
            for (int numero : numeros) { // Guardamos cada elemento del array
                oos.writeInt(numero);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }
    }
}

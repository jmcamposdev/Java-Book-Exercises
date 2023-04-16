package unit11.Actividad25_Aplicacion;

import Functions.GetData;

import java.io.*;

/*
    En una tabla de cadenas se guardan los nombres de 4 ficheros binarios.
    En cada uno de ellos se guarda una tabla de números enteros ordenados en sentido creciente.
    Implementa una aplicación donde se introduce por teclado un número entero.
    El programa debe determinar si ese número se halla en alguno de los 4 ficheros y,
    en caso afirmativo, en cuál de ellos y en qué lugar de la tabla correspondiente
 */
public class Actividad25 {
    public static void main(String[] args) {

        // Crear los ficheros
        escribirFichero("src/unit11/Actividad25_Aplicacion/fichero1.dat", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        escribirFichero("src/unit11/Actividad25_Aplicacion/fichero2.dat", new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
        escribirFichero("src/unit11/Actividad25_Aplicacion/fichero3.dat", new int[]{21, 22, 23, 24, 25, 26, 27, 28, 29, 30});
        escribirFichero("src/unit11/Actividad25_Aplicacion/fichero4.dat", new int[]{31, 32, 33, 34, 35, 36, 37, 38, 39, 40});
        // Nombre de los ficheros
        String[] ficheros = {"src/unit11/Actividad25_Aplicacion/fichero1.dat",
                "src/unit11/Actividad25_Aplicacion/fichero2.dat",
                "src/unit11/Actividad25_Aplicacion/fichero3.dat",
                "src/unit11/Actividad25_Aplicacion/fichero4.dat"};

        // Pedir al usuario un número entero
        int numero = GetData.getInt("Introduce un número entero: ");

        // Buscar el número en los ficheros
        boolean encontrado = false;
        for (int i = 0; i < ficheros.length && !encontrado; i++) {
            try (ObjectInputStream dis = new ObjectInputStream(new FileInputStream(ficheros[i]))) {
                int tamano = dis.readInt();  // Leer el tamaño de la tabla
                for (int j = 0; j < tamano && !encontrado; j++) {
                    int elemento = dis.readInt();  // Leer un elemento de la tabla
                    if (elemento == numero) {
                        // El número se ha encontrado en este fichero y en este lugar de la tabla
                        System.out.printf("El número %d se encuentra en el fichero %s, en la posición %d de la tabla.%n", numero, ficheros[i], j);
                        encontrado = true;
                    }
                }
            } catch (IOException e) {
                System.err.printf("Error al leer el fichero %s: %s%n", ficheros[i], e.getMessage());
            }
        }

        // El número no se ha encontrado en ninguno de los ficheros
        System.out.printf("El número %d no se encuentra en ninguno de los ficheros.%n", numero);
    }

    private static void escribirFichero(String nombreFichero, int[] tabla) {
        try (ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
            dos.writeInt(tabla.length);  // Escribir el tamaño de la tabla
            for (int elemento : tabla) {
                dos.writeInt(elemento);  // Escribir un elemento de la tabla
            }
        } catch (IOException e) {
            System.err.printf("Error al escribir el fichero %s: %s%n", nombreFichero, e.getMessage());
        }
    }
}

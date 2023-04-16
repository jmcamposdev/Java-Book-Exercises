package unit11.Actividad08;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
    Implementar un programa que guarde en el fichero socios.dat una tabla de objetos Socio.
    Después se abrirá el fichero en modo lectura para recuperar la tabla socios, mostrándose por pantalla
 */
public class Actividad8 {
    public static void main(String[] args) {
        File archivo = new File("src/unit11/Actividad08/socios.dat");

        ArrayList<Socio> socios = new ArrayList<>();
        socios.add(new Socio("Juan", "12345678"));
        socios.add(new Socio("Pedro", "87654321"));
        socios.add(new Socio("Luis", "12345678"));
        socios.add(new Socio("Ana", "87654321"));
        socios.add(new Socio("María", "12345678"));
        System.out.println("La Tabla de Socios es:");
        System.out.println(Arrays.deepToString(socios.toArray()));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(socios);
            System.out.println("Se ha escrito la tabla de socios en el fichero binario.");
        } catch (IOException e) {
            System.out.println("Error al escribir el objeto.");
        }

        try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(archivo))) {
            socios = (ArrayList<Socio>) flujoEntrada.readObject();
            System.out.println("La tabla de socios leída es:");
            System.out.println(Arrays.deepToString(socios.toArray()));
        } catch (ClassNotFoundException e) {
            System.out.println("Error al leer el objeto.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}

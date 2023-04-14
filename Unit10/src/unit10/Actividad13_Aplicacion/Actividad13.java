package unit10.Actividad13_Aplicacion;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
 Implementa un programa que lea dos listas de números enteros no ordenados de sendos archivos con un número por línea,
  los reúna en una lista única y los guarde en orden creciente en un tercer archivo, de nuevo uno por línea.
  */
public class Actividad13 {
     public static void main(String[] args) {
         File file1 = new File("src/unit10/Actividad13_Aplicacion/listaNumerosEnteros1.txt");
         File file2 = new File("src/unit10/Actividad13_Aplicacion/listaNumerosEnteros2.txt");
         File fileOrdenado = new File("src/unit10/Actividad13_Aplicacion/listaNumerosEnterosOrdenado.txt");
         ArrayList<Integer> listaNumeros = new ArrayList<>();
         System.out.println("Apliación que lee dos listas de números enteros no ordenados de sendos archivos con un número por línea,"
                 + "\nlos reúna en una lista única y los guarde en orden creciente en un tercer archivo, de nuevo uno por línea.");
         
         if (file1.exists() && file2.exists()) { // Comprobamos que existan los dos fichero necesarios
             try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
                  BufferedReader br2 = new BufferedReader(new FileReader(file2));
                  PrintWriter pw = new PrintWriter(new FileWriter(fileOrdenado))) {
                 String line;
                 // Añadimos los números del fichero listaNumerosEnteros1.txt
                 while ((line = br1.readLine()) != null) {
                     listaNumeros.add(Integer.parseInt(line));
                 }
                 // Añadimos los números del fichero listaNumerosEnteros2.txt
                 while ((line = br2.readLine()) != null) {
                     listaNumeros.add(Integer.parseInt(line));
                 }
                 Collections.sort(listaNumeros); // Ordenamos los números
                 // Insertamos todos los números en el nuevo Fichero, si no existe se crea automaticamente
                 for (Integer numero : listaNumeros) {
                     pw.println(numero);
                 }
                 System.out.println("Se ha creado el archivo con los números ordenados correctamente. Se llama: " + fileOrdenado.getName());
             } catch (IOException e) {
                 e.printStackTrace();
             }
         } else {
             System.out.println("No existen los dos ficheros necesarios para crear el tercero");
         }
     }
}

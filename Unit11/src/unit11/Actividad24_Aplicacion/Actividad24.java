package unit11.Actividad24_Aplicacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
    Implementa el método, void fusionar (String ficheroBase, String ficheroNuevo),
    que añade a ficheroBase, los elementos de ficheroNuevo, ambos ordenados.
    Al final. ficheroBase contiene la lista ordenada de todos los elementos de ambos ficheros.
 */
public class Actividad24 {

    public static void main(String[] args) {
        fusionar("fichero_base.txt", "fichero_nuevo.txt");
    }

    public static void fusionar(String ficheroBase, String ficheroNuevo) {
        try {
            // Leer los contenidos de los ficheros de entrada
            List<String> listaBase = leerFichero(ficheroBase);
            List<String> listaNuevo = leerFichero(ficheroNuevo);

            // Fusionar las dos listas y ordenar el resultado
            List<String> listaFusionada = fusionarListasOrdenadas(listaBase, listaNuevo);

            // Escribir el resultado en el fichero de salida
            escribirFichero(ficheroBase, listaFusionada);
        } catch (IOException e) {
            System.err.println("Error al fusionar los ficheros: " + e.getMessage());
        }
    }

    private static List<String> leerFichero(String nombreFichero) throws IOException {
        List<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
        }
        return lista;
    }

    private static void escribirFichero(String nombreFichero, List<String> lista) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))) {
            for (String elemento : lista) {
                bw.write(elemento);
                bw.newLine();
            }
        }
    }

    private static List<String> fusionarListasOrdenadas(List<String> lista1, List<String> lista2) {
        List<String> listaFusionada = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i).compareTo(lista2.get(j)) < 0) {
                listaFusionada.add(lista1.get(i));
                i++;
            } else {
                listaFusionada.add(lista2.get(j));
                j++;
            }
        }
        while (i < lista1.size()) {
            listaFusionada.add(lista1.get(i));
            i++;
        }
        while (j < lista2.size()) {
            listaFusionada.add(lista2.get(j));
            j++;
        }
        return listaFusionada;
    }


}

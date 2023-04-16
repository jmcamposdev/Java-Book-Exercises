package unit11.Actividad23_Aplicacion;


import java.io.*;

/*
    Implementa el método, Integer [] fusionar (String ficherol, String fichero2).
    Al que se le pasan los nombres de dos ficheros binarios que contienen dos listas ordenadas de objetos Integer,
    y devuelve una tabla ordenada con todos los elementos de los dos ficheros fusionados.
 */
public class Actividad23 {
    public static void main(String[] args) {
//        generarFicheroLista(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, "src/unit11/Actividad23_Aplicacion/lista1.dat");
//        generarFicheroLista(new Integer[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, "src/unit11/Actividad23_Aplicacion/lista2.dat");
        Integer[] lista = fusionar("src/unit11/Actividad23_Aplicacion/lista1.dat", "src/unit11/Actividad23_Aplicacion/lista2.dat");
        if (lista != null) {
            for (Integer i : lista) {
                System.out.print(i+" ");
            }
        }
    }

    private static Integer[] fusionar(String fichero1, String fichero2) {
        File f1 = new File(fichero1);
        File f2 = new File(fichero2);
        if (!f1.exists() || !f2.exists()) {
            System.out.println("Alguno de los ficheros no existe");
            return null;
        }

        try (ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(fichero1));
             ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(fichero2))) {
            Integer[] lista1 = (Integer[]) ois1.readObject();
            Integer[] lista2 = (Integer[]) ois2.readObject();
            Integer[] resultado = new Integer[lista1.length + lista2.length];

            System.arraycopy(lista1, 0, resultado, 0, lista1.length);
            System.arraycopy(lista2, 0, resultado, lista1.length, lista2.length);
            return resultado;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el fichero");
            return null;
        }
    }

    private static void generarFicheroLista(Integer[] lista, String nombreFichero) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }

    }
}

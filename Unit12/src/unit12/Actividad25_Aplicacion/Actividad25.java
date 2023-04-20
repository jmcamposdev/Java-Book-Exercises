package unit12.Actividad25_Aplicacion;

import Functions.GetData;

import java.util.*;

/*
    Escribe un programa donde se introduzca por consola una frase que conste
    exclusivamente de palabras separadas por espacios.
    Las palabras de la frase se almacenarán en una lista.

    Finalmente, se mostrarán por pantalla las palabras que estén repetidas y a continuación, las que no lo estén.
 */
public class Actividad25 {
    public static void main(String[] args) {
        String frase = GetData.getString("Introduce una frase: ");
        String[] palabras = frase.split(" ");
        List<String> listaPalabras = new ArrayList<>(Arrays.asList(palabras));
        System.out.println("Lista original: " + listaPalabras);
        Set<String> sinRepetir = new HashSet<>(listaPalabras);
        for (String palabra : sinRepetir) {
            listaPalabras.remove(palabra);
        }
        Set<String> repetidas = new HashSet<>(listaPalabras);
        System.out.println("Palabras repetidas: " + repetidas);
        Set<String> unicos = new HashSet<>(listaPalabras);
        unicos.addAll(sinRepetir);
        unicos.removeAll(listaPalabras);
        System.out.println("Palabras únicas: " + unicos);
    }
}

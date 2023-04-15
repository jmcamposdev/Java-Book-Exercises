package unit10.Actividad27_Ampliacion;

import java.io.*;

/*
    Repite la Actividad 14, pero sabiendo que una palabra puede no estar separada de otro solo por un espacio.
    También puede ser un tabulador, punto, coma o punto y coma
 */
public class Actividad27 {
    public static void main(String[] args) {
        File carta = new File("src/unit10/Actividad27_Ampliacion/carta.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(carta))) {
            String linea;
            int palabras = 0;
            int lineas = 0;
            int caracteres = 0;
            while ((linea = br.readLine()) != null) {
                palabras += contarPalabras(linea);
                caracteres += contarCaracteres(linea);
                lineas++;
            }
            System.out.println("El número de palabras es: " + palabras + "\nEl número de líneas es: " + lineas + "\nEl número de caracteres es: " + caracteres);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }




    public static int contarCaracteres(String cadena) {
        return cadena.length();
    }

    public static int contarPalabras(String cadena) {
        int contador = 0;
        boolean palabra = false;
        int longitud = cadena.length() - 1;

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ' && cadena.charAt(i) != '.' && cadena.charAt(i) != ',' && cadena.charAt(i) != ';') {
                palabra = true;
                if (i == longitud) {
                    contador++;
                }
            } else {
                if (palabra) {
                    contador++;
                }
                palabra = false;
            }
        }
        return contador;
    }
}

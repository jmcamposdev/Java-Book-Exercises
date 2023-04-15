package unit10.Actividad28.Ampliacion;

import Functions.GetData;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Diseña un programa al que se le proporcione el nombre de un fichero de texto y una cadena. Debemos buscar todas las ocurrencias de la cadena en el fichero.
 */
public class Actividad28 {
    public static void main(String[] args) {
        StringBuilder contenidoFichero = new StringBuilder();
        File fichero;
        do {
            fichero = new File(GetData.getString("Introduce el nombre del fichero: "));
            if (!fichero.exists()) {
                System.out.println("El fichero no existe");
            }
        } while (!fichero.exists());

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String cad;
            while ((cad = br.readLine()) != null) {
                contenidoFichero.append(cad);
            }

            int numeroCoincidencias = buscarCoincidencias(contenidoFichero.toString(), GetData.getString("Introduce la cadena a buscar: "));
            System.out.println("El número de coincidencias es: " + numeroCoincidencias);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }

    public static int buscarCoincidencias(String cadena, String cadenaBuscar) {
        Pattern p = Pattern.compile(cadenaBuscar);
        Matcher m = p.matcher(cadena);
        int contador = 0;
        while (m.find()) {
            contador++;
        }
        return contador;
    }


}

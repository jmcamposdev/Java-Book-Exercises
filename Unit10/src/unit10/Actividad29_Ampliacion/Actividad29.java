package unit10.Actividad29_Ampliacion;

import Functions.GetData;

import java.io.*;

/*
    Escribe un programa que pida el nombre de un fichero de texto que contenga código fuente en Java.
    El programa debe crear un nuevo fichero que tenga como nombre el mismo del fichero original con el prefijo «sin_comentarios_».
    El nuevo fichero tendrá como contenido el código fuente sin ningún tipo de comentarios.
 */
public class Actividad29 {
    public static void main(String[] args) {
        System.out.println("Este programa crea un nuevo fichero que tiene como nombre el mismo del fichero original con el prefijo \"sin_comentarios_\". \nEn el mismo directorio que el fichero original.");
        File fichero;
        do { // Iteramos hasta que el fichero exista
            fichero = new File(GetData.getString("Introduce el nombre del fichero: "));
            if (!fichero.exists()) {
                System.out.println("El fichero no existe");
            }
        } while (!fichero.exists());

        // Creamos el fichero sin comentarios
        String nombreFicheroSinComentarios = fichero.getParentFile() + File.separator +"sin_comentarios_" + fichero.getName();
        File ficheroSinComentarios = new File(nombreFicheroSinComentarios);
        if (ficheroSinComentarios.exists()) { // Si el fichero ya existe lo borramos
            if (ficheroSinComentarios.delete()) {
                System.out.println("Se ha eliminado el fichero anterior");
            }
        }
        try { // Creamos el fichero
            if (ficheroSinComentarios.createNewFile()) {
                System.out.println("Se ha creado el fichero sin comentarios");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
        }
        // Leemos el contenido del fichero
        try(BufferedReader br = new BufferedReader(new FileReader(fichero));
            PrintWriter pw = new PrintWriter(new FileWriter(ficheroSinComentarios))) {
            boolean multiLinea = false;
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("//")) { // Si la linea contiene un comentario de una linea
                    linea = linea.substring(0, linea.indexOf("//"));
                }
                if (linea.contains("/*")) { // Si la linea contiene un comentario de varias lineas
                    multiLinea = true;
                    linea = linea.substring(0, linea.indexOf("/*"));
                }
                if (linea.contains("*/")) { // Si la linea contiene el final de un comentario de varias lineas
                    multiLinea = false;
                    linea = linea.substring(linea.indexOf("*/") + 2);
                }
                if (linea.contains("/**")) { // Si la linea contiene un comentario de varias lineas
                    linea = linea.substring(0, linea.indexOf("/**"));
                }
                if (linea.contains("*/")) { // Si la linea contiene el final de un comentario de varias lineas
                    linea = linea.substring(linea.indexOf("*/") + 2);
                }
                if (multiLinea) { // Si estamos en un comentario de varias líneas
                    if (linea.contains("*/")) {
                        multiLinea = false;
                        linea = linea.substring(linea.indexOf("*/") + 2);
                    } else {
                        linea = "";
                    }
                }
                pw.println(linea); // Escribimos la línea en el fichero sin comentarios
            }
        } catch (IOException e) { // Si hay un error al leer el fichero
            System.out.println("Error al leer el archivo");
        }
    }
}

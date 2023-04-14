package unit10.Actividad14_Aplicacion;

import java.io.*;

/*
    Escribe un programa que lea un fichero de texto llamado carta. txt.
    Tenemos que contar los caracteres, las líneas y las palabras.
    Para simplificar supondremos que cada palabra está separada de otra por un único espacio en blanco o por un cambio de línea.
 */
public class Actividad14 {
    public static void main(String[] args) {
        File file = new File("./src/unit10/Actividad14_Aplicacion/carta.txt");
        if (file.exists()){
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String cad;
                int lineas = 0;
                int palabras = 0;
                int caracteres = 0;
                while ((cad = br.readLine()) != null) {
                    lineas++;
                    palabras += cad.split(" ").length;
                    caracteres += cad.length();
                }
                System.out.println("La carta posee:\n" +
                        lineas+" Lineas.\n" +
                        palabras+" Palabras\n" +
                        caracteres+" Caracteres");

            } catch (IOException e) {
                System.out.println("No se ha podido acceder al fichero");
            }
        } else {
            System.out.println("El fichero \"carta.txt\" no existe. Es necesario para la ejecución del programa");
        }
    }
}


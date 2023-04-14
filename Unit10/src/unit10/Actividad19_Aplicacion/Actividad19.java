package unit10.Actividad19_Aplicacion;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
    Un encriptador es una aplicación que transforma un texto haciéndolo ilegible para aquellos que desconocen el código.
    Diseña un programa que lea un fichero de texto, lo codifique y cree un nuevo archivo con el mensaje cifrado.
    El alfabeto de codificación se encontrará en el fichero codec.txt.
    Un ejemplo de codificación de alfabeto es:
       Alfabeto: abcdefghijklmnopqrstuvwxyz
        Cifrado: emsrcyinfxiwtakozdlqvbhupg
 */
public class Actividad19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean abecedarioCodificadoLeido = false;
        File fileCodec = new File("./src/unit10/Actividad19_Aplicacion/codec.txt");
        ArrayList<Character> abecedario = new ArrayList<Character>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
        ArrayList<Character> abecedarioCodificado = new ArrayList<>();
        if (fileCodec.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileCodec))) {
                String[] allEncode = br.readLine().split("");
                for (int i = 0; i < allEncode.length; i++) {
                    Character character = allEncode[i].charAt(0);
                    abecedarioCodificado.add(character);
                }
                abecedarioCodificadoLeido = true;
            } catch (IOException e) {
                System.out.println("No se ha podido leer el fichero correctamente.");
            }
        } else {
            System.out.println("El fichero de codificación no existe.");
        }

        if (abecedarioCodificadoLeido) {
            System.out.println("Ingrese la ruta absoluta del fichero que deseas codificar: ");
            String userPathFile = sc.next();
            File fileToEncode = new File(userPathFile);
            if (fileToEncode.exists()) {
                String encodedFileName = "encoded_"+fileToEncode.getName();
                File encodedFile = new File(fileToEncode.getParent()+"/"+encodedFileName);
                try (BufferedReader br = new BufferedReader(new FileReader(fileToEncode));
                     PrintWriter pw = new PrintWriter(new FileWriter(encodedFile,true))) {
                    String cad;
                    while ((cad = br.readLine()) != null) {
                        String encodeString = encoder(cad,abecedario,abecedarioCodificado);
                        pw.println(encodeString);
                    }
                    pw.flush();
                } catch (IOException e) {
                    System.out.println("El fichero no existe o la ruta es errónea.");
                }
            } else {
                System.out.println("El fichero no existe o la ruta es errónea.");
            }
        }

    }

    public static String encoder (String originalString, ArrayList<Character> abecedario, ArrayList<Character> abecedarioCodificado) {
        StringBuilder cadenaCodificada = new StringBuilder();
        for (int i = 0; i < originalString.length(); i++) {
            Character character = originalString.charAt(i);
            if (abecedario.contains(character)){
                cadenaCodificada.append(abecedarioCodificado.get(abecedario.indexOf(character)));
            } else {
                cadenaCodificada.append(character);
            }
        }
        return cadenaCodificada.toString();
    }
}

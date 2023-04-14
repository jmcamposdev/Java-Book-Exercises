package unit10.Actividad20_Aplicacion;

import java.io.*;

/*
    Algunos sistemas operativos disponen de la orden comp, que compara dos archivos y nos dice si son iguales o distintos.
    Diseña esta orden de forma que, además, nos diga en qué línea y carácter se encuentra la primera diferencia.
    Utiliza los ficheros texto1.tr y texto2.txt.
 */
public class Actividad20 {
    public static void main(String[] args) {
        File file1 = new File("./src/unit10/Actividad20_Aplicacion/texto1.txt");
        File file2 = new File("./src/unit10/Actividad20_Aplicacion/texto2.txt");

        if (file1.exists() && file2.exists()) {
            try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
                 BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
                boolean differenceFound = false;
                int line = 1;
                char diferentCharacter;
                char firstFileCharacter = (char) br1.read();
                char secondFileCharacter = (char) br2.read();
                while (firstFileCharacter != 65535 && secondFileCharacter != 65535 && !differenceFound) {
                    if (firstFileCharacter == secondFileCharacter) {
                        if (firstFileCharacter == 10) {
                            line++;
                        }
                        firstFileCharacter = (char) br1.read();
                        secondFileCharacter = (char) br2.read();
                    } else {
                        differenceFound = true;
                    }
                }
                if (differenceFound) {
                    System.out.println("En el primer fichero el caracter es: "+firstFileCharacter);
                    System.out.println("En el segundo fichero el caracter es: "+secondFileCharacter);
                    System.out.println("La línea es: "+line);
                } else {
                    System.out.println("Los dos fichero sos exactamente iguales");
                }
            } catch (IOException e) {
                System.out.println("No se ha podido acceder a los ficheros");
            }
        } else {
            System.out.println("Algunos de los dos ficheros a compara no existen");
        }
    }
}

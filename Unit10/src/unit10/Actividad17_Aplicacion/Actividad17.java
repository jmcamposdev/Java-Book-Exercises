package unit10.Actividad17_Aplicacion;

import java.io.*;
import java.util.Scanner;

/*
    En Linux disponemos del comando more, al que se le pasa un fichero y lo muestra poco, a poco: cada 24 líneas.
    Implementa un programa que funcione de forma similar.
 */
public class Actividad17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Este programa mustra la información igual que e comando \"more\" de Linux");
        System.out.println("Muestra el contenido cada 24 líneas y pulsando enter");
        System.out.print("Ingrese la ruta absoluta del fichero: ");
        String fichero = sc.next();
        File file = new File(fichero);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                boolean ficheroFinalizado = false;
                int count = 0;
                String cad;
                while (!ficheroFinalizado) {
                    while ((cad = br.readLine()) != null && count < 24) {
                        System.out.println(cad);
                        count++;
                    }
                    while ((cad = br.readLine()) != null) {
                        String userInput = sc.nextLine();
                        if (userInput.isBlank()) {
                            System.out.println(cad);
                        }
                    }
                    ficheroFinalizado = true;
                }
                System.out.println("END");
            } catch (IOException e) {
                System.out.println("No se ha podido acceder al fichero.");
            }
        } else {
            System.out.println("El fichero proporcionado no existe o la ruta es errónea");
        }
    }
}

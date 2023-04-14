package unit10.Actividad23_Aplicacion;

import java.io.*;
import java.util.Scanner;

/*
    Con el fichero deportistas.txt de la Actividad de aplicación 22, implementa una aplicación que lea los datos
    de los deportistas y los guarde en otros tres ficheros, uno con los nombres y las edades,
    otro con los nombres y los pesos y el tercero con los nombres y las estaturas.
 */
public class Actividad23 {
    public static void main(String[] args) {
        File deportistas = new File("./src/unit10/Actividad23_Aplicacion/deportistas.txt");
        File edadDeportistas = new File("./src/unit10/Actividad23_Aplicacion/edadDeportistas.txt");
        File pesoDeportistas = new File("./src/unit10/Actividad23_Aplicacion/pesoDeportistas.txt");
        File estaturaDeportistas = new File("./src/unit10/Actividad23_Aplicacion/estaturaDeportistas.txt");

        if (deportistas.exists()) {
            try (Scanner sc = new Scanner(deportistas);
                 PrintWriter pwEdad = new PrintWriter(new FileWriter(edadDeportistas, true));
                 PrintWriter pwPeso = new PrintWriter(new FileWriter(pesoDeportistas, true));
                 PrintWriter pwEstatura = new PrintWriter(new FileWriter(estaturaDeportistas, true))) {
                String nombre;
                int edad;
                double peso,estatura;
                sc.nextLine(); // Saltamos la cabecera
                while (sc.hasNext()) {
                    nombre = "";
                    while (!sc.hasNextInt()) {
                        nombre += sc.next()+" ";
                    }
                    edad = sc.nextInt();
                    peso = sc.nextDouble();
                    estatura = sc.nextDouble();

                    pwEdad.println(nombre+" "+edad);
                    pwPeso.println(nombre+" "+peso);
                    pwEstatura.println(nombre+" "+estatura);
                }

            } catch (IOException e) {
                System.out.println("Error al trabajar con el fichero");
            }
        } else {
            System.out.println("El fichero deportistas.txt no existe");
        }
    }
}

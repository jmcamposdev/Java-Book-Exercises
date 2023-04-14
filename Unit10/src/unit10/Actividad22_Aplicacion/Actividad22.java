package unit10.Actividad22_Aplicacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
    Crea con un editor de texto el fichero deportistas.txt, donde se recogen los datos de un grupo de deportistas, uno en cada línea.
    Aparecerá el nombre completo, seguido de la edad, el peso y la estatura.
    La primera línea será el encabezamiento con los nombres de los campos. El documento tendrá la siguiente forma:
    Nombre                      Edad        Peso        Estatura
    Juan Pedro Pérez Gómez      25          70,5        1,80
    Ana Ruiz del Val            23          60          1,75

    Implementa un programa donde se cree un flujo de texto de entrada, a partir del Scanner.
    Usando un objeto scanner, se leerán los datos de los deportistas, que se mostrarán por pantalla.
    Al final aparecerán los valores medios de la edad, el peso y la estatura.
 */
public class Actividad22 {
    public static void main(String[] args) {
        File file = new File("./src/unit10/Actividad22_Aplicacion/deportistas.txt");
        double totalEdad = 0,totalPeso = 0,totalEstatura = 0;
        double mediaEdad,mediaPeso,mediaEstatura;
        int numeroPersonas = 0;
        try (Scanner sc = new Scanner(file)) {
            String nombre;
            int edad;
            double peso,estatura;
            System.out.println(sc.nextLine());// Imprime la cabecera
            while (sc.hasNext()) { // Itera hasta que recorra todo el fichero
                nombre = ""; // Inicializamos el nombre a vacío
                while (!sc.hasNextInt()) { // Almacenamos el nombre hasta que nos encontramos con un INT
                    nombre += sc.next()+" ";
                }
                System.out.printf("%-25s",nombre); // Imprimimos el nombre con formato de 25 caracteres

                totalEdad += edad = sc.nextInt(); // Asignamos la edad y lo sumamos al totalEdad
                totalPeso += peso = sc.nextDouble(); // Asignamos el peso y lo sumamos al totalPeso
                totalEstatura += estatura = sc.nextDouble(); // Asignamos la estatura y lo sumamos al totalEstatura
                System.out.print("\t"+edad); // Imprimimos la Edad
                System.out.print("\t\t\t"+peso); // Imprimimos el Peso
                System.out.print("\t\t"+estatura+"\n"); // Imprimimos la Estatura y un salto de línea para la siguiente persona
                numeroPersonas++; // Aumentamos el número de Personas
            }
            // Realizamos las médias
            mediaEdad = totalEdad / numeroPersonas;
            mediaPeso = totalPeso / numeroPersonas;
            mediaEstatura = totalEstatura / numeroPersonas;
            // Imprimimos las Medias con formato para redondear
            System.out.println("\nMedias:");
            System.out.println("-------------------------------------");
            System.out.printf("La media de Edad es: %.2f\n",mediaEdad);
            System.out.printf("La media de Peso es: %.2f\n", mediaPeso);
            System.out.printf("La media de Estatura es: %.2f\n", mediaEstatura);
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        }
    }
}


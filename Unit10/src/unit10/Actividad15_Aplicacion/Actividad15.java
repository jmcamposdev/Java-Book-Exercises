package unit10.Actividad15_Aplicacion;

import java.io.*;
import java.util.Scanner;

/*
    En el archivo listaNumerosEnteros1.txt disponemos de una serie de números (uno por cada línea).
    Diseña un programa que procese el fichero y nos muestre el menor y el mayor.
 */
public class Actividad15 {
    public static void main(String[] args) {
        File file = new File("./src/unit10/Actividad15_Aplicacion/numeros.txt");
        if (file.exists()) {
            try (Scanner sc = new Scanner(file)) {
                int digito = sc.nextInt();
                int maximo = digito;
                int minimo = digito;
                while (sc.hasNextInt()) {
                    digito = sc.nextInt();
                    if (digito > maximo) {
                        maximo = digito;
                    } else if (digito < minimo) {
                        minimo = digito;
                    }
                }

                System.out.println("El maximo es: "+maximo);
                System.out.println("El mínimo es: "+minimo);

            } catch (IOException e) {
                System.out.println("No se puede acceder al fichero");
            } catch (ArithmeticException e) {
                System.out.println("Se esperaba que solo contenga números");
            }
        } else {
            System.out.println("El fichero "+file.getName()+" no existe y es necesario para el programa");
        }
    }
}

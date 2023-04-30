package unit02.Actividad13;

import java.util.Scanner;

/*
    Escribir un programa que pida una hora de la siguiente forma:
    hora, minutos y segundos. Y que muestre la hora dentro de un segundo.
 */
public class Actividad13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hora, minutos, segundos, segundosTotales;
        boolean horaValida = true;

        // Pedimos la hora
        System.out.print("Introduce la hora: ");
        hora = sc.nextInt();

        System.out.print("Introduce los minutos: ");
        minutos = sc.nextInt();

        System.out.print("Introduce los segundos: ");
        segundos = sc.nextInt();

        // Comprobamos si la hora es válida
        if ((hora < 0 || hora > 23) || (minutos < 0 || minutos > 59) || (segundos < 0 || segundos > 59)) {
            horaValida = false;
            System.out.println("La hora introducida no es válida.");
        }

        if (horaValida) {
            segundosTotales = (hora * 3600) + (minutos * 60) + segundos; // Pasamos la hora a segundos
            segundosTotales++; // Añadimos un segundo

            // Pasamos los segundos a hora
            hora = segundosTotales / 3600;
            minutos = (segundosTotales % 3600) / 60;
            segundos = (segundosTotales % 3600) % 60;

            System.out.println("La hora dentro de un segundo es: " + hora + ":" + minutos + ":" + segundos);
        }
    }
}

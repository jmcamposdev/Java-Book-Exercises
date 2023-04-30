package unit1.Actividad20_Aplicacion;

import java.util.Scanner;

/*
    Diseña una aplicación que solicite al usuario que introduzca una cantidad de segundos
    La aplicación debe mostrar cuántas horas, minutos y segundos son.
 */
public class Actividad20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int horas;
        int minutos;
        int segundos;

        // Pedimos los Segundos
        System.out.print("Ingrese los segundos: ");
        segundos = sc.nextInt();

        horas = segundos / 3600; // Calculamos las horas
        segundos -= horas * 3600; // Restamos las horas a los segundos

        minutos = segundos / 60; // Calculamos los minutos
        segundos -= minutos * 60; // Restamos los minutos a los segundos

        System.out.println("Son: " + horas + ":" + minutos + ":" + segundos);
    }
}

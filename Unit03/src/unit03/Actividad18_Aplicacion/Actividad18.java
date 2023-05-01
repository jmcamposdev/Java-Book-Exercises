package unit03.Actividad18_Aplicacion;

import java.util.Scanner;

/*
    Escribe un programa que incremente la hora de un reloj. Se pedirán por teclado la hora, minutos y segundos, así
    com cuántos segundos desea incrementar la hora introducida. La aplicación mostrará la nueva hora.
 */
public class Actividad18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hora, minutos, segundos, segundosIncremento, segundosTotales;

        // Pedir hora
        do {
            System.out.print("Introduce la hora: ");
            hora = sc.nextInt();
            if (hora < 0 || hora > 23) {
                System.out.println("La hora debe estar entre 0 y 23");
            }
        } while (hora < 0 || hora > 23);

        // Pedir minutos
        do {
            System.out.print("Introduce los minutos: ");
            minutos = sc.nextInt();
            if (minutos < 0 || minutos > 59) {
                System.out.println("Los minutos deben estar entre 0 y 59");
            }
        } while (minutos < 0 || minutos > 59);

        // Pedir segundos
        do {
            System.out.print("Introduce los segundos: ");
            segundos = sc.nextInt();
            if (segundos < 0 || segundos > 59) {
                System.out.println("Los segundos deben estar entre 0 y 59");
            }
        } while (segundos < 0 || segundos > 59);

        // Pedir segundos de incremento
        do {
            System.out.print("Introduce los segundos de incremento: ");
            segundosIncremento = sc.nextInt();
            if (segundosIncremento < 0) {
                System.out.println("Los segundos de incremento deben ser mayor o igual a 0");
            }
        } while (segundosIncremento < 0);

        // Incrementar segundos
        segundosTotales = hora * 3600 + minutos * 60 + segundos + segundosIncremento;
        hora = segundosTotales / 3600; // Pasamos a horas
        minutos = (segundosTotales % 3600) / 60; // Pasamos a minutos
        segundos = (segundosTotales % 3600) % 60; // Pasamos a segundos

        // Mostrar resultado
        System.out.println("La hora es " + hora + ":" + minutos + ":" + segundos);

    }
}

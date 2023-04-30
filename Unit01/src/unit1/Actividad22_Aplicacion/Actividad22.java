package unit1.Actividad22_Aplicacion;

import java.util.Scanner;

/*
    Un biólogo está realizando un estudio de distintas especies de invertebrados y necesita una aplicación que le ayude
    a contabilizar el número de patas que tienen en total todos los animales capturados durante una jornada de trabajo.
    Para ello, te ha solicitado que escribas una aplicación a la que hay que proporcionar:
        • El número de hormigas capturadas (6 patas).
        • El número de arañas capturadas (8 patas).
        • El número de cochinillas capturadas (14 patas).
    La aplicación debe mostrar el número total de patas.
 */
public class Actividad22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hormigas;
        int arañas;
        int cochinillas;
        int totalPatas;

        // Pedimos el número de hormigas
        System.out.print("Introduce el número de hormigas: ");
        hormigas = sc.nextInt();
        // Pedimos el número de arañas
        System.out.print("Introduce el número de arañas: ");
        arañas = sc.nextInt();
        // Pedimos el número de cochinillas
        System.out.print("Introduce el número de cochinillas: ");
        cochinillas = sc.nextInt();

        // Calculamos el total de patas
        totalPatas = hormigas * 6 + arañas * 8 + cochinillas * 14;

        // Mostramos el total de patas
        System.out.println("El total de patas es: " + totalPatas);
    }
}

package unit02.Actividad23_Aplicacion;

import java.util.Scanner;

/*
    Crea una aplicación que solicite al usuario cuántos grados tiene un ángulo y muestre por pantalla
    el equivalente en radianes. Si el ángulo introducido por el usuario no se encuentra en el rango
    de 0 a 360, hay que transformarlo a dicho rango.
    Nota: El operador módulo puede ayudarnos a convertir un angulo a su equivalente en el rango de 0 a 360.
 */
public class Actividad23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int grados;
        double radianes;

        // Pedimos los grados
        System.out.print("Introduce los grados: ");
        grados = sc.nextInt();

        // Convertimos los grados
        if (grados < 0) {
            grados = 360 + grados;
        } else if (grados > 360) {
            grados = grados % 360;
        }

        // Convertimos a radianes
        radianes = grados * Math.PI / 180;

        System.out.printf("%d grados son %.2f radianes", grados, radianes);
    }
}

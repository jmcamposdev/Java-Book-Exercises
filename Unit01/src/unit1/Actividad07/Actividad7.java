package unit1.Actividad07;

import java.util.Scanner;

/*
    Diseñar una aplicación que calcula la longitud y el área de una circunferencia.
    Para ello el usuario debe de introducir el radio de la circunferencia.
    Recordamos:
        Longitud = 2 * PI * radio
        Área = PI * radio * radio
 */
public class Actividad7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el radio: ");
        double radio = sc.nextDouble();
        double longitud;
        double area;

        longitud = 2 * Math.PI * radio;
        area = Math.PI * radio * radio;

        System.out.println("Longitud: " + longitud);
        System.out.println("Área: " + area);
    }
}

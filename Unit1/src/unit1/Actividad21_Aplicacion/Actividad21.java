package unit1.Actividad21_Aplicacion;

import java.util.Scanner;

/*
    Solicita al usuario tres distancias:
    - La primera en millimetres
    - La segunda en centimetres
    - La tercera en metros

    Diseña un programa que muestre la suma de las tres distancias en centímetros.
 */
public class Actividad21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int milimetros;
        int centimetros;
        int metros;

        // Pedimos las distancias
        System.out.print("Introduce la distancia en millimetres: ");
        milimetros = sc.nextInt();
        System.out.print("Introduce la distancia en centimetres: ");
        centimetros = sc.nextInt();
        System.out.print("Introduce la distancia en metros: ");
        metros = sc.nextInt();

        // Calculamos la suma de las distancias en centímetros
        centimetros += milimetros / 10;
        centimetros += metros * 100;

        System.out.print("La suma de las distancias en centímetros es: " + centimetros + "cm");
    }
}

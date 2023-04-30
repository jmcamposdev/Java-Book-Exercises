package unit1.Actividad18_Aplicacion;

import java.util.Scanner;

/*
    Crea un programa que pida la base y la altura de un triángulo y muestra por pantalla su área.
    Area = (base * altura) / 2
 */
public class Actividad18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base;
        double altura;
        double area;

        // pedir la base
        System.out.print("Introduce la base: ");
        base = sc.nextDouble();

        // pedir la altura
        System.out.print("Introduce la altura: ");
        altura = sc.nextDouble();

        // Calcular el área
        area = (base * altura) / 2;

        // Mostrar el resultado
        System.out.println("El área del triángulo es " + area);
    }
}

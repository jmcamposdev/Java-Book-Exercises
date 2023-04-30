package unit1.Actividad19_Aplicacion;

import java.util.Scanner;

/*
    Dado el siguiente polinomio de segundo grado:
        y = ax^2 + bx + c
    Crea un programa que pida los coeficientes a, b y c, así como el valor de x y muestre por
    pantalla el resultado de evaluar el polinomio.
 */
public class Actividad19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a;
        double b;
        double c;
        double x;
        double y;

        // Pedir los coeficientes
        System.out.print("Introduce el coeficiente a: ");
        a = sc.nextDouble();
        System.out.print("Introduce el coeficiente b: ");
        b = sc.nextDouble();
        System.out.print("Introduce el coeficiente c: ");
        c = sc.nextDouble();
        System.out.print("Introduce el valor de x: ");
        x = sc.nextDouble();

        // Calcular el resultado
        y = a * Math.pow(x, 2) + b * x + c;

        // Mostrar el resultado
        System.out.println("El resultado de evaluar el polinomio es " + y);
    }
}

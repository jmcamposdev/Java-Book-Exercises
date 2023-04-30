package unit02.Actividad08;

import java.util.Scanner;

/*
    Pedir los coeficientes de una ecuación de segundo grado y mostrar sus soluciones
    reales. Si no existen habrá que indicarlo.
 */
public class Actividad8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c, x1, x2, discriminante;

        // Pedimos los coeficientes
        System.out.print("Introduce el coeficiente a: ");
        a = sc.nextDouble();

        System.out.print("Introduce el coeficiente b: ");
        b = sc.nextDouble();

        System.out.print("Introduce el coeficiente c: ");
        c = sc.nextDouble();

        // Calculamos el discriminante
        discriminante = Math.pow(b, 2) - (4 * a * c);
        if (discriminante < 0) {
            System.out.println("No existen soluciones reales.");
        } else {
            if (a == 0) {
                System.out.println("No es una ecuación de segundo grado.");
            } else {
                x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                System.out.println("Las soluciones son: " + x1 + " y " + x2);
            }
        }
    }
}

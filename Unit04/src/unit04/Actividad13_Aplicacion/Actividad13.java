package unit04.Actividad13_Aplicacion;

import java.util.Scanner;


/*
    Diseña una función que calcule y muestre la superficie y el volumen de una esfera.
            Superficie = 4 * PI * radio^2
            Volumen = 4/3 * PI * radio^3
 */
public class Actividad13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radio;

        // Pedimos el radio de la esfera
        do {
            System.out.print("Introduce el radio de la esfera: ");
            radio = sc.nextDouble();
            if (radio <= 0) {
                System.out.println("El radio debe ser mayor que 0");
            }
        } while (radio <= 0);

        // Mostramos la superficie y el volumen de la esfera
        System.out.printf("La superficie de la esfera es: %.2f\n", superficie(radio));
        System.out.printf("El volumen de la esfera es: %.2f\n", volumen(radio));

    }

    private static double superficie(double radio) {
        return 4 * Math.PI * Math.pow(radio, 2);
    }
    private static double volumen(double radio) {
        return 4.0 / 3.0 * Math.PI * Math.pow(radio, 3);
    }
}

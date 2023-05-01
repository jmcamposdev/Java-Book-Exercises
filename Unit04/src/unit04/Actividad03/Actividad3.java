package unit04.Actividad03;

import java.util.Scanner;

/*
    Realizar una función que calcule y muestre el área o el volumen de un cilindro, según se
    especifique. Para distinguir un caso de otro se le pasará como opción 1 (área) y 2 (volumen).
    Además, hay que pasarle a la función el radio de la base y la altura
        área = 2 * pi * radio * (radio + altura)
        volumen = pi * radio * radio * altura
 */
public class Actividad3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radio, altura;
        int opcion;

        // Pedimos los datos
        do { // Pedimos el radio de la base y comprobamos que sea mayor que 0
            System.out.print("Introduce el radio de la base: ");
            radio = sc.nextDouble();
            if (radio <= 0) {
                System.out.println("El radio debe ser mayor que 0");
            }
        } while (radio <= 0);

       do { // Pedimos la altura y comprobamos que sea mayor que 0
            System.out.print("Introduce la altura: ");
            altura = sc.nextDouble();
            if (altura <= 0) {
                System.out.println("La altura debe ser mayor que 0");
            }
        } while (altura <= 0);

       do { // Pedimos la opción y comprobamos que sea 1 o 2
            System.out.print("Introduce la opción (1: área, 2: volumen): ");
            opcion = sc.nextInt();
            if (opcion != 1 && opcion != 2) {
                System.out.println("Opción incorrecta");
            }
        } while (opcion != 1 && opcion != 2);

        // Mostramos el resultado
        if (opcion == 1) {
            System.out.printf("El área es: %.2f\n", area(radio, altura));
        } else {
            System.out.printf("El volumen es: %.2f\n", volumen(radio, altura));
        }

    }

    private static double area(double radio, double altura) {
        return 2 * Math.PI * radio * (radio + altura);
    }

    private static double volumen(double radio, double altura) {
        return Math.PI * radio * radio * altura;
    }
}

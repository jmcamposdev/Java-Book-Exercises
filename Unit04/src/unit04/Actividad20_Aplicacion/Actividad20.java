package unit04.Actividad20_Aplicacion;

import java.util.Scanner;

/*
    Crea una función que muestre por consola una serie de números aleatorios enteros.
    Los parámetros de la función serán: cantidad de números aleatorios y los valores
    mínimo y máximo que pueden tomar dichos números.
 */
public class Actividad20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidad, min, max;

        // Pedimos los datos
        System.out.print("Introduce la cantidad de números aleatorios: ");
        cantidad = sc.nextInt();

        System.out.print("Introduce el valor mínimo: ");
        min = sc.nextInt();

        System.out.print("Introduce el valor máximo: ");
        max = sc.nextInt();

        // Mostramos los números aleatorios
        muestraAleatorios(cantidad, min, max);
    }

    private static void muestraAleatorios(int cantidad, int min, int max) {
        for (int i = 0; i < cantidad; i++) {
            System.out.println((int) (Math.random() * (max - min + 1) + min));
        }
    }
}

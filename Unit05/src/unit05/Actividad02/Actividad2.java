package unit05.Actividad02;

import java.util.Arrays;
import java.util.Scanner;

/*
    Pedir al usuario 5 números y mostrárselos en el mismo orden
 */
public class Actividad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese un numero decimal: ");
            array[i] = sc.nextInt();
        }
        System.out.println("El listado es: "+ Arrays.toString(array));

    }
}

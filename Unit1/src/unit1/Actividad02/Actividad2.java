package unit1.Actividad02;

import java.util.Scanner;

/*
    Diseñar un programa que pida un número al usuario (por teclado) y a continuación
    lo muestre por pantalla.
 */
public class Actividad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Introduce un número: ");
        num = sc.nextInt();
        System.out.println("El número introducido es: " + num);

    }
}

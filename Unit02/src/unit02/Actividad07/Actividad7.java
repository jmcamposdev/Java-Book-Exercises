package unit02.Actividad07;

import java.util.Scanner;

/*
    Pedir tres números y mostrarlos ordenados de mayor a menor.
 */
public class Actividad7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2, num3;

        // Pedimos los números
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();

        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();

        System.out.print("Introduce el tercer número: ");
        num3 = sc.nextInt();

        // Comprobamos cuál es mayor
        if (num1 > num2 && num2 > num3) {
            System.out.println("El número mayor es " + num1 + ", el intermedio es " + num2 + " y el menor es " + num3);
        } else if (num1 > num3 && num3 > num2) {
            System.out.println("El número mayor es " + num1 + ", el intermedio es " + num3 + " y el menor es " + num2);
        } else if (num2 > num1 && num1 > num3) {
            System.out.println("El número mayor es " + num2 + ", el intermedio es " + num1 + " y el menor es " + num3);
        } else if (num2 > num3 && num3 > num1) {
            System.out.println("El número mayor es " + num2 + ", el intermedio es " + num3 + " y el menor es " + num1);
        } else if (num3 > num1 && num1 > num2) {
            System.out.println("El número mayor es " + num3 + ", el intermedio es " + num1 + " y el menor es " + num2);
        } else if (num3 > num2 && num2 > num1) {
            System.out.println("El número mayor es " + num3 + ", el intermedio es " + num2 + " y el menor es " + num1);
        }
    }
}

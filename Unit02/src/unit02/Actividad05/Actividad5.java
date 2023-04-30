package unit02.Actividad05;

import java.util.Scanner;

/*
    Pedir dos números y mostrarlos ordenados de mayor a menor.
 */
public class Actividad5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        int mayor, menor;

        // Pedimos los números
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();

        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();

        // Comprobamos cuál es mayor
        // También se puede realizar con Math.max(num1, num2) y Math.min(num1, num2)
        // Pero el objetivo de esta actividad es practicar con el operador ternario
        mayor = num1 > num2 ? num1 : num2;
        menor = num1 < num2 ? num1 : num2;

        System.out.println("El número mayor es " + mayor + " y el menor es " + menor);
    }
}

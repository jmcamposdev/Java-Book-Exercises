package unit02.Actividad21_Aplicacion;

import java.util.Scanner;

/*
    Realiza el juego de la suma. Que consiste en que aprezcan dos números aleatorios entre 1 y 99
    que el usuario tiene que sumar. La aplicación debe indicarle al resultado de la suma es correcto o no.

 */
public class Actividad21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero1, numero2, suma, resultado;

        // Generamos los números aleatorios
        numero1 = (int) (Math.random() * 99 + 1);
        numero2 = (int) (Math.random() * 99 + 1);

        // Mostramos la pregunta
        System.out.println("¿Cuánto es " + numero1 + " + " + numero2 + "?");
        resultado = sc.nextInt();

        // Calculamos la suma
        suma = numero1 + numero2;

        // Comprobamos si el resultado es correcto
        if (resultado == suma) {
            System.out.println("¡Correcto!");
        } else {
            System.out.println("¡Incorrecto!");
        }

    }
}

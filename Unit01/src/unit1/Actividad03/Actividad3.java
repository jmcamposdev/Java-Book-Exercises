package unit1.Actividad03;

import java.util.Scanner;

/*
    Pedir al usuario su edad y mostrar la que tendrá el próximo año.
 */
public class Actividad3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        System.out.print("Introduce tu edad: ");
        edad = sc.nextInt();
        System.out.println("El año que viene tendrás " + (edad + 1) + " años.");
    }
}

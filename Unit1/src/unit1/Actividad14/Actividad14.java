package unit1.Actividad14;

import java.util.Scanner;

/*
    Realizar un programa que pida como entero un número decimal y lo muestre redondeado
    al entero más próximo.
 */
public class Actividad14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num;
        System.out.print("Introduce un número decimal: ");
        num = sc.nextDouble();

        // Redondear un número decimal al entero más próximo
        int numRedondeado = (int) (num + 0.5);
        System.out.println(numRedondeado);
    }
}

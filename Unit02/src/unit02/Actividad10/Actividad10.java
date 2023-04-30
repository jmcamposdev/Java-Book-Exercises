package unit02.Actividad10;

import java.util.Scanner;

/*
    Pedir runa nota entera de 0 a 10 y mostrarla de la siguiente forma:
    Insuficiente: 0-4
    Suficiente: 5
    Bien: 6
    Notable: 7-8
    Sobresaliente: 9-10

 */
public class Actividad10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nota;

        // Pedimos la nota
        System.out.print("Introduce la nota (0 - 10): ");
        nota = sc.nextInt();

        if (nota < 0 || nota > 10) {
            System.out.println("La nota introducida no es válida.");
        } else if (nota < 5) {
            System.out.println("Insuficiente");
        } else if (nota == 5) {
            System.out.println("Suficiente");
        } else if (nota == 6) {
            System.out.println("Bien");
        } else if (nota < 9) {
            System.out.println("Notable");
        } else {
            System.out.println("Sobresaliente");
        }
    }
}

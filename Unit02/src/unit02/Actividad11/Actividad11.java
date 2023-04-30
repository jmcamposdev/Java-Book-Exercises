package unit02.Actividad11;

import java.util.Scanner;

/*
    Idear un programa que solicite al usuario un número comprendido entre 1 - 7. Corresponente a un
    día de la semana. El programa debe devolver el nombre del día de la semana que corresponda.
 */
public class Actividad11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia;

        // Pedimos el día
        System.out.print("Introduce un número del 1 al 7: ");
        dia = sc.nextInt();

        // Comprobamos el día
        switch (dia) {
            case 1 -> System.out.println("Lunes");
            case 2 -> System.out.println("Martes");
            case 3 -> System.out.println("Miércoles");
            case 4 -> System.out.println("Jueves");
            case 5 -> System.out.println("Viernes");
            case 6 -> System.out.println("Sábado");
            case 7 -> System.out.println("Domingo");
            default -> System.out.println("El número introducido no es válido.");
        }
    }
}

package unit04.Actividad01;

import java.util.Scanner;

/*
    Escribe una función eco() a la que se le pasa como parámetro un número n y muestra por pantalla n veces el mensaje "Eco..."
 */
public class Actividad1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos el número de veces que se mostrará el mensaje
        System.out.print("Introduce el número de veces que se mostrará el mensaje: ");
        int n = sc.nextInt();

        // Mostramos el mensaje n veces
        eco(n);
    }

    private static void eco(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Eco...");
        }
    }
}

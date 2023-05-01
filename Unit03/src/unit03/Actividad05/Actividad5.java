package unit03.Actividad05;

import java.util.Scanner;

/*
    Desarrollar un juego que ayude a mejorar el cálculo mental de la suma. El jugador tendrá
    que introducir la solución de la suma de dos números aleatorios comprendidos entre 1 y 100.
    Mientras la solución introducida sea correcta el juego continuará. En caso contrario,
    el programa terminará mostrando el número de operaciones realizadas.
 */
public class Actividad5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroAleatorio1, numeroAleatorio2, solucion, solucionUsuario, numOperaciones = 0;

        // Generamos los números aleatorios
        do {
            numeroAleatorio1 = (int) (Math.random() * 100 + 1);
            numeroAleatorio2 = (int) (Math.random() * 100 + 1);
            System.out.println("La suma de " + numeroAleatorio1 + " y " + numeroAleatorio2 + " es: ");
            solucionUsuario = sc.nextInt();
            solucion = numeroAleatorio1 + numeroAleatorio2;
            numOperaciones++;
        } while (solucionUsuario == solucion);

        System.out.println("Has fallado, el resultado era " + solucion + " y has realizado " + (numOperaciones - 1) + " operaciones.");
    }
}

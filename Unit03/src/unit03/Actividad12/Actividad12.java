package unit03.Actividad12;

import java.util.Scanner;

/*
    Pedir 5 calificaciones de alumnos y  pedir al final si hay algún suspenso.
 */
public class Actividad12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int calificacion;
        boolean suspensos = false;

        // Pedir calificaciones
        for (int i = 0; i < 5; i++) {
            do { // Comprobar que la calificación esté entre 0 y 10
                System.out.print("Introduce la calificación del alumno " + (i + 1) + ": ");
                calificacion = sc.nextInt();
                if (calificacion < 0 || calificacion > 10) {
                    System.out.println("La calificación debe estar entre 0 y 10");
                }
            } while (calificacion < 0 || calificacion > 10);

            // Comprobar si hay algún suspenso
            if (calificacion < 5) {
                suspensos = true;
            }
        }

        // Mostrar resultado
        if (suspensos) {
            System.out.println("Hay algún suspenso");
        } else {
            System.out.println("No hay ningún suspenso");
        }
    }
}

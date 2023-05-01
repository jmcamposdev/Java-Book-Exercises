package unit03.Actividad13;

import java.util.Scanner;

/*
    Dadas 6 notas, escribir la cantidad de alumnos aprobado, condicionados (=4) y suspensos.
 */
public class Actividad13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int calificacion, aprobados = 0, condicionados = 0, suspensos = 0;

        // Pedir calificaciones
        for (int i = 0; i < 6; i++) {
            do { // Comprobar que la calificación esté entre 0 y 10
                System.out.print("Introduce la calificación del alumno " + (i + 1) + ": ");
                calificacion = sc.nextInt();
                if (calificacion < 0 || calificacion > 10) {
                    System.out.println("La calificación debe estar entre 0 y 10");
                }
            } while (calificacion < 0 || calificacion > 10);

            // Comprobar si hay algún suspenso
            if (calificacion < 4) {
                suspensos++;
            } else if (calificacion == 4) {
                condicionados++;
            } else {
                aprobados++;
            }
        }

        // Mostrar resultado
        System.out.println("Hay " + aprobados + " aprobados, " + condicionados + " condicionados y " + suspensos + " suspensos");
    }
}

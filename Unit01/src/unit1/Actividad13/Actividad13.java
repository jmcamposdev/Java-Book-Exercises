package unit1.Actividad13;

import java.util.Scanner;

/*
    Escribir un programa que solicite al usuario las notas del primer, segundo y terver trimestre
    (notas enteras). El programa debe mostrar la nota media del curso como se utiliza en el
    boletín de califiaciones (solo la parte entera) y como se usa en el expediente académico
    con decimales.
 */
public class Actividad13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nota1, nota2, nota3;
        int mediaEntera;
        double mediaDecimal;

        // Pedir las notas
        System.out.print("Introduce la nota del primer trimestre: ");
        nota1 = sc.nextInt();
        System.out.print("Introduce la nota del segundo trimestre: ");
        nota2 = sc.nextInt();
        System.out.print("Introduce la nota del tercer trimestre: ");
        nota3 = sc.nextInt();

        // Calcular la media
        mediaDecimal = (nota1 + nota2 + nota3) / 3.0;
        mediaEntera = (int) mediaDecimal;

        // Mostrar el resultado
        System.out.println("Boletín de calificaciones:  " + mediaEntera);
        System.out.println("Expediente académico: " + mediaDecimal);
    }
}

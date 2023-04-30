package unit1.Actividad06;

import java.util.Scanner;

/*
    Crear una aplicación que calcula la media aritmética de dos notas enteras. Hay que
    tener en cuenta que la media puede contener decimales.
 */
public class Actividad6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nota1, nota2;
        double media;

        System.out.print("Introduce la primera nota: ");
        nota1 = sc.nextInt();
        System.out.print("Introduce la segunda nota: ");
        nota2 = sc.nextInt();

        // Se usa el 2.0 para que el resultado sea un double, ya que si no se usa el 2.0 el resultado sería un int
        media = (nota1 + nota2) / 2.0;

        System.out.println("La media de las notas es: " + media);
    }
}

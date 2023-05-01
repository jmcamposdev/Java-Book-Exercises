package unit03.Actividad04;

import java.util.Scanner;

/*
    Un centro de investigación de la flora urbana necesita una aplicación que  muestre cuál es el árbol más alto.
    Para ello se introducirán por teclado la altura (en centímetros) de cada árbol (Terminando la introducción con -1)
    Los árboles se identifican mediante etiquetas con número único correlativo comenzando por 0. Diseñar una
    aplicación que resuelva el problema.
 */
public class Actividad4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int altura, arbolMasAlto = 0, numArbol = 0, numArbolMasAlto = 0;

        // Pedimos la altura
        System.out.print("Introduce la altura del árbol: ");
        altura = sc.nextInt();

        // Mientras la altura sea mayor que 0
        while (altura >= 0) {
            // Si la altura es mayor que la del árbol más alto
            if (altura > arbolMasAlto) {
                // Guardamos la altura del árbol más alto
                arbolMasAlto = altura;

                // Guardamos el número del árbol más alto
                numArbolMasAlto = numArbol;
            }
            numArbol++;

            // Pedimos la altura
            System.out.print("Introduce la altura del árbol: ");
            altura = sc.nextInt();
        }

        System.out.println("El árbol más alto es el número " + numArbolMasAlto + " y mide " + arbolMasAlto + " cm.");
    }
}

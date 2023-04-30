package unit1.Actividad24_Aplicacion;

import java.util.Scanner;

/*
    Solicita al usuario un número real y calcula su raíz cuadrada.
    Implementa el programa utilizando el nombre cualificado de las clases, en lugar de utilizar ninguna importación.
 */
public class Actividad24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double numero;
        double raiz;

        // Pedimos el número
        System.out.print("Introduce un número: ");
        numero = sc.nextDouble();

        // Calculamos la raíz cuadrada
        raiz = java.lang.Math.sqrt(numero);

        // Mostramos el resultado
        System.out.println("La raíz cuadrada de " + numero + " es " + raiz);

    }
}

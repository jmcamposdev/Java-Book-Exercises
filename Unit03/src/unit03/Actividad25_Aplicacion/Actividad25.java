package unit03.Actividad25_Aplicacion;

import java.util.Scanner;

/*
    Escribe un programa que solicite al usuario las distintas cantidades de dinero de las que dispone.
    Por ejemplo: La cantidad de dinero que tiene en el banco, hucha, cartera, etc. El programa debe
    mostrar por pantalla la cantidad total de dinero que tiene el usuario.

    La manera que especificar que no se desea introducir más cantidades de dinero es introduciendo 0
 */
public class Actividad25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dinero, total = 0;

        // Pedimos el dinero
        System.out.print("Introduce la cantidad de dinero: ");
        dinero = sc.nextInt();

        // Calculamos el total
        while (dinero != 0) {
            total += dinero;

            System.out.print("Introduce la cantidad de dinero: ");
            dinero = sc.nextInt();
        }

        // Mostramos el resultado
        System.out.println("El total de dinero es " + total + "€");


    }
}

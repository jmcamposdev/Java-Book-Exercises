package unit1.Actividad25_Aplicacion;

import java.util.Scanner;

/*
    Pide dos números al usuario: a y b. Deberá mostrarse true si ambos números son iguales y false en caso contrario.
 */
public class Actividad25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        boolean sonIguales;

        // Pedimos los números
        System.out.print("Introduce el primer número: ");
        a = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        b = sc.nextInt();

        // Comprobamos si son iguales
        sonIguales = a == b;

        // Mostramos el resultado
        System.out.println("¿Son iguales? " + sonIguales);
    }
}

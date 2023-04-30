package unit02.Actividad20_Aplicacion;

import java.util.Scanner;

/*
    Utiliza el operador ternario para calcular el valor absoluto de un número. Que se solicitará al usuario.
 */
public class Actividad20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero, valorAbsoluto;

        // Pedimos el número
        System.out.print("Introduce un número: ");
        numero = sc.nextInt();

        valorAbsoluto = numero < 0 ? numero * -1 : numero;

        System.out.println("El valor absoluto de " + numero + " es " + valorAbsoluto);
    }
}

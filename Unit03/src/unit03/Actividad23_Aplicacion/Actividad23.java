package unit03.Actividad23_Aplicacion;

import java.util.Scanner;

public class Actividad23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, mcd = 0, mcm;
        boolean mcdEncontrado = false;

        // Pedimos los dos números
        System.out.print("Introduce el primer número: ");
        a = sc.nextInt();

        System.out.print("Introduce el segundo número: ");
        b = sc.nextInt();

        // Buscamos el MCD
        for (int i = Math.min(a, b); i > 0 && !mcdEncontrado; i--) {
            if (a % i == 0 && b % i == 0) {
                mcd = i;
                mcdEncontrado = true;
            }
        }

        mcm = (a * b) / mcd;

        System.out.println("El MCM de " + a + " y " + b + " es " + mcm);
    }
}

package unit1.Actividad17_Aplicacion;

import java.util.Scanner;

/*
    Modifica la Activida 16 para que , indecando dos números n y m, diga que cantidad hay que sumarle a n
    para que el resultado sea múltiplo de m.
 */
public class Actividad17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int m;

        // Pedir el número
        System.out.print("Introduce el número: ");
        n = sc.nextInt();
        System.out.print("Introduce el múltiplo deseado: ");
        m = sc.nextInt();

        int suma = m - (n % m);
        System.out.println("Hay que sumarle " + suma + " para que el resultado sea múltiplo de " + m);
    }
}

package unit03.Actividad17_Aplicacion;

import java.util.Scanner;

/*
    Modifica la Actividad 16 para que el usuario pueda introducir un número binario y se muestre su
    representación decimal.
 */
public class Actividad17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decimal = 0;
        int binario, i = 1;

        // Pedir número
        System.out.print("Introduce un número binario: ");
        binario = sc.nextInt();


        // Convertir a decimal
        while (binario > 0) {
            decimal += (binario % 10) * i;
            binario /= 10;
            i *= 2;
        }

        System.out.println("El número decimal es: " + decimal);
    }
}

package unit03.Actividad16_Aplicacion;

import java.util.Scanner;

/*
    Realiza un programa que convierta un número decimal en su representación binaria. Hay que tener
    en cuenta que desconocemos cuántas cifras tiene el número que introduce el usuario.

    Para simplificar, iremos mostrando el número binario con un dígito por línea

 */
public class Actividad16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decimal;
        int binario = 0, i = 1;

        // Pedir número
        System.out.print("Introduce un número decimal: ");
        decimal = sc.nextInt();

        // Convertir a binario
        while (decimal > 0) {
            binario += (decimal % 2) * i;
            decimal /= 2;
            i *= 10;
        }

        System.out.println(binario);
    }
}

package unit1.Actividad16_Aplicacion;

import java.util.Scanner;

/*
    Escribe un programa que tome como entrada un número entero e indique qué cantidad
    hay que sumarle para que el resultado sea múltiplo de 7.
 */
public class Actividad16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero:");
        int num = sc.nextInt();
        int multiplo = 7;
        int suma = multiplo - (num % multiplo);
        System.out.println("Hay que sumarle " + suma + " para que el resultado sea múltiplo de " + multiplo);
    }
}

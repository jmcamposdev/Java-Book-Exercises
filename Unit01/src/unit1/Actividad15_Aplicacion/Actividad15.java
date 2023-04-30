package unit1.Actividad15_Aplicacion;

import java.util.Scanner;

/*
    In economista te ha encargado un programa para realizar cálculo con el IVA.
    La aplicación debe solicitar la bese imponible y el tipo de IVA que debe de aplicar.
    Muestra por pantalla el importe correspondiente al IVA y el total de la factura.
 */
public class Actividad15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double baseImponible;
        double tipoIVA;
        double importeIVA;
        double totalFactura;

        // Solicitar la base imponible
        System.out.print("Introduce la base imponible: ");
        baseImponible = sc.nextDouble();
        // Solicitar el tipo de IVA
        System.out.print("Introduce el tipo de IVA: ");
        tipoIVA = sc.nextDouble();

        // Calcular el importe del IVA
        importeIVA = baseImponible * tipoIVA / 100;
        // Calcular el total de la factura
        totalFactura = baseImponible + importeIVA;

        System.out.println("Importe IVA: " + importeIVA);
        System.out.println("Total factura: " + totalFactura);
    }
}

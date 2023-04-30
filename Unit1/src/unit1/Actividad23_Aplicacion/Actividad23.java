package unit1.Actividad23_Aplicacion;

import java.util.Scanner;

/*
    Una empresa que gestiona un parque acuático te solicita una aplicación que les ayude a
    calcular el importe que hay que cobrar en la taquilla por la compra de una serie de entradas
    (cuyo número será introducido por el usuario).
    Existen dos tipos de entrada: infantiles, que cuestan 15,50 €; y de adultos, que cuestan 20 €.
    En el caso de que el importe total sea igual o superior a 100 €, se aplicará automáticamente un bono descuento del 5 %.
 */
public class Actividad23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entradasInfantiles;
        int entradasAdultos;
        double importeTotal;

        // Pedimos el número de entradas infantiles
        System.out.print("Introduce el número de entradas infantiles: ");
        entradasInfantiles = sc.nextInt();
        // Pedimos el número de entradas de adultos
        System.out.print("Introduce el número de entradas de adultos: ");
        entradasAdultos = sc.nextInt();

        // Calculamos el importe total
        importeTotal = entradasInfantiles * 15.5 + entradasAdultos * 20;
        importeTotal = importeTotal >= 100 ? importeTotal * 0.95 : importeTotal;

        // Mostramos el importe total
        System.out.println("El importe total es: " + importeTotal);
    }
}

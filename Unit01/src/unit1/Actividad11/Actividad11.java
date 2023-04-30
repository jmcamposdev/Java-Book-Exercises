package unit1.Actividad11;

import java.util.Scanner;

/*
    Un frutero necesita calcular los beneficios anuales que obtiene de la venta de manzanas y peras.
    Por este motivo, es necesario diseñar una aplicación que solicite las ventas (en kilos) de cada semestre para cada fruta.
    La aplicación mostrará el importe total sabiendo que el precio del kilo de manzanas está fijado en 2,35 € y el kilo de peras en 1,95 €
 */
public class Actividad11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int manzanasSemestre1, manzanasSemestre2;
        int perasSemestre1, perasSemestre2;
        double beneficiosManzanas, beneficiosPeras;
        double beneficiosTotales;

        // Pedimos los datos
        System.out.println("Para las Manzanas:");
        System.out.print("Introduce las ventas del primer semestre: ");
        manzanasSemestre1 = sc.nextInt();
        System.out.print("Introduce las ventas del segundo semestre: ");
        manzanasSemestre2 = sc.nextInt();

        System.out.println("Para las Peras:");
        System.out.print("Introduce las ventas del primer semestre: ");
        perasSemestre1 = sc.nextInt();
        System.out.print("Introduce las ventas del segundo semestre: ");
        perasSemestre2 = sc.nextInt();

        // Calculamos los beneficios
        beneficiosManzanas = (manzanasSemestre1 + manzanasSemestre2) * 2.35;
        beneficiosPeras = (perasSemestre1 + perasSemestre2) * 1.95;
        beneficiosTotales = beneficiosManzanas + beneficiosPeras;

        // Mostramos los resultados
        System.out.println("Beneficios de las Manzanas: " + beneficiosManzanas);
        System.out.println("Beneficios de las Peras: " + beneficiosPeras);
        System.out.println("Beneficios Totales: " + beneficiosTotales);

    }
}

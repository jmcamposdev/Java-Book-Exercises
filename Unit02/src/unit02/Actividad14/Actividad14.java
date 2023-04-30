package unit02.Actividad14;

import java.util.Scanner;

/*
    Crear una aplicación que solicite al usuario una fecha u muestra la fecha correspondiente al día siguiente.
 */
public class Actividad14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia, mes, anio, diasMes;

        // Pedimos la fecha
        System.out.print("Introduce el día: ");
        dia = sc.nextInt();

        System.out.print("Introduce el mes: ");
        mes = sc.nextInt();

        System.out.print("Introduce el año: ");
        anio = sc.nextInt();

        diasMes = switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 0;
        };

        if (dia < diasMes) {
            dia++;
        } else {
            dia = 1;
            if (mes < 12) {
                mes++;
            } else {
                mes = 1;
                anio++;
            }
        }

        System.out.println("La fecha siguiente es: " + dia + "/" + mes + "/" + anio);

    }
}

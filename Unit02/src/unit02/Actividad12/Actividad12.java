package unit02.Actividad12;

import java.util.Scanner;

/*
    Pedir el día, mes y año una fecha e indicar si la fecha es correcta.
    Hay que tener en cuenta que existen meses con 28, 30 y 31 días. Sin embargo, no
    vamos a tener en cuenta los años bisiestos.
 */
public class Actividad12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia, mes, anio;
        boolean fechaCorrecta = true;

        // Pedimos los números
        System.out.print("Introduce el día: ");
        dia = sc.nextInt();

        System.out.print("Introduce el mes: ");
        mes = sc.nextInt();

        System.out.print("Introduce el año: ");
        anio = sc.nextInt();

        // Comprobamos si la fecha es correcta
        if (dia < 1 || dia > 31) {
            System.out.println("El día introducido no es correcto.");
            fechaCorrecta = false;
        } else if (mes < 1 || mes > 12) {
            System.out.println("El mes introducido no es correcto.");
            fechaCorrecta = false;
        } else if (anio < 1) {
            System.out.println("El año introducido no es correcto.");
            fechaCorrecta = false;
        } else {
            System.out.println("La fecha introducida es correcta.");
        }

        // Comprobamos si la fecha es correcta
        if (fechaCorrecta && ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia <= 30) ||
                ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10) && dia <= 31) ||
                (mes == 2 && dia <= 28)) {
            System.out.println("La fecha introducida es correcta.");
        } else {
            System.out.println("La fecha introducida no es correcta.");
        }

    }
}

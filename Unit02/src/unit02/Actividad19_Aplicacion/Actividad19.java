package unit02.Actividad19_Aplicacion;

import java.util.Scanner;

/*
    Escribe una aplicación que solicite por consola dos números reales que corresponden
    a la base y la altura de un triángulo. Deberá mostrarse su área, comprobando que los
    números introducidos son positivos sino se mostrará un mensaje de error.
 */
public class Actividad19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base, altura, area;

        // Pedimos los datos
        System.out.print("Introduce la base: ");
        base = sc.nextDouble();

        System.out.print("Introduce la altura: ");
        altura = sc.nextDouble();

        if (base > 0 && altura > 0) {
            area = base * altura / 2;
            System.out.println("El área del triángulo es: " + area);
        } else {
            System.out.println("Los números introducidos no son positivos");
        }
    }
}

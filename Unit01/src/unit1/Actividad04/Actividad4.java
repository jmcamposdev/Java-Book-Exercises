package unit1.Actividad04;

import java.util.Scanner;

/*
    Escribir una aplicación que pida el año actual y el de nacimiento del usuario.
    Debe calcular su edad, suponiendo que ya ha cumplido años este año.
 */
public class Actividad4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int añoActual;
        int añoNacimiento;
        int edad;

        System.out.print("Introduce el año actual: ");
        añoActual = sc.nextInt();
        System.out.print("Introduce tu año de nacimiento: ");
        añoNacimiento = sc.nextInt();

        edad = añoActual - añoNacimiento;
        System.out.println("Tienes " + edad + " años.");

    }
}

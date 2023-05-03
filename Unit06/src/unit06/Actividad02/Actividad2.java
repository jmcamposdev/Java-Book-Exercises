package unit06.Actividad02;

import java.util.Scanner;

/*
    Introducir por teclado dos frases e indicar cuál de ellas es la más corta, es decir, la que contiene menos caracteres.
 */
public class Actividad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos las cadenas
        System.out.print("Ingrese la primera cadena: ");
        String cadena1 = sc.nextLine();
        System.out.print("Ingrese la segunda cadena: ");
        String cadena2 = sc.nextLine();

        // Comparamos las cadenas
        if (cadena1.length() > cadena2.length()){ // Si la primera cadena es mayor que la segunda
            System.out.println("La primera cadena es mayor");
        } else if (cadena2.length() > cadena1.length()){ // Si la segunda cadena es mayor que la primera
            System.out.println("La segunda cadena es mayor");
        } else{ // Si las cadenas son iguales
            System.out.println("Tienen la misma longitud");
        }

    }
}

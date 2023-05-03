package unit06.Actividad10;

import java.util.Scanner;

/*
    Realizar un programa que lea una frase del teclado y nos indique si es palíndroma, es decir,
    que una frase es palíndroma cuando se lea igual de izquierda a derecha que de derecha a izquierda sin tener
    en cuenta los espacios.
 */
public class Actividad10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        String fraseInversa;

        // Pedimos la frase
        System.out.print("Ingrese la frase: ");
        frase = sc.nextLine();

        // Eliminamos los espacios en blanco
        frase = frase.replace(" ","");

        // Invertimos la frase
        fraseInversa = new StringBuilder(frase).reverse().toString();

        // Comprobamos si es palíndroma
        if (frase.equals(fraseInversa)){
            System.out.println("La frase es palíndroma");
        } else{
            System.out.println("La frase no es palíndroma");
        }
    }
}

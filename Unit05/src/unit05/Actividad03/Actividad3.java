package unit05.Actividad03;

import java.util.Scanner;

/*
    Pedir al usuario cuantos números quiere introducir. Y pedirles los números y
    mostrar el orden inverso de los números introducidos
 */
public class Actividad3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidadDeNumeros;
        System.out.print("Ingrese la cantidad de números deseada: ");
        cantidadDeNumeros = sc.nextInt();
        int[] listado = new int[cantidadDeNumeros];
        for (int i = 0; i < listado.length ; i++) {
            System.out.print("Ingrese el numero: ");
            listado[i] = sc.nextInt();
        }
        System.out.print("El listado invertido es: [");
        for (int i = listado.length-1 ; i >= 0 ; i--) {
            System.out.print(listado[i]+",");
        }
        System.out.print("]");
    }
}

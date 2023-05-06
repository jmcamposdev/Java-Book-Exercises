package unit9.Actividad02;

import unit9.Actividad01.Lista;

import java.util.Scanner;

/*
    Utilizando la lista anterior escribir un programa en el que se encolen números enteros introducidos
    por teclado, hasta que se introduzca uno negativo. A continuación,  desencolar todos a medida que
    se muestran por pantalla
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista lista = new Lista();
        int num;
        // Pedimos los numeros por teclado hasta que se introduzca uno negativo
        do {
            System.out.print("Introduce un numero entero: ");
            num = sc.nextInt();
            if (num >= 0){
                lista.encolar(num);
            }
        } while (num >= 0);

        // Desencolamos y mostramos los numeros por pantalla
        while (lista.numeroElementos() > 0){
            System.out.println(lista.desencolar());
        }

    }
}

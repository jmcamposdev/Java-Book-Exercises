package unit03.Actividad03;

import java.util.Scanner;

/*
    Codificar el juego "el número secreto" que consiste en acertar un número entre 1 y 100.
    Para ello se introduce por teclado una serie de números, para los que se indica si es mayor o menor
    que el número secreto. El proceso termina cuando se acierta el número secreto o introduce -1.
 */
public class Actividad3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userNum, secretNum = (int) (Math.random() * 100 + 1);
        boolean acertado = false;
        boolean rendirse = false;

        while (!acertado && !rendirse) {
            System.out.print("Introduce un número: ");
            userNum = sc.nextInt();

            if (userNum == -1) {
                rendirse = true;
            } else if (userNum == secretNum) {
                acertado = true;
            } else if (userNum > secretNum) {
                System.out.println("El número secreto es menor");
            } else {
                System.out.println("El número secreto es mayor");
            }
        }

        if (acertado) {
            System.out.println("¡Has acertado!");
        } else {
            System.out.println("Te has rendido, el número secreto era " + secretNum + ".");
        }
    }
}

package unit02.Actividad16_Aplicacion;

import java.util.Scanner;

/*
    El DNI consta de un entero de 8 dígitos seguidos de una letra que se obtiene a partir del
    número de la siguiente forma:
        letra = número dni módulo 22;
    Basándote en esta información elige la letra a partir de la numeración de la siguiente tabla:
    0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22
    T  R  W  A  G  M  Y  F  P  D  X  B  N  J  Z  S  Q  V  H  L  C  K  E

 */
public class Actividad16 {
    public static void main(String[] args) {
        String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D",
                "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L",
                "C", "K", "E"};
        Scanner sc = new Scanner(System.in);
        int dni, resto;
        String letra;

        System.out.print("Introduce el DNI: ");
        dni = sc.nextInt();

        resto = dni % 23;
        letra = letras[resto];

        System.out.println("La letra del DNI es: " + letra);

    }
}

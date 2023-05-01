package unit04.Actividad09;

import unit04.Actividad04.Actividad4;

/*
    Repite la actividad 4 con una versión que calcule el máximo de 3 números.
 */
public class Actividad9 {
    public static void main(String[] args) {
        System.out.println("El máximo de 2, 3 y 4 es: " + maximo(2, 3, 4));
        System.out.println("El máximo de 10, 3 y 4 es: " + maximo(10, 3, 4));
        System.out.println("El máximo de 2, 30 y 4 es: " + maximo(2, 30, 4));
        System.out.println("El máximo de 2, 3 y 40 es: " + maximo(2, 3, 40));
    }

    public static int maximo(int num1, int num2, int num3) {
        int aux = Actividad4.mayor(num1, num2);
        return Actividad4.mayor(aux, num3);
    }
}

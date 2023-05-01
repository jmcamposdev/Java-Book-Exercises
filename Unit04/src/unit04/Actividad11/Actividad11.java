package unit04.Actividad11;

/*
    Escribir una función que calcule de forma recuriva el máximo común dividisor de dos números enteros.
 */
public class Actividad11 {
    public static void main(String[] args) {
        System.out.println("El máximo común divisor de 10 y 5 es: " + mcd(10, 5));
        System.out.println("El máximo común divisor de 10 y 3 es: " + mcd(10, 3));
        System.out.println("El máximo común divisor de 10 y 2 es: " + mcd(10, 2));
        System.out.println("El máximo común divisor de 10 y 1 es: " + mcd(10, 1));
        System.out.println("El máximo común divisor de 10 y 0 es: " + mcd(10, 0));
        System.out.println("El máximo común divisor de 5 y 10 es: " + mcd(5, 10));
    }

    public static int mcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return mcd(num2, num1 % num2);
        }
    }
}

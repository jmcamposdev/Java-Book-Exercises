package unit04.Actividad12;

/*
    Diseñar una función recursiva que calcule el enésimo término de la sucesión de Fibonacci.
    En esta serie el enésimo valor se calcula sumando los dos valores anteriores de la serie.
 */
public class Actividad12 {
    public static void main(String[] args) {
        System.out.println("El término 0 de la serie de Fibonacci es: " + fibonacci(0));
        System.out.println("El término 1 de la serie de Fibonacci es: " + fibonacci(1));
        System.out.println("El término 2 de la serie de Fibonacci es: " + fibonacci(2));
        System.out.println("El término 3 de la serie de Fibonacci es: " + fibonacci(3));
        System.out.println("El término 4 de la serie de Fibonacci es: " + fibonacci(4));
        System.out.println("El término 5 de la serie de Fibonacci es: " + fibonacci(5));
        System.out.println("El término 6 de la serie de Fibonacci es: " + fibonacci(6));
        System.out.println("El término 7 de la serie de Fibonacci es: " + fibonacci(7));
        System.out.println("El término 8 de la serie de Fibonacci es: " + fibonacci(8));
        System.out.println("El término 9 de la serie de Fibonacci es: " + fibonacci(9));
        System.out.println("El término 10 de la serie de Fibonacci es: " + fibonacci(10));
    }

    private static int fibonacci(int i) {
        if (i == 0 || i == 1) {
            return i;
        } else {
            return fibonacci(i - 1) + fibonacci(i - 2);
        }
    }
}

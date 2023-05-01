package unit03.Actividad24_Aplicacion;

import java.util.Scanner;

/*
    Calcula la raíz cuadrada de un número natural mediante aproximaciones sucesivas. En el caso
    de que no sea exacta muestra el resto. Por ejemplo para calcular la raíz cuadrada de 23, probamos
    1^2 = 1, 2^2 = 4, 3^2 = 9, 4^2 = 16, 5^2 = 25. Por lo tanto, la raíz cuadrada de 23 es 4 y el resto es 7
 */
public class Activiadd24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, raiz = 0, resto = 0;

        // Pedimos el número
        System.out.print("Introduce el número: ");
        n = sc.nextInt();

        // Calculamos la raíz
        for (int i = 1; i <= n; i++) {
            if (i * i <= n) {
                raiz = i;
            }
        }
        // Calculamos el resto
        if (raiz * raiz != n) {
            resto = n - (raiz * raiz);
        }

        // Mostramos el resultado
        System.out.println("La raíz de " + n + " es " + raiz + " y el resto es " + resto);
    }
}

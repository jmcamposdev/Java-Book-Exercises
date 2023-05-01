package unit04.Actividad10;

/*
    Disñar una función que calcule a^n donde a es real y n es entero no negativo. Realizar una verión
    iterativa y otra recursiva.
 */
public class Actividad10 {
    public static void main(String[] args) {
        System.out.println("2^3 = " + potenciaIterativa(2, 3));
        System.out.println("2^3 = " + potenciaRecursiva(2, 3));

    }

    public static double potenciaIterativa(double a, int n) {
        double resultado = 1;
        for (int i = 0; i < n; i++) {
            resultado *= a;
        }
        return resultado;
    }

    public static double potenciaRecursiva(double a, int n) {
        if (n == 0) {
            return 1;
        } else {
            return a * potenciaRecursiva(a, n - 1);
        }
    }
}

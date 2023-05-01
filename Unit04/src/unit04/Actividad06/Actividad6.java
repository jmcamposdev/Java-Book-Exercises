package unit04.Actividad06;

/*
    Diseñar una función con el siguiente prototipo:
        boolean esPrimo(int n)
    Que devolverá true si el número n es primo y false en caso contrario.
 */
public class Actividad6 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (esPrimo(i)) {
                System.out.println(i + " es primo");
            }
        }
    }

    private static boolean esPrimo(int i) {
        boolean primo = true;
        for (int j = 2; j < i && primo; j++) {
            if (i % j == 0) {
                primo = false;
            }
        }
        return primo;
    }
}

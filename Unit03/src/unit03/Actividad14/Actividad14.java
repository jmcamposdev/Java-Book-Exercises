package unit03.Actividad14;

/*
    Diseñar una aplicación que muestre las tablas de multiplicar del 1 al 10.
 */
public class Actividad14 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) { // Tablas del 1 al 10
            System.out.println("Tabla del " + i);
            for (int j = 1; j <= 10; j++) { // Multiplicar del 1 al 10
                System.out.println(i + " * " + j + " = " + (i * j));
            }
            System.out.println();
        }
    }
}

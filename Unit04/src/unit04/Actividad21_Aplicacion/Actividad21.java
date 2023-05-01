package unit04.Actividad21_Aplicacion;

import java.util.Scanner;

/*
    Sobrecarga la función realizada en la Actividad 20 pera que el único parámetro sea la cantidad
    de números aleatorios que se muestran por consola. Los números aleatorios se generarán entre 0 y 100.
 */
public class Actividad21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidad;

        // Pedimos los datos
        System.out.print("Introduce la cantidad de números aleatorios: ");
        cantidad = sc.nextInt();

        // Mostramos los números aleatorios
        muestraAleatorios(cantidad);
    }

    private static void muestraAleatorios(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            System.out.println((int) (Math.random() * 101));
        }
    }
}


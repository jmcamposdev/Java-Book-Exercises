package unit05.Actividad12;

/*
    Crear una tabla bidimensional de longitud 5 x 5 y rellenarla de la siguiente forma: el
    elemento de la posición [n][m] debe contener el valor 10 * n + m. Después se debe mostrar su
    contenido.
 */

public class Actividad12 {
    public static void main(String[] args) {
        int[][] tabla = new int[5][5];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                tabla[i][j] = 10*i+j;
            }
        }
        for (int[] fila:tabla) {
            for (int valor:fila) {
                System.out.print(valor+" ");
            }
            System.out.println();
        }
    }
}

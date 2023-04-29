package unit13;

import java.util.ArrayList;

/*
    Utilizando el método reduce de la interfaz Stream. Calcula el producto de los
    elementos de un Stream de enteros.
 */
public class Actividad28_Ampliacion {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            lista.add((int) (Math.random() * 10) + 1);
        }

        int producto = lista.stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println("Lista: " + lista);
        System.out.println("Producto: " + producto);
    }
}

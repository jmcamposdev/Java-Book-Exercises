package unit12.Actividad05;

import java.util.ArrayList;

/*
    Implementar una aplicación en la que se insertan 20 números enteros aleatorios entre 1 y 10 incluidos, que pueden
    estar repetidos, en una colección. A continuación, se crea una lista con los mismos elementos sin repetir.
 */
public class Actividad5 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = crearArrayListAleatorio(20, 1, 10);
        ArrayList<Integer> listaSinRepetidos = listaSinRepeticiones(lista);

        System.out.println("Lista Generada: "+ lista);
        System.out.println("Lista sin Repetidos: "+ listaSinRepetidos);

    }

    private static ArrayList<Integer> crearArrayListAleatorio (int n, int min, int max) {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lista.add((int) (Math.random() * (max - min + 1)) + min);
        }
        return lista;
    }

    private static ArrayList<Integer> listaSinRepeticiones (ArrayList<Integer> lista) {
        ArrayList<Integer> listaSinRepetidos = new ArrayList<>();
        for (Integer n : lista) {
            if (!listaSinRepetidos.contains(n)) {
                listaSinRepetidos.add(n);
            }
        }
        return listaSinRepetidos;
    }
}

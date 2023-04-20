package unit12.Actividad19;


import unit12.Actividad18_Aplicacion.Contenedor;

import java.util.Comparator;

/*
    Repite la Actividad 17 ordenando los números de mayor a menor.
 */
public class Actividad19 {
    public static void main(String[] args) {
        Contenedor<Integer> contenedor = new Contenedor<>(new Integer[0]);
        for (int i = 0; i < 30; i++) {
            contenedor.insertarAlPrincipio((int) (Math.random() * 10 + 1));
        }
        System.out.println("Sin ordenar: " + contenedor);
        Comparator<Integer> c = Integer::compareTo;
        c = c.reversed();
        contenedor.ordenar(c);
        System.out.println("Ordenado: " + contenedor);
    }
}

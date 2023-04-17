package unit12.Actividad07;

import unit12.Actividad05.Actividad5;

import java.util.ArrayList;

/*
    Repetir la Actividad 6 usando métodos globales
 */
public class Actividad7 {
    public static void main(String[] args) {
        ArrayList<Integer> listaGenerada = Actividad5.crearArrayListAleatorio(100,1,10);
        System.out.println("Lista Generada: "+listaGenerada);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(5);
        listaGenerada.removeAll(c);
        System.out.println("Lista sin 5: "+ listaGenerada);
    }
}

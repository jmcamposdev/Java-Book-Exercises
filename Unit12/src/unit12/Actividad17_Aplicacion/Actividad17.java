package unit12.Actividad17_Aplicacion;

import unit12.Actividad02.Contenedor;

/*
    Utilizando la clase contenedor definida en la Actividad resuelta 12.2,
    implementa una aplicación donde se guardan 30 enteros aleatorios entre 1 y 10 y luego se ordenan de menor a mayor.
    La aplicación debe mostrar el contenedor antes y después de ordenar.
 */
public class Actividad17 {
    public static void main(String[] args) {
        Contenedor<Integer> contenedor = new Contenedor<>(new Integer[0]);
        for (int i = 0; i < 30; i++) {
            contenedor.insertarAlPrincipio((int) (Math.random() * 10 + 1));
        }
        System.out.println("Sin ordenar: " + contenedor);
        contenedor.ordenar();
        System.out.println("Ordenado: " + contenedor);
    }
}

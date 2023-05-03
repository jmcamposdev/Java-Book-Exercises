package unit07.Actividad14;


import java.util.Arrays;

/*
    Implementar el método no estático
     void insertarFinal (int número)
    que inserta un número entero al final de tablaEntero[], que es un atributo no estático de la clase main.
    Escribir un programa que inicialice con los números del 1 al 10 y después muestre por consola
 */
public class Actividad14 {
    int[] tablaEntero = new int[0];
    public static void main(String[] args) {
        Actividad14 main = new Actividad14();
        // por defecto
        for (int i = 0; i < 10; i++) {
            main.insertarFinal(i+1);
        }

        // mostrar por consola
        System.out.println(Arrays.toString(main.tablaEntero));
    }
    void insertarFinal (int numero){
        tablaEntero = java.util.Arrays.copyOf(tablaEntero,tablaEntero.length+1);
        tablaEntero[tablaEntero.length-1] = numero;
    }
}

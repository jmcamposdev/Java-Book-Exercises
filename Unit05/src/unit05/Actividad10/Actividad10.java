package unit05.Actividad10;

import java.util.Arrays;

/*
    Escribir la función:
            int[] eliminarMayores (int t[],int valor)
    Que crea y devuelve una copia de la tabla t donde se han eliminado todos lo elemento
    que son mayores que valor. La tabla devuelta tendrá un tamaño igual o menor que t.
 */
public class Actividad10 {
    public static void main(String[] args) {
        int[] array = {12,3,4,5,55,6,7,2};
        System.out.println("El nuevo array es: "+ Arrays.toString(eliminarMayores(array,5)));

    }

    public static int[] eliminarMayores (int[] t,int valor){
        int[] nuevoArray = Arrays.copyOf(t,t.length); // Creamos una copia del array introducido
        for (int i = 0; i < nuevoArray.length; i++) { // Recorremos el Array
            if (nuevoArray[i] > valor){ // Comprobamos que el valor del array sea mayor al introducido
                // Si es mayor En el índice del valor a eliminar poneos el valor del último índice
                nuevoArray[i] = nuevoArray[nuevoArray.length-1];
                // Una vez copiado el valor del último índice reducimos le array en 1
                // Por lo cual se eliminara el valor ya copiado.
                nuevoArray = Arrays.copyOf(nuevoArray,nuevoArray.length-1);
            }
        }
        return nuevoArray;
    }
}

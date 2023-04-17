package unit12.Actividad04;

import Functions.GetData;

import java.util.ArrayList;
import java.util.Iterator;

/*
    Implementa una aplicación donde se pidan por consola números reales has que se
    introduce un 0. A medida que se leen del teclado los valores positivos se insertan en una colección
    y los negativos en otra.
    Al final, se muestran ambas colecciones y las sumas de los elementos de cada una de ellas.
    Por último, se eliminan de ambas todos los valores que sean mayores que 10 o menores que -10
    y se vuelven a mostrar.
 */
public class Actividad4_Propuesta {
    public enum Filtro {
        MAYOR,MENOR
    }
    public static void main(String[] args) {
        ArrayList<Integer> listaPositivos = new ArrayList<>();
        ArrayList<Integer> listaNegativos = new ArrayList<>();
        System.out.println("Ingrese 0 para parar de insertar números.");
        int userNumero;
        boolean salida;
        do {
            userNumero = GetData.getInt("Ingrese un número: ");
            salida = userNumero == 0;
            if (!salida && userNumero > 0) {
                listaPositivos.add(userNumero);
            }
            if (!salida && userNumero < 0) {
                listaNegativos.add(userNumero);
            }
        } while (!salida);

        mostrarInfo(listaPositivos, "Lista de Positivos: ");
        System.out.println("----------------------");
        mostrarInfo(listaNegativos,"Lista de Negativos: ");

        filtrarLista(listaPositivos,10,Filtro.MAYOR);
        filtrarLista(listaNegativos,10,Filtro.MENOR);

        mostrarInfo(listaPositivos, "Lista de Positivos: ");
        System.out.println("----------------------");
        mostrarInfo(listaNegativos,"Lista de Negativos: ");

    }

    private static int sumarLista(ArrayList<Integer> lista) {
        int suma = 0;
        for (Integer n : lista) {
            suma += n;
        }
        return suma;
    }

    private static void filtrarLista (ArrayList<Integer> lista, int n, Filtro filtro) {
        Iterator<Integer> it = lista.iterator();
        if (filtro == Filtro.MAYOR) {
            while (it.hasNext()) {
                if (it.next() > n){
                    it.remove();
                }
            }
        } else if (filtro == Filtro.MENOR) {
            while (it.hasNext()) {
                if (it.next() < n){
                    it.remove();
                }
            }
        }
    }

    private static void mostrarInfo (ArrayList<Integer> lista, String mensaje) {
        System.out.println(mensaje+ lista);
        System.out.println("Suma total: "+ sumarLista(lista));
    }


}

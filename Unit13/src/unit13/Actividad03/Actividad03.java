package unit13.Actividad03;

import unit13.Actividad01.Cliente;

import java.util.Arrays;
import java.util.Comparator;

/*
    Implementar un método estático al que se le pasa por parámetro una tabla de tipo genérico y un comparador para
    dicho tipo. El método devuelve el valor máximo de los elementos de la tabla según el criterio de orden del comparador
    Aplicarlo a una tabla de clientes para buscar el de más edad.
 */
public class Actividad03 {
    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente("Paco",10),
                new Cliente("Alvaro",11),
                new Cliente("Sofia",9),
                new Cliente("Carlos",20),
                new Cliente("Adrian",19)
        };

        System.out.println("El cliente con mayor edad es: " + maximo(clientes, (a,b) -> b.getEdad() - a.getEdad()).getNombre());
    }

    static <T> T maximo (T[] tabla, Comparator<T> comparator){
        Arrays.sort(tabla,comparator);
        return tabla[0];
    }
}

package unit9.Actividad14_15_Aplicacion;

import java.util.Arrays;

/*
    Actividad 14
    Diseñar una clase Futbolista con los siguientes atributos: dni, nombre, edad, número de goles.
    Implementar:
        - Un constructor y los métodos toString, equals (Basado en el dni).
        - La interfaz Comparable para que se ordenen por el dni
        - Un comparador para hacer ordenaciones basadas en el nombre y otro basado en la edad

    Crea una tabla con 5 futbolistas y mostrarlos ordenados por DNI, nombre y edad

    Actividad 15
    Añadir a la Actividad 14 un comparador que ordene los futbolistas por edades y para aquellos
    que tienen la misma edad por Nombre
 */
public class Main {
    public static void main(String[] args) {
        Futbolista[] futbolistas = new Futbolista[5];
        futbolistas[0] = new Futbolista("12345678A", "Juan", 20, 10);
        futbolistas[1] = new Futbolista("32345678B", "Pedro", 21, 5);
        futbolistas[2] = new Futbolista("22345678C", "Luis", 19, 15);
        futbolistas[3] = new Futbolista("52345678D", "Carlos", 22, 20);
        futbolistas[4] = new Futbolista("32345678E", "Antonio", 18, 25);

        System.out.println("Futbolistas sin ordenar:");
        mostrarFutbolistas(futbolistas);

        // Ordenar DNI
        Arrays.sort(futbolistas);
        System.out.println("\nFutbolistas ordenados por DNI:");
        mostrarFutbolistas(futbolistas);

        // Ordenar nombre
        Arrays.sort(futbolistas, new OrdenarNombre());
        System.out.println("\nFutbolistas ordenados por nombre:");
        mostrarFutbolistas(futbolistas);

        // Ordenar edad
        Arrays.sort(futbolistas, new OrdenarEdad());
        System.out.println("\nFutbolistas ordenados por edad:");
        mostrarFutbolistas(futbolistas);
    }

    public static void mostrarFutbolistas( Futbolista[] futbolistas ) {
        for (Futbolista futbolista : futbolistas) {
            System.out.println(futbolista);
        }
    }
}

package unit1.Actividad10;

import java.util.Scanner;

/*
    Diseñar un algoritmo que nos indique si podemos salir a la calle.
    Existen aspectos que influirán en esta decisión:
    Si está lloviendo y si hemos terminado nuestras tareas.
    Solo podremos salir a la calle si no está lloviendo y hemos finalizado nuestras tareas.
    Existe una opción en la que, indistintamente de lo anterior, podremos salir a la calle:
    el hecho de que tengamos que ir a la biblioteca (para realizar algún trabajo, entregar un libro, etc.).

    Solicitar al usuario (mediante un booleano)
    - Si llueve
    - Si ha finalizado las tareas
    - Si necesita ir a la biblioteca.

    El algoritmo debe mostrar mediante un booleano (true o false) si es posible que se le otorgue permiso para ir a la calle.
 */
public class Actividad10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isLloviendo ;
        boolean isTareasFinalizadas;
        boolean isBiblioteca;
        boolean isPosibleSalir;

        System.out.print("¿Está lloviendo? ");
        isLloviendo = sc.nextBoolean();
        System.out.print("¿Ha finalizado las tareas? ");
        isTareasFinalizadas = sc.nextBoolean();
        System.out.print("¿Necesita ir a la biblioteca? ");
        isBiblioteca = sc.nextBoolean();

        isPosibleSalir = (!isLloviendo && isTareasFinalizadas) || isBiblioteca;
        System.out.println("¿Puede salir a la calle? " + isPosibleSalir);
    }
}

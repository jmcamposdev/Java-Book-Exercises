package unit13.Actividad06;

import unit13.Actividad01.Cliente;

import java.util.function.Consumer;

/*
    Implementar el método estático
        static <T> paraCada (T[) tabla, Consumer<I> c)
    Similar a forEach (que no existe para tablas).
    Este método ejecuta en cada elemento de la tabla la acción implementada en el objeto Consumer.
    Usarlo para mostrar por pantalla los nombres y edades de los Clientes de una tabla.
 */
public class Actividad6 {
    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente("Paco",10),
                new Cliente("Alvaro",11),
                new Cliente("Sofia",9),
                new Cliente("Carlos",20),
                new Cliente("Adrian",19)
        };

        paraCada(clientes, e -> System.out.println(e.getNombre() + " | " + e.getEdad()));
    }

    public static <T> void paraCada (T[] tabla, Consumer<T> c) {
        for (T elemento : tabla) {
            c.accept(elemento);
        }
    }
}

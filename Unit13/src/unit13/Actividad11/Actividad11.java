package unit13.Actividad11;

import unit13.Actividad01.Cliente;

import java.util.Arrays;

/*
    A partir de la tabla de clientes cClie, mostrar un listado de los clientes
    donde aparezcan sus nombres y edades ordenados por nombre.
 */
public class Actividad11 {
    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente("Paco",10),
                new Cliente("Alvaro",11),
                new Cliente("Sofia",9),
                new Cliente("Carlos",20),
                new Cliente("Adrian",19)
        };

        Arrays.stream(clientes)
                .sorted((a,b) -> a.getNombre().compareTo(b.getNombre()))
                .map(c -> c.getNombre() + " | " + c.getEdad())
                .forEach(System.out::println);
    }
}

package unit13.Actividad13;

import unit13.Actividad01.Cliente;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/*
    A partir de la calse Cliente, crear la clase DatosCliente con los atributos nombre y fechaNacimiento
    y los métodos:
        - DatosCliente(Cliente c)
        - int edad()
        - String toString: que muestre nombre y edad.

    Con los elementos de la tabla de clientes tClie, construir un mapa que tenga como clave el atributo
    dni y como valor el objeto DatosCliente correspondiente. Mostrar el mapa por pantalla.
 */
public class Actividad13 {
    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente("Paco", LocalDate.of(1990,1,1)),
                new Cliente("Alvaro",LocalDate.of(1991,2,2)),
                new Cliente("Sofia",LocalDate.of(1992,3,3)),
                new Cliente("Carlos",LocalDate.of(1993,4,4)),
                new Cliente("Adrian",LocalDate.of(1994,5,5)),
        };

        Map<String, DatosCliente> m = Arrays.stream(clientes)
                .collect(Collectors.toMap(Cliente::getNombre, DatosCliente::new));

        System.out.println(m);
    }
}

package unit13.Actividad20_Aplicacion;

import unit13.Actividad19_Aplicacion.Cliente;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/*
    Añade a la clas Socio de la Actividad 19 los siguientes métodos:
    1. int edad(): Que calcula la edad del socio en años a partir de la fecha de nacimiento y la fecha actual.
    2. int antiguedad(): Que calcula la antigüedad del socio en meses a partir de la fecha de alta y la fecha actual.

    Crea un Stream con los socios ordenados por antigüedad y otro con los socios ordenados por edad.
 */
public class Actividad20 {
    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente("34629515W", "Paco", LocalDate.of(1990,1,1), LocalDate.of(2021,4,1), 50, 1),
                new Cliente("91257714Q", "Alvaro",LocalDate.of(1991,2,2), LocalDate.of(2021,2,1), 100, 1),
                new Cliente("76695223K", "Sofia",LocalDate.of(1992,3,3), LocalDate.of(2022,5,1), 110, 1),
                new Cliente("13141201J", "Carlos",LocalDate.of(1993,4,4), LocalDate.of(2021,6,1), 230, 1),
                new Cliente("93123067T", "Adrian",LocalDate.of(1994,5,5), LocalDate.of(2021,7,1), 89, 1),
        };

        Cliente[] ordenadosPorAntiguedad = Arrays.stream(clientes)
                .sorted(Comparator.comparingInt(Cliente::antiguedad))
                .toArray(Cliente[]::new);

        Cliente[] ordenadosPorEdad = Arrays.stream(clientes)
                .sorted(Comparator.comparingInt(Cliente::edad))
                .toArray(Cliente[]::new);

        System.out.println("Clientes ordenados por antigüedad: " + Arrays.toString(ordenadosPorAntiguedad));
        System.out.println("Clientes ordenados por edad: " + Arrays.toString(ordenadosPorEdad));
    }
}

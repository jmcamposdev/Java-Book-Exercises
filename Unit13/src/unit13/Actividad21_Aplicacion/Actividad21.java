package unit13.Actividad21_Aplicacion;

import unit13.Actividad19_Aplicacion.Cliente;

import java.time.LocalDate;
import java.util.Arrays;

/*
    A partir de una tabla de elementos de la Actividad 19, crea un Stream ordenado
    por dni y muéstralo por pantalla.
 */
public class Actividad21 {
    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente("34629515W", "Paco", LocalDate.of(1990,1,1), LocalDate.of(2021,4,1), 50, 1),
                new Cliente("91257714Q", "Alvaro",LocalDate.of(1991,2,2), LocalDate.of(2021,2,1), 100, 1),
                new Cliente("76695223K", "Sofia",LocalDate.of(1992,3,3), LocalDate.of(2022,5,1), 110, 1),
                new Cliente("13141201J", "Carlos",LocalDate.of(1993,4,4), LocalDate.of(2021,6,1), 230, 1),
                new Cliente("93123067T", "Adrian",LocalDate.of(1994,5,5), LocalDate.of(2021,7,1), 89, 1),
        };

        System.out.println("Clientes ordenados por DNI: " + Arrays.toString(Arrays.stream(clientes)
                .sorted()
                .toArray(Cliente[]::new)));
    }
}

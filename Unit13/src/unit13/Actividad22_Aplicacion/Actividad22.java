package unit13.Actividad22_Aplicacion;

import unit13.Actividad19_Aplicacion.Cliente;

import java.time.LocalDate;
import java.util.Arrays;

/*
    Repite la Actividad 21 pero en vez de mostrar los elementos del Stream obten a partir
    de él una tabla de String con los DNI de los socios.
 */
public class Actividad22 {
    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente("34629515W", "Paco", LocalDate.of(1990,1,1), LocalDate.of(2021,4,1), 50, 1),
                new Cliente("91257714Q", "Alvaro",LocalDate.of(1991,2,2), LocalDate.of(2021,2,1), 100, 1),
                new Cliente("76695223K", "Sofia",LocalDate.of(1992,3,3), LocalDate.of(2022,5,1), 110, 1),
                new Cliente("13141201J", "Carlos",LocalDate.of(1993,4,4), LocalDate.of(2021,6,1), 230, 1),
                new Cliente("93123067T", "Adrian",LocalDate.of(1994,5,5), LocalDate.of(2021,7,1), 89, 1),
        };

        String[] dniOrdeando = Arrays.stream(clientes)
                .sorted()
                .map(Cliente::getDni)
                .toArray(String[]::new);

        System.out.println("Clientes ordenados por DNI: " + Arrays.toString(dniOrdeando));
    }
}

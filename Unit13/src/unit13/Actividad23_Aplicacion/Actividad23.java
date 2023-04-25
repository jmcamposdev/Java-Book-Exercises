package unit13.Actividad23_Aplicacion;

import unit13.Actividad19_Aplicacion.Cliente;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/*
    Realiza la Actividad 22 pero obteniendo una lista en vez de una tabla
 */
public class Actividad23 {
    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente("34629515W", "Paco", LocalDate.of(1990,1,1), LocalDate.of(2021,4,1), 50, 1),
                new Cliente("91257714Q", "Alvaro",LocalDate.of(1991,2,2), LocalDate.of(2021,2,1), 100, 1),
                new Cliente("76695223K", "Sofia",LocalDate.of(1992,3,3), LocalDate.of(2022,5,1), 110, 1),
                new Cliente("13141201J", "Carlos",LocalDate.of(1993,4,4), LocalDate.of(2021,6,1), 230, 1),
                new Cliente("93123067T", "Adrian",LocalDate.of(1994,5,5), LocalDate.of(2021,7,1), 89, 1),
        };

        List<String> dniOrdeando = Arrays.stream(clientes)
                .sorted()
                .map(Cliente::getDni)
                .toList();

        System.out.println("Clientes ordenados por DNI: " + dniOrdeando);
    }
}

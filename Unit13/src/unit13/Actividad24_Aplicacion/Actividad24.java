package unit13.Actividad24_Aplicacion;

import unit13.Actividad19_Aplicacion.Cliente;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

/*
    Repite la Actividad 21 de forma que se obtenga una colección con los nombres
    en orden alfabético.
 */
public class Actividad24 {
    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente("34629515W", "Paco", LocalDate.of(1990,1,1), LocalDate.of(2021,4,1), 50, 1),
                new Cliente("91257714Q", "Alvaro",LocalDate.of(1991,2,2), LocalDate.of(2021,2,1), 100, 1),
                new Cliente("76695223K", "Sofia",LocalDate.of(1992,3,3), LocalDate.of(2022,5,1), 110, 1),
                new Cliente("13141201J", "Carlos",LocalDate.of(1993,4,4), LocalDate.of(2021,6,1), 230, 1),
                new Cliente("93123067T", "Adrian",LocalDate.of(1994,5,5), LocalDate.of(2021,7,1), 89, 1),
        };

        Collection<String> nombresOrdenados = Arrays.stream(clientes)
                .sorted((a,b) -> a.getNombre().compareTo(b.getNombre()))
                .map(Cliente::getNombre)
                .toList();

        System.out.println("Clientes ordenados por nombre: " + nombresOrdenados);
    }
}

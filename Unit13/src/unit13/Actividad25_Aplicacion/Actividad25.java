package unit13.Actividad25_Aplicacion;

import unit13.Actividad19_Aplicacion.Cliente;

import java.time.LocalDate;
import java.util.Arrays;

/*
    A partir de la tabla de la Actividad 21 calcula, usando un stream
    el número medio de familiares por socio.
 */
public class Actividad25 {
    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente("34629515W", "Paco", LocalDate.of(1990,1,1), LocalDate.of(2021,1,1), 50, 2),
                new Cliente("91257714Q", "Alvaro",LocalDate.of(1991,2,2), LocalDate.of(2021,1,1), 100, 3),
                new Cliente("76695223K", "Sofia",LocalDate.of(1992,3,3), LocalDate.of(2021,1,1), 110, 1),
                new Cliente("13141201J", "Carlos",LocalDate.of(1993,4,4), LocalDate.of(2021,1,1), 230, 4),
                new Cliente("93123067T", "Adrian",LocalDate.of(1994,5,5), LocalDate.of(2021,1,1), 89, 1),
        };

        int numeroPromedioFamiliares = (int) Arrays.stream(clientes)
                .mapToInt(Cliente::getNumFamiliares)
                .average()
                .orElse(0);

        System.out.println("El número promedio de familiares es: " + numeroPromedioFamiliares + "");
    }
}

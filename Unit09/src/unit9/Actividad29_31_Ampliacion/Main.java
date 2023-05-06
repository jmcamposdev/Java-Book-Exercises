package unit9.Actividad29_31_Ampliacion;

import unit9.Actividad25_Aplicacion.Lista;

import java.time.LocalDate;
import java.time.LocalTime;

/*
    Actividad 29
    Implementar la clase Jornada, cuyo objeto son los datos de cada día de trabajo de los empleados
    de una empresa. En ella se identificarán al trabajador por su DNI y figurarán la fecha y las horas
    de entrada y salida del trabajado de cada jornada. Un método computará el número de minutos trabajados en la jornada.
    El criterio de orden natural de las jornadas será el de los DNI y para igual DNI el de la fecha de jornada, con objeto de que aparezca
    consecutivas todas las jornadas de cada trabajador. Asimismo implementar el método toString() que muestre el DNI del empleado, la fecha
    y la duración en minutos de las jornadas.

    Actividad 30
    Usar la clase Lista de elementos Object para almacenar una serie de jornadas de empleados como
    las de la Actividad 29. Una vez insertadas, ordenar la lista y mostrar por pantalla las jornadas

    Actividad 31
    Implementar una clase comparadora para ordenar las jornadas de trabajo por orden de número
    de minutos trabajados. Ordenar la lista de la Actividad 30 por dicho orden y mostrarla por pantalla
 */
public class Main {
    public static void main(String[] args) {
        Lista listaJornadas = new Lista();

        listaJornadas.insertarFinal(new Jornada("24362934P", LocalDate.of(2021, 3, 1), LocalTime.of(8,10,11), LocalTime.of(16, 10, 11)));
        listaJornadas.insertarFinal(new Jornada("44362937P", LocalDate.of(2021, 3, 2), LocalTime.of(6,10,11), LocalTime.of(16, 10, 11)));
        listaJornadas.insertarFinal(new Jornada("14362947P", LocalDate.of(2021, 3, 3), LocalTime.of(7,11,11), LocalTime.of(15, 10, 20)));
        listaJornadas.insertarFinal(new Jornada("24362347P", LocalDate.of(2021, 3, 4), LocalTime.of(5,10,11), LocalTime.of(14, 59, 59)));

        listaJornadas.ordenar();

        System.out.println("Lista ordenada por DNI y fecha");
        System.out.println(listaJornadas);

        listaJornadas.ordenar(new OrdenarPorMinutosTrabajados());
        System.out.println("Lista ordenada por minutos trabajados de menor a mayor");
        System.out.println(listaJornadas);
    }
}

package unit13.Actividad19_Aplicacion;

import java.time.LocalDate;
import java.util.Arrays;

/*
    Implementa la clase Socio con los atributos dni, nombre, fechaNacimiento, fechaAlta (ambos de tipo LocalDate)
    cuota y numFamiliares (numeros de familiares del socio).
    Además de un constructor, implementa los métodos equals(), compareTo() (Basados en el DNI)  y toString().
    Crea una tabla con 5 socios y a partir de ella un stream con los socios:

    1. Ordenados por DNI
    2. Con una cuota mayor de 100 €
    3. Cuyo nombre empieza por "A"

    En todos los casos muestra el resultado por pantalla.
 */
public class Actividad19 {
    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente("34629515W", "Paco", LocalDate.of(1990,1,1), LocalDate.of(2021,1,1), 50, 1),
                new Cliente("91257714Q", "Alvaro",LocalDate.of(1991,2,2), LocalDate.of(2021,1,1), 100, 1),
                new Cliente("76695223K", "Sofia",LocalDate.of(1992,3,3), LocalDate.of(2021,1,1), 110, 1),
                new Cliente("13141201J", "Carlos",LocalDate.of(1993,4,4), LocalDate.of(2021,1,1), 230, 1),
                new Cliente("93123067T", "Adrian",LocalDate.of(1994,5,5), LocalDate.of(2021,1,1), 89, 1),
        };

        Cliente[] clientesOrdenados = Arrays.stream(clientes)
                .sorted()
                .toArray(Cliente[]::new);

        Cliente[] clientesConCuotaMayor = Arrays.stream(clientes)
                .filter(c -> c.getCuota() > 100)
                .toArray(Cliente[]::new);

        Cliente[] clientesEmpiezenPorA = Arrays.stream(clientes)
                .filter(c -> c.getNombre().startsWith("A"))
                .toArray(Cliente[]::new);

        System.out.println("Clientes ordenados por DNI: " + Arrays.toString(clientesOrdenados));
        System.out.println("Clientes con cuota mayor de 100: " + Arrays.toString(clientesConCuotaMayor));
        System.out.println("Clientes que empiezan por A :" + Arrays.toString(clientesEmpiezenPorA));
    }
}

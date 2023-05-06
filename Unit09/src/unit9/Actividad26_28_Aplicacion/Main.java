package unit9.Actividad26_28_Aplicacion;

import unit9.Actividad20_24_Aplicacion.OrdenarPorNombre;
import unit9.Actividad20_24_Aplicacion.Socio;
import unit9.Actividad25_Aplicacion.Lista;

import java.time.LocalDate;

/*
    Actividad 26
    Usar la Lista de la Actividad 25 para insertar cadenas de caracteres y ordenarlos por orden alfabético

    Actividad 27
    Repetir la Actividad 26 con los elementos de tipo Socio cuyo orden natural es el de la edad.

    Actividad 28
    Manteniendo el mismo orden natural de la clase Socio (por edades) ordenar la lista de socios
    por orden alfabético de nombre.

 */
public class Main {
    public static void main(String[] args) {
        Lista listaCadenas = new Lista();

        listaCadenas.insertarFinal("Hola");
        listaCadenas.insertarFinal("Adios");
        listaCadenas.insertarFinal("Buenos días");
        listaCadenas.insertarFinal("Buenas tardes");
        listaCadenas.insertarFinal("Buenas noches");
        listaCadenas.insertarFinal("Hasta luego");
        listaCadenas.insertarFinal("Hasta mañana");

        System.out.println("Lista sin ordenar");
        System.out.println(listaCadenas);

        listaCadenas.ordenar();
        System.out.println("Lista ordenada");
        System.out.println(listaCadenas);


        // Actividad 27
        Lista listaSocios = new Lista();

        listaSocios.insertarFinal(new Socio(3, "Luis", LocalDate.of(1992, 1, 1)));
        listaSocios.insertarFinal(new Socio(6, "Luisa", LocalDate.of(1995, 1, 1)));
        listaSocios.insertarFinal(new Socio(1, "Pepe", LocalDate.of(1990, 1, 1)));
        listaSocios.insertarFinal(new Socio(2, "Juan", LocalDate.of(1991, 1, 1)));
        listaSocios.insertarFinal(new Socio(4, "Ana", LocalDate.of(1993, 1, 1)));
        listaSocios.insertarFinal(new Socio(5, "Maria", LocalDate.of(1994, 1, 1)));

        System.out.println("Lista sin ordenar");
        System.out.println(listaSocios);

        listaSocios.ordenar();
        System.out.println("Lista ordenada por edad");
        System.out.println(listaSocios);


        // Actividad 28
        listaSocios.ordenar(new OrdenarPorNombre());

        System.out.println("Lista ordenada por nombre");
        System.out.println(listaSocios);



    }

}

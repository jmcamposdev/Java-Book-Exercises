package unit13.Actividad27_Aplicacion;

import unit13.Functions.GetData;

import java.util.HashMap;
import java.util.Map;

/*
    Queremos gestionar la plantilla de un equipo de fútbol, en la que a cada jugador se le asigna un dorsal que no puede estar repetido.
    Para ello vamos a crear una estructura de tipo Map cuyas entradas corresponden a los jugadores,
    con el dorsal como clave y un objeto de la clase Jugador como valor.
    De cada jugador se guarda el DNI, el nombre, la posición en el campo para simplificar,
    los jugadores pueden ser porteros, defensas, centrocampistas y delanteros  y su estatura.
    Define la clase Jugador y un enumerado para la posición en el campo, e implementa los siguientes métodos estáticos:

    static void altaJugador (Map< Integer, Jugador plantilla, Integer dor-sal):
    Que añade una entrada al mapa con el dorsal pasado como parámetro y el jugador creado dentro del método, introduciendo sus datos por consola.

    static Jugador eliminarJugador (Map<Integer, Jugador› plantilla, Integer dorsal)
    Que elimina la entrada correspondiente al jugador cuyo dorsal se pasa como parámetro.
    Dicho dorsal desaparece del mapa hasta que se asigne a otro jugador por medio de un alta. El método devuelve el jugador eliminado.

    static void mostrar (Map<Integer, Jugador› plantilla)
    Que muestra una lista de los dorsales con los nombres de los jugadores correspondientes.

    static void mostrar (Map<Integer, Jugador› plantilla, String posicion)
    Que muestra una lista de los jugadores que comparten una misma posición. Por ejemplo, todos los defensas o todos los delanteros.

    static boolean editarJugador (Map<Integer, Jugador› plantilla, Integer dorsal)
    Que permite modificar los datos de un jugador, excepto su dorsal y su DNI.
    Devuelve true si el dorsal existe y false en caso contrario.
 */
public class Actividad27 {
    public static void main(String[] args) {
        Map<Integer, Jugador> plantilla = new HashMap<>();
        boolean exit = false;
        int userOption;

        while (!exit) {
            mostrarMenu();
            userOption = GetData.getInt("Introduce una opción: ", 1, 6);
            switch (userOption) {
                case 1 -> altaJugador(plantilla, GetData.getInt("Introduce el dorsal: "));
                case 2 -> eliminarJugador(plantilla, GetData.getInt("Introduce el dorsal: "));
                case 3 -> editarJugador(plantilla, GetData.getInt("Introduce el dorsal: "));
                case 4 -> mostrar(plantilla);
                case 5 -> mostrar(plantilla, getPosicion());
                case 6 -> exit = true;
            }
        }
    }

    private static void editarJugador(Map<Integer, Jugador> plantilla, int anInt) {
        if (plantilla.containsKey(anInt)) {
            boolean exit = false;
            int userOption;
            Jugador jugador = plantilla.get(anInt);
            while (!exit) {
                mostrarMenuEditar();
                userOption = GetData.getInt("Introduce una opción: ", 1, 5);
                switch (userOption) {
                    case 1 -> jugador.setNombre(GetData.getString("Introduce el nombre: "));
                    case 2 -> jugador.setEstatura(GetData.getDouble("Introduce la estatura: "));
                    case 3 -> jugador.setPosicion(getPosicion());
                    case 4 -> exit = true;
                }
            }
        } else {
            System.out.println("El dorsal introducido no existe.");
        }
    }

    private static void altaJugador (Map< Integer, Jugador> plantilla, Integer dorsal) {
        if (plantilla.containsKey(dorsal)) {
            System.out.println("El dorsal introducido ya existe");
        } else {
            String dni = GetData.getString("Introduce el DNI: ");
            String nombre = GetData.getString("Introduce el nombre: ");
            double estatura = GetData.getDouble("Introduce la estatura: ");
            PosicionCampo posicion = getPosicion();
            plantilla.put(dorsal, new Jugador(dni, nombre, estatura, posicion));
            System.out.println("Jugador dado de alta correctamente.");
        }
    }

    private static Jugador eliminarJugador (Map<Integer, Jugador> plantilla, Integer dorsal) {
        Jugador jugadorEliminado = null;
        if (plantilla.containsKey(dorsal)) {
            jugadorEliminado = plantilla.get(dorsal);
            plantilla.remove(dorsal);
            System.out.println("Jugador eliminado correctamente.");
        } else {
            System.out.println("El dorsal introducido no existe.");
        }
        return jugadorEliminado;
    }

    private static void mostrar (Map<Integer, Jugador> plantilla) {
        plantilla.forEach((dorsal, jugador) -> System.out.println(dorsal + ". " + jugador.getNombre()));
        System.out.println("--------------------");
    }

    private static void mostrar (Map<Integer, Jugador> plantilla, PosicionCampo posicion) {
        plantilla.entrySet().stream()
                .filter(jugador -> jugador.getValue().getPosicion().equals(posicion))
                .forEach(jugador -> System.out.println(jugador.getKey() + ". " + jugador.getValue().getNombre()));
        System.out.println("--------------------");
    }


    private static PosicionCampo getPosicion () {
        for (PosicionCampo posicion : PosicionCampo.values()) {
            System.out.println(posicion.ordinal() + 1 + ". " + posicion);
        }
        return PosicionCampo.values()[GetData.getInt("Introduce una opción: ", 1, PosicionCampo.values().length) - 1];
    }

    private static void mostrarMenu () {
        System.out.println("""
                1. Alta jugador
                2. Eliminar jugador
                3. Editar jugador
                4. Mostrar jugadores
                5. Mostrar jugadores por posición
                6. Salir""");
    }
    private static void mostrarMenuEditar () {
        System.out.println("""
                1. Editar nombre
                2. Editar estatura
                3. Editar posición
                4. Salir""");
    }
}

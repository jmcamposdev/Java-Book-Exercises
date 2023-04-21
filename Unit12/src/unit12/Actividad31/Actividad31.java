package unit12.Actividad31;

import Functions.GetData;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.TreeMap;

/*
    Implementa una aplicación que gestione un club donde se identifica a los socios por un apodo personal y único.
    De cada socio, además del apodo, se guarda el nombre y su fecha de ingreso en el club.
    Utiliza un mapa donde las claves serán los apodos y los valores, objetos de la clase socio.
    Los datos se guardarán en un fichero llamado «club.dat», de donde se leerá el mapa al arrancar y
    donde se volverá a guardar actualizado al salir.
    Las operaciones se mostrarán en un menú que tendrá las siguientes opciones:
    1. Alta socio.
    2. Baja socio.
    3. Modificación socio.
    4. Listar socios por apodo.
    5. Listar socios por antigüedad.
    6. Listar los socios con alta anterior a un año determinado.
    7. Salir.
 */
public class Actividad31 {
    private static HashMap<String, Socio> club = new HashMap<>();
    private static final File fileClub = new File("src/unit12/Actividad31/club.dat");
    public static void main(String[] args) {
        cargarDatosClub();

        boolean exit = false;
        int option;

        while (!exit) {
            mostrarMenu();
            option = GetData.getInt("Introduce una opción: ", 1, 7);

            switch (option) {
                case 1 -> altaSocio();
                case 2 -> bajaSocio();
                case 3 -> modificarSocio();
                case 4 -> listarSociosPorApodo();
                case 5 -> listarSociosPorAntiguedad();
                case 6 -> listarSociosPorAntiguedadAnteriorA();
                case 7 -> {
                    exit = true;
                    guardarDatosClub();
                }
            }
        }
    }

    private static void guardarDatosClub() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileClub))) {
            oos.writeObject(club);
            System.out.println("Datos del club guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos del club.");
        }
    }

    private static void listarSociosPorAntiguedadAnteriorA() {
        LocalDate fecha = GetData.getFecha("Introduce una fecha: ");
        for (Socio socio : club.values()) {
            if (socio.getFechaIngreso().isBefore(fecha)) {
                System.out.println(socio);
            }
        }
    }

    private static void listarSociosPorAntiguedad() {
        TreeMap<LocalDate, Socio> sociosPorAntiguedad = new TreeMap<>();
        for (Socio socio : club.values()) {
            sociosPorAntiguedad.put(socio.getFechaIngreso(), socio);
        }
        for (LocalDate key : sociosPorAntiguedad.keySet()) {
            System.out.println(key + " -> " + sociosPorAntiguedad.get(key));
        }
    }

    private static void listarSociosPorApodo() {
        TreeMap<String, Socio> sociosPorApodo = new TreeMap<>(club);
        for (String key : sociosPorApodo.keySet()) {
            System.out.println(key + " -> " + sociosPorApodo.get(key));
        }
    }

    private static void modificarSocio() {
        String apodo = GetData.getString("Introduce el apodo del socio: ");
        if (club.containsKey(apodo)) {
            System.out.println("""
                    1. Modificar apodo.
                    2. Modificar nombre.
                    3. Modificar fecha de ingreso.""");
            int option = GetData.getInt("Introduce una opción: ", 1, 3);
            switch (option) {
                case 1 -> {
                    String nuevoApodo = GetData.getString("Introduce el nuevo apodo: ");
                    if (club.containsKey(nuevoApodo)) {
                        System.out.println("Ya existe un socio con ese apodo.");
                    } else {
                        club.get(apodo).setApodo(nuevoApodo);
                        club.put(nuevoApodo, club.get(apodo));
                        club.remove(apodo);
                        System.out.println("Se ha modificado el apodo del socio.");
                    }
                }
                case 2 -> {
                    String nombre = GetData.getString("Introduce el nuevo nombre: ");
                    club.get(apodo).setNombre(nombre);
                    System.out.println("Se ha modificado el nombre del socio.");
                }
                case 3 -> {
                    LocalDate fechaIngreso = GetData.getFecha("Introduce la nueva fecha de ingreso: ");
                    club.get(apodo).setFechaIngreso(fechaIngreso);
                    System.out.println("Se ha modificado la fecha de ingreso del socio.");
                }
            }
        } else {
            System.out.println("No existe un socio con ese apodo.");
        }
    }

    private static void bajaSocio() {
        String apodo = GetData.getString("Introduce el apodo del socio: ");
        if (club.containsKey(apodo)) {
            club.remove(apodo);
            System.out.println("Se ha dado de baja al socio.");
        } else {
            System.out.println("No existe un socio con ese apodo.");
        }
    }

    private static void altaSocio() {
        String apodo = GetData.getString("Introduce el apodo del socio: ");
        String nombre = GetData.getString("Introduce el nombre del socio: ");
        LocalDate fechaIngreso = GetData.getFecha("Introduce la fecha de ingreso del socio: ");
        if (club.containsKey(apodo)) {
            System.out.println("Ya existe un socio con ese apodo.");
        } else {
            club.put(apodo, new Socio(apodo, nombre, fechaIngreso));
            System.out.println("Se ha dado de alta al socio.");
        }
    }


    private static void cargarDatosClub () {
        if (fileClub.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileClub))) {
                club = (HashMap<String, Socio>) ois.readObject();
                System.out.println("Se han cargado " + club.size() + " socios.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los datos del club.");
            }
        } else {
            try {
                fileClub.createNewFile();
                System.out.println("No se han cargado los datos del club porque no existe el archivo «club.dat». Se creará al salir del programa.");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo «club.dat».");
            }
        }

    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Alta socio.
                2. Baja socio.
                3. Modificación socio.
                4. Listar socios por apodo.
                5. Listar socios por antigüedad.
                6. Listar los socios con alta anterior a un año determinado.
                7. Salir.""");
    }
}

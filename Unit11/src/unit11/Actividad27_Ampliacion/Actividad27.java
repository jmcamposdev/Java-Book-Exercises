package unit11.Actividad27_Ampliacion;

import Functions.GetData;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

/*
    Implementa la clase Deportista para gestionar la sección de deportes de un club social.
    Los atributos serán él:
    1. DNI
    2. Nombre
    3. Fecha de Nacimiento
    4. Deporte que practica (enumerado), que deberá ser uno de los que ofrece el club: natación, remo, vela y waterpolo.

    Escribe una aplicación que gestione los datos de los deportistas, utilizando una tabla cuya longitud deberá ajustarse con las altas y bajas,
    y un menú que incluya las opciones:
    1. Alta;
    2. Baja;
    3. Modificación de datos (todos los atributos salvo el DNI, que es inalterable);
    4. Listar por orden alfabético de nombres;
    5. Listar por orden de edad,
    6. Salir.

    Los datos se guardarán en un archivo binario, de donde se leerán al arrancar la aplicación y volverán a grabarse actualizados al salir.
 */
public class Actividad27 {
    private static final File FICHERO = new File("src/unit11/Actividad27_Ampliación/deportistas.dat");
    private static HashSet<Deportista> deportistas = new HashSet<>();
    public static void main(String[] args) {
        cargarDeportistas();

        boolean exit = false;
        int userOption;

        while (!exit) {
            mostrarMenu();
            userOption = GetData.getInt("Introduce una opción: ", 1, 6);
            switch (userOption) {
                case 1 -> añadirDeportista();
                case 2 -> eliminarDeportista();
                case 3 -> modificarDeportista();
                case 4 -> listarPorNombre();
                case 5 -> listarPorEdad();
                case 6 -> exit = true;
            }
        }
        guardarDeportistas();
    }




    private static void listarPorNombre() {
        if (deportistas.isEmpty()) {
            System.out.println("No hay deportistas para listar.");
            return;
        }
        ArrayList<Deportista> deportistasOrdenados = new ArrayList<>(deportistas);
        deportistasOrdenados.sort(new OrdenarDeportistaPorNombre());
        int contador = 1;
        for (Deportista deportista : deportistasOrdenados) {
            System.out.println(contador++ + ". " + deportista);
        }
        System.out.println("--------------------");
    }

    private static void listarPorEdad() {
        if (deportistas.isEmpty()) {
            System.out.println("No hay deportistas para listar.");
            return;
        }

        ArrayList<Deportista> deportistasOrdenados = new ArrayList<>(deportistas);
        deportistasOrdenados.sort(new OrdenarDeportistaPorEdad());
        int contador = 1;
        for (Deportista deportista : deportistasOrdenados) {
            System.out.println(contador++ + ". " + deportista);
        }
        System.out.println("--------------------");
    }

    private static void añadirDeportista() {
        String dni;
        boolean dniValido;
        do {
            dni = GetData.getString("Introduce el DNI del deportista: ");
            dniValido = Deportista.validarNIFCalc(dni);
            if (!dniValido) {
                System.out.println("El DNI introducido no es válido.");
            }
        } while (!dniValido);

        String nombre = GetData.getString("Introduce el nombre del deportista: ");
        LocalDate fechaNacimiento = GetData.getFecha("Introduce la fecha de nacimiento del deportista (dd/MM/yyyy): ");
        Deportes deporte = elegirDeporte();

        Deportista deportista = new Deportista(dni, nombre, fechaNacimiento, deporte);

        if (deportistas.add(deportista)) {
            System.out.println("Se ha añadido el deportista " + deportista.getNombre() + " con el DNI " + deportista.getDni() + " al fichero.");
        } else {
            System.out.println("El deportista " + deportista.getNombre() + " con el DNI " + deportista.getDni() + " ya existe.");
        }
    }

    private static void eliminarDeportista() {
        if (deportistas.isEmpty()) {
            System.out.println("No hay deportistas para eliminar.");
        } else {
            int deportista = getDeportista();
            Deportista deportistaEliminado = new ArrayList<>(deportistas).get(deportista);
            deportistas.remove(deportistaEliminado);
            System.out.println("Se ha eliminado el deportista " + deportistaEliminado.getNombre() + " con el DNI " + deportistaEliminado.getDni());
        }
    }

    private static void modificarDeportista() {
        if (deportistas.isEmpty()) {
            System.out.println("No hay deportistas para modificar.");
        } else {
            int deportista = getDeportista();
            Deportista deportistaModificado = new ArrayList<>(deportistas).get(deportista);
            boolean exit = false;
            int userOption;
            while (!exit) {
                mostrarMenuModificarDeportista();
                userOption = GetData.getInt("Introduce una opción: ", 1, 4);
                switch (userOption) {
                    case 1 -> {
                        String nombre = GetData.getString("Introduce el nuevo nombre del deportista: ");
                        deportistaModificado.setNombre(nombre);
                        System.out.println("Se ha modificado el nombre del deportista " + deportistaModificado.getNombre() + " con el DNI " + deportistaModificado.getDni());
                    }
                    case 2 -> {
                        LocalDate fechaNacimiento = GetData.getFecha("Introduce la nueva fecha de nacimiento del deportista (dd/MM/yyyy): ");
                        deportistaModificado.setFechaNacimiento(fechaNacimiento);
                        System.out.println("Se ha modificado la fecha de nacimiento del deportista " + deportistaModificado.getNombre() + " con el DNI " + deportistaModificado.getDni());
                    }
                    case 3 -> {
                        Deportes deporte = elegirDeporte();
                        deportistaModificado.setDeporte(deporte);
                        System.out.println("Se ha modificado el deporte del deportista " + deportistaModificado.getNombre() + " con el DNI " + deportistaModificado.getDni());
                    }
                    case 4 -> exit = true;
                }
            }
        }
    }



    private static void cargarDeportistas() {
        if (FICHERO.exists()) {
            try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(FICHERO))) {
                deportistas = (HashSet<Deportista>) flujoEntrada.readObject();
                System.out.println("Se han cargado " + deportistas.size() + " deportistas.");
            } catch (Exception e) {
                System.out.println("Error al cargar los deportistas: " + e.getMessage());
            }
        } else {
            System.out.println("Se ha creado el fichero " + FICHERO.getName() + " para guardar los deportistas.");
        }
    }
    private static void guardarDeportistas() {
        try (ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            flujoSalida.writeObject(deportistas);
            System.out.println("Se han guardado " + deportistas.size() + " deportistas.");
        } catch (Exception e) {
            System.out.println("Error al guardar los deportistas: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Alta
                2. Baja
                3. Modificación de datos
                4. Listar por orden alfabético de nombres
                5. Listar por orden de edad
                6. Salir.""");
    }
    private static void mostrarMenuModificarDeportista() {
        System.out.println("""
                1. Modificar nombre
                2. Modificar fecha de nacimiento
                3. Modificar deporte
                4. Salir.""");
    }
    private static void mostrarDeportes() {
        int contador = 1;
        for (Deportes deporte : Deportes.values()) {
            System.out.println(contador++ + ". " + deporte.getDeporte());
        }
    }
    private static Deportes elegirDeporte() {
        mostrarDeportes();
        int userOption = GetData.getInt("Introduce una opción: ", 1, Deportes.values().length) - 1;
        return Deportes.values()[userOption];
    }

    private static int getDeportista() {
        int contador = 1;
        for (Deportista deportista : deportistas) {
            System.out.println(contador++ + ". " + deportista.getNombre() + " (" + deportista.getDni() + ")");
        }
        return GetData.getInt("Introduce una opción: ", 1, deportistas.size()) - 1;
    }
}

package unit13.Actividad30_Ampliacion;

import unit13.Functions.GetData;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/*
    Implementa Stream para todos los listados

    Implementar la clase Socio, cuyos atributos son dni, nombre y fechaAlta, que deberá
    incluir el método equals(), la interfaz Comparable basada en el dni y el método antiguedad().
    Implementar  un programa que gestione los socios de un club guardando los datos en el fichero
    socios.dat. Al arrancar la aplicación, se leen los datos del fichero y se abre un menú con las
    opciones:
    1. Alta
    2. Baja
    3. Modificación
    4. Listado por DNI
    5. Listado por antigüedad
    6. Salir

    Al salir de la aplicación se guardan en el fichero los datos actualizados
 */
public class Actividad11 {
    private static final int OPCION_ALTA = 1;
    private static final int OPCION_BAJA = 2;
    private static final int OPCION_MODIFICACION = 3;
    private static final int OPCION_LISTADO_DNI = 4;
    private static final int OPCION_LISTADO_ANTIGUEDAD = 5;
    private static final int OPCION_SALIR = 6;
    private static final File ficheroSocios = new File("./src/unit12/Actividad11/socios.dat");
    private static ArrayList<Socio> listaSocios = new ArrayList<>();
    public static void main(String[] args) {
        cargarSocios();

        boolean exit = false;
        int userOption;

        while (!exit) {
            mostrarMenu();
            userOption = GetData.getInt("Ingrese una opción (1 - 6): ");
            switch (userOption) {
                case OPCION_ALTA -> añadirSocio();
                case OPCION_BAJA -> eliminarSocio();
                case OPCION_MODIFICACION -> modificarDNI();
                case OPCION_LISTADO_DNI -> listarSocios();
                case OPCION_LISTADO_ANTIGUEDAD -> {
                    listaSocios.stream().sorted((a,b) -> b.antiguedad() - a.antiguedad()).forEach(System.out::println);
                }
                case OPCION_SALIR -> exit = true;
            }
        }
        guardarSocios();
    }

    private static void añadirSocio() {
        String dni = solicitarDNI();
        String nombre = GetData.getString("Ingrese el nombre del socio: ");
        LocalDate fechaAlta = GetData.getFecha("Ingrese la Fecha de Alta: ");

        listaSocios.add(new Socio(dni,nombre,fechaAlta));
        Collections.sort(listaSocios);
    }
    private static void eliminarSocio() {
        int index = getSocioIndex();
        listaSocios.remove(index);
        System.out.println("Socio eliminado con Exito");
    }
    private static void modificarDNI() {
        int index = getSocioIndex();
        String newDNI = solicitarDNI();
        listaSocios.get(index).setDni(newDNI);
        System.out.println("Se ha modificado el DNI con exito");
    }

    private static void listarSocios() {
        listaSocios.forEach(System.out::println);
    }


    private static void cargarSocios() {
        if (ficheroSocios.exists()) {
            try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(ficheroSocios))) {
                listaSocios = (ArrayList<Socio>) flujoEntrada.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("No se ha podido cargar el fichero.");
            }
        } else {
            System.out.println("Se creerá un fichero para guardar los socios.");
            try {
                ficheroSocios.createNewFile();
            } catch (IOException e) {
                System.out.println("No se ha creado el fichero.");
            }
        }
    }

    private static void guardarSocios() {
        try (ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(ficheroSocios))) {
            flujoSalida.writeObject(listaSocios);
            System.out.println("Se han guardado los socios correctamente");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Alta
                2. Baja
                3. Modificación
                4. Listado por DNI
                5. Listado por Antigüedad
                6. Salir""");
    }

    private static int getSocioIndex () {
        int contador = 1;
        for (Socio s : listaSocios) {
            System.out.println(contador++ + ". " + s.getNombre());
        }
        return GetData.getInt("Seleccione un socio: ",1,listaSocios.size()) - 1;
    }

    private static String solicitarDNI () {
        String dni;
        boolean validDNI = true;
        do {
            dni = GetData.getString("Ingrese el DNI:");
            validDNI = dni.matches(Socio.NIF_PATTERN);
            if (!validDNI) {
                System.out.println("El dni no es válido.");
            }
        } while (!validDNI);
        return dni;
    }
}

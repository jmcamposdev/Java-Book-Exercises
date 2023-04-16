package unit11.Actividad29_Ampliacion;

import Functions.GetData;
import unit11.Actividad22_Aplicacion.Empleado;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

/*
    Desarrolla la Actividad 11.28 para añadir a la ficha de cada socio una lista de familiares a su cargo.
    Para ello, define la clase Familiar con los atributos: dni, nombre y fecha de nacimiento.
    Además, añade la opción de listar los datos de un socio incluyendo la lista de sus familiares ordenada por edad.
 */
public class Actividad29 {
    private static final File FICHERO = new File("src/unit11/Actividad29_Ampliacion/socios.dat");
    private static HashSet<Socio> socios = new HashSet<>();
    public static void main(String[] args) {
        cargarSocios();

        boolean exit = false;
        int userOption;

        while (!exit) {
            mostrarMenu();
            userOption = GetData.getInt("Introduce una opción: ", 1, 8);
            switch (userOption) {
                case 1 -> añadirSocio();
                case 2 -> añadirFamiliar();
                case 3 -> eliminarSocio();
                case 4 -> modificarSocio();
                case 5 -> listarPorNombre();
                case 6 -> listarPorAntiguedad();
                case 7 -> listarFamiliares();
                case 8 -> exit = true;
            }
        }

        guardarSocios(); // Guardamos los socios al salir del programa.
    }

    private static void listarFamiliares() {
        if (socios.isEmpty()) {
            System.out.println("No hay socios.");
            return;
        }
        int socioIndex = getSocio();
        Socio socio = new ArrayList<>(socios).get(socioIndex);
        System.out.println(socio.listarFamiliares());
    }

    private static void añadirFamiliar() {
        if (socios.isEmpty()) {
            System.out.println("No hay socios.");
            return;
        }
        int socioIndex = getSocio();
        Socio socio = new ArrayList<>(socios).get(socioIndex);

        String dni;
        boolean dniValido;
        do {
            dni = GetData.getString("Introduce el DNI del familiar: ");
            dniValido = Empleado.validarNIFCalc(dni);
            if (!dniValido) {
                System.out.println("El DNI no es válido.");
            }
        } while (!dniValido);
        String nombre = GetData.getString("Introduce el nombre del familiar: ");
        LocalDate fechaNacimiento = GetData.getFecha("Introduce la fecha de nacimiento del familiar (dd/MM/yyyy): ");

        Familiar familiar = new Familiar(dni, nombre, fechaNacimiento);

        if (socio.añadirFamiliar(familiar)) {
            System.out.println("Se ha añadido el familiar " + familiar.getNombre() + " con el DNI " + familiar.getDni() + ".");
        } else {
            System.out.println("No se ha podido añadir el familiar.");
        }



    }


    private static void añadirSocio() {
        String nombre = GetData.getString("Introduce el nombre del socio: ");
        LocalDate fechaNacimiento = GetData.getFecha("Introduce la fecha de nacimiento del socio (dd/MM/yyyy): ");
        String telefono = solicitarTelefono();
        String email = solicitarEmail();

        Socio socio = new Socio(nombre, fechaNacimiento, telefono, email);

        if (socios.add(socio)) {
            System.out.println("Se ha añadido el socio " + socio.getNombre() + " con el número " + socio.getNumeroSocio() + ".");
        } else {
            System.out.println("No se ha podido añadir el socio.");
        }
    }

    private static void cargarSocios() {
        if (FICHERO.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {
                socios = (HashSet<Socio>) ois.readObject();
                if (!socios.isEmpty()) {
                    Socio.setProximoNumeroSocio(new ArrayList<>(socios).get(socios.size() - 1).getNumeroSocio() + 1);
                }
                System.out.println("Se han cargado " +  socios.size() + " socios.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los socios.");
            }
        } else {
            System.out.println("Se ha creado el fichero " + FICHERO.getName() + " para guardar los socios.");
        }
    }

    private static void guardarSocios() {
        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            ois.writeObject(socios);
            System.out.println("Se han guardado " +  socios.size() + " socios.");
        } catch (IOException e) {
            System.out.println("Error al guardar los socios.");
        }
    }

    private static void modificarSocio() {
        if (socios.isEmpty()) {
            System.out.println("No hay socios.");
            return;
        }
        int socio = getSocio();
        Socio socioModificado = new ArrayList<>(socios).get(socio);
        boolean exit = false;
        int userOption;
        while (!exit) {
            mostrarMenuModificarSocio();
            userOption = GetData.getInt("Introduce una opción: ", 1, 5);
            switch (userOption) {
                case 1 -> {
                    String nombre = GetData.getString("Introduce el nombre del socio: ");
                    socioModificado.setNombre(nombre);
                }
                case 2 -> {
                    LocalDate fechaNacimiento = GetData.getFecha("Introduce la fecha de nacimiento del socio (dd/MM/yyyy): ");
                    socioModificado.setFechaNacimiento(fechaNacimiento);
                }
                case 3 -> {
                    String telefono = solicitarTelefono();
                    socioModificado.setTelefono(telefono);
                }
                case 4 -> {
                    String email = solicitarEmail();
                    socioModificado.setEmail(email);
                }
                case 5 -> exit = true;
            }
        }
        System.out.println("Se ha modificado el socio " + socioModificado.getNombre() + " con el número " + socioModificado.getNumeroSocio() + ".");
    }

    private static void listarPorNombre() {
        if (socios.isEmpty()) {
            System.out.println("No hay socios.");
            return;
        }
        ArrayList<Socio> sociosOrdenados = new ArrayList<>(socios);
        sociosOrdenados.sort(new OrdenarSocioPorNombre());
        int contador = 1;
        for (Socio socio : sociosOrdenados) {
            System.out.println(contador++ + ". " + socio);
        }
    }

    private static void listarPorAntiguedad() {
        if (socios.isEmpty()) {
            System.out.println("No hay socios.");
            return;
        }
        ArrayList<Socio> sociosOrdenados = new ArrayList<>(socios);
        sociosOrdenados.sort(new OrdenarSocioPorAntiguedad());
        int contador = 1;
        for (Socio socio : sociosOrdenados) {
            System.out.println(contador++ + ". " + socio);
        }
    }

    private static void eliminarSocio() {
        if (socios.isEmpty()) {
            System.out.println("No hay socios.");
            return;
        }
        int socio = getSocio();
        Socio socioEliminado = new ArrayList<>(socios).get(socio);
        socios.remove(socioEliminado);
        System.out.println("Se ha eliminado el socio " + socioEliminado.getNombre() + " con el número " + socioEliminado.getNumeroSocio() + ".");
    }


    private static void mostrarMenu() {
        System.out.println("""
                1. Añadir socio
                2. Añadir Familiar
                3. Eliminar socio
                4. Modificar socio
                5. Listar por nombre
                6. Listar por antigüedad
                7. Listar Familiares
                8. Salir""");
    }
    private static void mostrarMenuModificarSocio() {
        System.out.println("""
                1. Modificar nombre
                2. Modificar fecha de nacimiento
                3. Modificar teléfono
                4. Modificar correo electrónico
                5. Salir""");
    }

    private static int getSocio() {
        int contador = 1;
        for (Socio socio : socios) {
            System.out.println(contador++ + ". " +socio.getNombre() + " - " + socio.getNumeroSocio());
        }
        return GetData.getInt("Introduce el número del socio: ", 1, socios.size()) - 1;
    }

    private static String solicitarTelefono() {
        String telefono;
        boolean valido;
        do {
            telefono = GetData.getString("Introduce el teléfono del socio: ");
            valido = Socio.validarTelefono(telefono);
            if (!valido) {
                System.out.println("El teléfono es incorrecto.");
            }
        } while (!valido);
        return telefono;
    }

    private static String solicitarEmail() {
        String email;
        boolean valido;
        do {
            email = GetData.getString("Introduce el correo electronico: ");
            valido = Socio.validarEmail(email);
            if (!valido) {
                System.out.println("El correo electrónico es incorrecto");
            }
        } while (!valido);
        return email;
    }


}

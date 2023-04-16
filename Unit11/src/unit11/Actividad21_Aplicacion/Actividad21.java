package unit11.Actividad21_Aplicacion;

import Functions.GetData;
import unit11.Actividad20_Aplicacion.Cliente;

import java.io.*;
import java.util.ArrayList;

/*
    Repite la Actividad de aplicación 11.20, pero insertando los objetos Cliente en un objeto Lista para Object,
    como el definido en la Actividad 11 del tema 9.
 */
public class Actividad21 {
    private static final File FICHERO_CLIENTES = new File("src/unit11/Actividad21_Aplicacion/clientes.dat");
    private static Lista clientes = new Lista();
    public static void main(String[] args) {
        cargarClientes(); // Carga los clientes del fichero clientes.dat
        boolean exit = false;
        int userInput;

        while (!exit) {
            mostrarMenu();
            userInput = GetData.getInt("Introduzca una opción: ", 1, 5);
            switch (userInput) {
                case 1 -> añadirCliente();
                case 2 -> modificarCliente();
                case 3 -> eliminarCliente();
                case 4 -> listarClientes();
                case 5 -> exit = true;
            }
        }

        guardarClientes(); // Guarda los clientes en el fichero clientes.dat
    }

    private static void añadirCliente() {
        String nombre = GetData.getString("Introduzca el nombre del cliente: ");
        String telefono;
        do {
            telefono = GetData.getString("Introduzca el teléfono del cliente: ");
        } while (!Cliente.validarTelefono(telefono));

        clientes.insertarFinal(new Cliente(nombre, telefono));
        System.out.println("Cliente añadido.");
    }

    private static void modificarCliente() {
        if (clientes.size() == 0) {
            System.out.println("No hay clientes.");
            return;
        }

        int index = getIndexCliente();
        System.out.println("""
                1. Modificar nombre.
                2. Modificar teléfono.""");
        int userInput = GetData.getInt("Introduzca una opción: ", 1, 2);
        switch (userInput) {
            case 1 -> {
                String nombre = GetData.getString("Introduzca el nuevo nombre del cliente: ");
                Cliente cliente = (Cliente) clientes.get(index);
                cliente.setNombre(nombre);
            }
            case 2 -> {
                boolean telefonoValido;
                String telefono;
                do {
                    telefono = GetData.getString("Introduzca el nuevo teléfono del cliente: ");
                    telefonoValido = Cliente.validarTelefono(telefono);
                    if (!telefonoValido) {
                        System.out.println("El teléfono no es válido.");
                    }
                } while (!telefonoValido);
                Cliente cliente = (Cliente) clientes.get(index);
                cliente.setTelefono(telefono);
            }
        }
        System.out.println("Cliente modificado.");
    }

    private static void eliminarCliente() {
        if (clientes.size() == 0) {
            System.out.println("No hay clientes.");
            return;
        }

        int index = getIndexCliente();
        clientes.eliminar(index);
        System.out.println("Cliente eliminado.");
    }

    private static void listarClientes() {
        if (clientes.size() == 0) {
            System.out.println("No hay clientes.");
            return;
        }
        System.out.println("Lista de clientes:");
        int counter = 1;
        Cliente cliente;
        for (int i = 0; i < clientes.size(); i++) {
            cliente = (Cliente) clientes.get(i);
            System.out.println(counter++ + ". " + cliente);
        }
        System.out.println("--------------------");
    }






    private static int getIndexCliente() {
        int counter = 1;
        Cliente cliente;
        for (int i = 0; i < clientes.size(); i++) {
            cliente = (Cliente) clientes.get(i);
            System.out.println(counter++ + ". " + cliente.getNombre());
        }
        return GetData.getInt("Introduzca el número del cliente: ", 1, clientes.size()) -1;
    }

    private static void cargarClientes() {
        if (FICHERO_CLIENTES.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO_CLIENTES))) {
                clientes = (Lista) ois.readObject();
                System.out.println("Datos de clientes cargados.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los clientes.");
            }
        } else {
            System.out.println("Se creará el fichero de clientes.");
        }
    }

    private static void guardarClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO_CLIENTES))) {
            oos.writeObject(clientes);
            System.out.println("Datos de clientes guardados.");
        } catch (IOException e) {
            System.out.println("Error al guardar los clientes.");
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Añadir nuevo cliente.
                2. Modificar datos.
                3. Dar de baja cliente.
                4. Listar los clientes.
                5. Salir.""");
    }
}

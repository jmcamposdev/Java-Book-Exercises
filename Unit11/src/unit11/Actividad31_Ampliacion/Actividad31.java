package unit11.Actividad31_Ampliacion;

import Functions.GetData;

import java.io.*;
import java.time.LocalDate;

/*
    Se quieren mantener los datos de los clientes de un banco en un archivo binario.
    De cada cliente se guardará: DNI, nombre completo, fecha de nacimiento y saldo.
    Implementa una aplicación que arranque mostrando el menú:
    1. Alta cliente.
    2. Baja cliente.
    3. Listar clientes.
    4. Salir.
    Implementa la clase cliente con los atributos referidos.
    Los objetos Cliente irán insertados en un objeto Lista de tipo Object.
    Nada más arrancar la aplicación se leerá del archivo la lista de clientes.
    Cuando se dé de alta uno nuevo, se creará el objeto correspondiente y se insertará en la lista por orden de DNI.
    Para eliminar un cliente, se pedirá el DNI y se eliminará de la lista.
    Al listar los clientes, se mostrará el DNI, el nombre, el saldo y la edad de todos ellos, así como el saldo máximo, el mínimo y el saldo promedio del conjunto de los clientes.
    Al cerrar la aplicación, se guardará en el archivo la lista actualizada.
 */
public class Actividad31 {
    private static Lista listaClientes = new Lista();
    private static final File fileDatosClientes = new File("src/unit11/Actividad31_Ampliacion/datosClientes.dat");

    private static final int OPCION_ALTA = 1;
    private static final int OPCION_BAJA = 2;
    private static final int OPCION_LISTAR = 3;
    private static final int OPCION_SALIR = 4;
    public static void main(String[] args) {
        cargarDatosClientes();

        boolean salir = false;
        int userOption;
        do {
            System.out.println("1. Alta cliente.");
            System.out.println("2. Baja cliente.");
            System.out.println("3. Listar clientes.");
            System.out.println("4. Salir.");
            userOption = GetData.getInt("Introduce una opción: ", 1, 4);
            switch (userOption) {
                case OPCION_ALTA -> altaNuevoCliente();
                case OPCION_BAJA -> eliminarCliente();
                case OPCION_LISTAR -> listarClientes();
                case OPCION_SALIR -> {
                    salir = true;
                    guardarDatosClientes();
                }
            }
        } while (!salir);

    }

    private static void altaNuevoCliente () {
        String nombre = GetData.getString("Introduce el nombre del cliente: ");
        LocalDate fechaNacimiento = GetData.getFecha("Introduce la fecha de nacimiento del cliente: ");
        boolean dniValido;
        boolean dniDuplicado;
        String dni;
        do {
            dniDuplicado = false;
            dni = GetData.getString("Introduce el DNI del cliente: ");
            dniValido = Cliente.validarNIFCalc(dni);
            Cliente cliente;
            if (dniValido) {
                for(int i = 0; i < listaClientes.size() && !dniDuplicado; i++) {
                    cliente = (Cliente) listaClientes.get(i);
                    if (cliente.getDNI().equals(dni)) {
                        dniDuplicado = true;
                    }
                }
            }
            if (!dniValido) {
                System.out.println("El DNI introducido no es válido");
            } else if (dniDuplicado) {
                System.out.println("El DNI introducido ya existe");
            }
        } while (!dniValido || dniDuplicado);

        double saldo = GetData.getDouble("Introduce el saldo del cliente: ", 0, Double.MAX_VALUE);
        Cliente cliente = new Cliente(nombre, fechaNacimiento, dni, saldo);
        listaClientes.insertarFinal(cliente);
        listaClientes.sort();
    }

    private static void eliminarCliente() {
        boolean clienteEncontrado = false;
        String DNI = GetData.getString("Introduce el DNI del cliente a eliminar: ");
        Cliente cliente;
        for (int i = 0; i < listaClientes.size() && !clienteEncontrado; i++) {
            cliente = (Cliente) listaClientes.get(i);
            if (cliente.getDNI().equals(DNI)) {
                listaClientes.eliminar(i);
                clienteEncontrado = true;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("No se ha encontrado ningún cliente con ese DNI");
        } else {
            System.out.println("Cliente eliminado correctamente");
        }
    }

    private static void listarClientes() {
        if (listaClientes.size() == 0) {
            System.out.println("No hay clientes en la lista");
        } else {
            double saldoMaximo = 0;
            double saldoMinimo = Double.MAX_VALUE;
            double saldoTotal = 0;
            for (int i = 0; i < listaClientes.size(); i++) {
                Cliente cliente = (Cliente) listaClientes.get(i);
                System.out.println(cliente);
                if (cliente.getSaldo() > saldoMaximo) {
                    saldoMaximo = cliente.getSaldo();
                }
                if (cliente.getSaldo() < saldoMinimo) {
                    saldoMinimo = cliente.getSaldo();
                }
                saldoTotal += cliente.getSaldo();
            }
            System.out.println("Saldo máximo: " + saldoMaximo);
            System.out.println("Saldo mínimo: " + saldoMinimo);
            System.out.printf("Saldo medio: %.2f\n",saldoTotal / listaClientes.size());
        }
    }


    private static void cargarDatosClientes() {
        if (fileDatosClientes.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileDatosClientes))) {
                listaClientes = (Lista) ois.readObject();
                System.out.println("Se han cargado" + listaClientes.size() + " clientes del archivo de datos de clientes");
            } catch (Exception e) {
                System.out.println("Error al leer el archivo de datos de clientes");
            }
        } else {
            System.out.println("Se va a crear un nuevo archivo de datos de clientes");
        }
    }
    private static void guardarDatosClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileDatosClientes))) {
            oos.writeObject(listaClientes);
            System.out.println("Se han guardado" + listaClientes.size() + " clientes en el archivo de datos de clientes");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos de los clientes");
        }
    }
}

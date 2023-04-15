package unit10.Actividad31_Ampliacion;

import Functions.GetData;

import java.io.BufferedReader;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

/*
    Se pretende mantener los datos de los clientes de un banco en un archivo de texto.
    De cada cliente se guardará: DNI, nombre completo, fecha de nacimiento y saldo.
    Implementa una aplicación que arranque mostrando en el menú:
    1. Alta cliente.
    2. Baja cliente.
    3. Listar clientes.
    4. Salir.
    Implementa la clase cliente con los atributos referidos.
    Nada más arrancar la aplicación se leerán del archivo los datos de los clientes construyendo los objetos Cliente de todos ellos,
    que se irán insertando en una tabla de clientes.
    Cuando se dé de alta uno nuevo, se creará el objeto correspondiente y se insertará en la tabla por orden de DNI
    Para eliminar un cliente, se pedirá el DNI y se eliminará de la tabla.
    Al listar los clientes, se mostrará el DNI, el nombre, el saldo y la edad de todos ellos, así como el saldo máximo,
    el mínimo y el promedio del conjunto de los clientes.
    Al cerrar la aplicación, se guardarán en el archivo los datos actualizados con el mismo formato.

    Está realizado con Serializable
 */
public class Actividad31 {
    private static final ArrayList<Cliente> clientes = new ArrayList<>();
    private static final File fileDatosClientes = new File("src/unit10/Actividad31_Ampliacion/datosClientes.txt");

    private static final int OPCION_ALTA = 1;
    private static final int OPCION_BAJA = 2;
    private static final int OPCION_LISTAR = 3;
    private static final int OPCION_SALIR = 4;
    public static void main(String[] args) {
        boolean datosCardadosExistentes = true;
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileDatosClientes))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosCliente = linea.split(";");
                LocalDate fechaNacimiento = LocalDate.parse(datosCliente[1]);
                Cliente cliente = new Cliente(datosCliente[0], fechaNacimiento, datosCliente[2], Double.parseDouble(datosCliente[3]));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo de datos de clientes");
            datosCardadosExistentes = false;
        }

        if (datosCardadosExistentes) {
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


    }

    private static void altaNuevoCliente () {
        String nombre = GetData.getString("Introduce el nombre del cliente: ");
        LocalDate fechaNacimiento = GetData.getFecha("Introduce la fecha de nacimiento del cliente: ");
        boolean dniValido;
        boolean dniDuplicado = false;
        String dni;
        do {
            dni = GetData.getString("Introduce el DNI del cliente: ");
            dniValido = Cliente.validarNIFCalc(dni);
            if (dniValido) {
                for(int i = 0; i < clientes.size() && !dniDuplicado; i++) {
                    if (clientes.get(i).getDNI().equals(dni)) {
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
        clientes.add(cliente);
        clientes.sort(Cliente::compareTo);
    }

    private static void eliminarCliente() {
        boolean clienteEncontrado = false;
        String DNI = GetData.getString("Introduce el DNI del cliente a eliminar: ");
        for (int i = 0; i < clientes.size() && !clienteEncontrado; i++) {
            if (clientes.get(i).getDNI().equals(DNI)) {
                clientes.remove(i);
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
        if (clientes.size() == 0) {
            System.out.println("No hay clientes en la lista");
        } else {
            double saldoMaximo = 0;
            double saldoMinimo = Double.MAX_VALUE;
            double saldoTotal = 0;
            for (Cliente cliente : clientes) {
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
            System.out.println("Saldo medio: " + saldoTotal / clientes.size());
        }
    }


    private static void guardarDatosClientes() {
        try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(fileDatosClientes))) {
            for (Cliente cliente : clientes) {
                pw.println(cliente.getNombre()+";"+cliente.getFechaNacimiento()+";"+cliente.getDNI()+";"+cliente.getSaldo());
            }
        } catch (Exception e) {
            System.out.println("Error al guardar los datos de los clientes");
        }
    }
}

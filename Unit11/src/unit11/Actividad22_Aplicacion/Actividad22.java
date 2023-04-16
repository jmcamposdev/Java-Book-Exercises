package unit11.Actividad22_Aplicacion;

import Functions.GetData;
import unit11.Actividad21_Aplicacion.Lista;

import java.io.*;

/*
    Implementa una aplicación que gestione los empleados de un banco.
    Para ello se definirá la clase Empleado con los atributos dni, nombre y sueldo.
    Los empleados se guardarán en un objeto de la clase Lista para objetos de la clase Object.
    La aplicación cargará en la memoria, al arrancar, la lista de empleados desde el archivo binario empleados.dat y
    mostrará un menú con las siguientes opciones:
    1. Alta empleado;
    2. Baja empleado;
    3. Mostrar datos empleados;
    4. Listar empleados,
    5. Salir.
    Al pulsar 5, se grabará en el disco la lista actualizada y terminará el programa.
 */
public class Actividad22 {
    private static final File FICHERO_EMPLEADOS = new File("src/unit11/Actividad22_Aplicacion/empleados.dat");
    private static Lista listaEmpleados = new Lista();
    public static void main(String[] args) {
        cargarEmpleados(); // Carga los empleados del fichero empleados.dat
        boolean exit = false;
        int userInput;

        while (!exit) {
            mostrarMenu();
            userInput = GetData.getInt("Introduzca una opción: ", 1, 5);
            switch (userInput) {
                case 1 -> añadirEmpleado();
                case 2 -> eliminarEmpleado();
                case 3 -> mostrarDatosEmpleado();
                case 4 -> listarEmpleados();
                case 5 -> exit = true;
            }
        }

        guardarEmpleados(); // Guarda los empleados en el fichero empleados.dat
    }




    private static void añadirEmpleado() {
        String dni;
        do {
            dni = GetData.getString("Introduzca el DNI del empleado: ");
        } while (!Empleado.validarNIFCalc(dni));
        String nombre = GetData.getString("Introduzca el nombre del empleado: ");
        double sueldo = GetData.getDouble("Introduzca el sueldo del empleado: ");

        listaEmpleados.insertarFinal(new Empleado(dni, nombre, sueldo));
        System.out.println("Empleado añadido.");
    }

    private static void eliminarEmpleado() {
        if (listaEmpleados.size() == 0) {
            System.out.println("No hay empleados.");
            return;
        }

        int index = getIndexEmpleado();
        listaEmpleados.eliminar(index);
        System.out.println("Empleado eliminado.");
    }

    private static void mostrarDatosEmpleado() {
        if (listaEmpleados.size() == 0) {
            System.out.println("No hay empleados.");
            return;
        }

        int index = getIndexEmpleado();
        Empleado empleado = (Empleado) listaEmpleados.get(index);
        System.out.println(empleado);
    }

    private static void listarEmpleados() {
        if (listaEmpleados.size() == 0) {
            System.out.println("No hay empleados.");
            return;
        }

        Empleado empleado;
        int counter = 1;
        for (int i = 0; i < listaEmpleados.size(); i++) {
            empleado = (Empleado) listaEmpleados.get(i);
            System.out.println(counter++ + ". " + empleado.getNombre());
        }
    }

    private static void cargarEmpleados() {
        if (FICHERO_EMPLEADOS.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO_EMPLEADOS))) {
                listaEmpleados = (Lista) ois.readObject();
                System.out.println("Empleados cargados.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los empleados del fichero " + FICHERO_EMPLEADOS.getName() + ".");
            }
        } else {
            System.out.println("Se creará el fichero " + FICHERO_EMPLEADOS.getName() + " al salir del programa.");
        }
    }

    private static void guardarEmpleados() {
        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(FICHERO_EMPLEADOS))) {
            ois.writeObject(listaEmpleados);
            System.out.println("Empleados guardados.");
        } catch (IOException e) {
            System.out.println(e.getMessage() );
            System.out.println("Error al guardar los empleados en el fichero " + FICHERO_EMPLEADOS.getName() + ".");
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Añadir empleado.
                2. Eliminar empleado.
                3. Mostrar datos empleado.
                4. Listar empleados.
                5. Salir.""");
    }

    private static int getIndexEmpleado() {
        Empleado empleado;
        int counter = 1;
        for (int i = 0; i < listaEmpleados.size(); i++) {
            empleado = (Empleado) listaEmpleados.get(i);
            System.out.println(counter++ + ". " + empleado.getNombre());
        }

        return GetData.getInt("Introduzca el número del empleado: ", 1, listaEmpleados.size()) - 1;
    }
}

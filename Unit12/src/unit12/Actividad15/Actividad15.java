package unit12.Actividad15;

import Functions.GetData;

import java.io.*;
import java.util.HashMap;

/*
    Implementar una aplicación para gestionar las existencias de una tienda de repuestos de automóviles.
    Cada producto se identifica por un código alfanumérico.
    La aplicación permitirá dar de alta o de baja productos y actualizar el número de unidades en stock de cada uno de ellos.
    Los datos se mantendrán en un fichero, que deberá actualizarse al cerrar el programa.
 */
public class Actividad15 {
    private static HashMap<String, Integer> existencias = new HashMap<>();
    private static final File fichero = new File("./src/unit12/Actividad15/existencias.dat");
    public static void main(String[] args) {
        cargarExistencias();

        boolean exit = false;
        int userOption;

        while (!exit) {
            mostrarMenu();
            userOption = GetData.getInt("Ingrese una opción (1 - 5): ", 1, 5);
            switch (userOption) {
                case 1 -> añadirProducto();
                case 2 -> eliminarProducto();
                case 3 -> actualizarExistencias();
                case 4 -> mostrarExistencias();
                case 5 -> exit = true;
            }
        }

        guardarExistencias();
    }

    private static void guardarExistencias() {
        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(fichero))) {
            ois.writeObject(existencias);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarExistencias() {
        if (existencias.isEmpty()) {
            System.out.println("No hay productos.");
        } else {
            System.out.println("Código\tExistencias");
            for (String codigo : existencias.keySet()) {
                System.out.println(codigo + "\t" + existencias.get(codigo));
            }
        }
    }

    private static void actualizarExistencias() {
        String codigo = GetData.getString("Ingrese el código del producto: ");
        if (existencias.containsKey(codigo)) {
            int cantidad = GetData.getInt("Ingrese la cantidad de existencias: ");
            existencias.put(codigo, cantidad);
            System.out.println("Existencias actualizadas.");
        } else {
            System.out.println("El producto no existe.");
        }
    }

    private static void eliminarProducto() {
        String codigo = GetData.getString("Ingrese el código del producto: ");
        if (existencias.containsKey(codigo)) {
            existencias.remove(codigo);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("El producto no existe.");
        }
    }

    private static void añadirProducto() {
        String codigo = GetData.getString("Ingrese el código del producto: ");
        if (existencias.containsKey(codigo)) {
            System.out.println("El producto ya existe.");
        } else {
            int cantidad = GetData.getInt("Ingrese la cantidad de existencias: ");
            existencias.put(codigo, cantidad);
            System.out.println("Producto añadido.");
        }
    }

    private static void cargarExistencias () {
        if (fichero.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                existencias = (HashMap<String, Integer>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                fichero.createNewFile();
                System.out.println("Fichero creado.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Dar de alta un producto
                2. Dar de baja un producto
                3. Actualizar existencias
                4. Mostrar existencias
                5. Salir""");
    }
}

package unit11.Actividad18_Aplicacion;

import Functions.GetData;

import java.io.*;
import java.util.HashSet;

/*
    Un libro de firmas es útil para recoger los nombres de todas las personas que han pasado por un determinado lugar.
    Crea una aplicación que permita mostrar el libro de firmas o insertar un nuevo nombre (comprobando que no se encuentre repetido)
    usando el fichero binario firmas.dat.
 */
public class Actividad18 {
    private static final File fichero = new File("src/unit11/Actividad18_Aplicacion/firmas.dat");
    private static HashSet<String> firmas = new HashSet<>();
    public static void main(String[] args) {
        int userOption;
        boolean exit = false;
        cargarFirmas();

        while (!exit) {
            mostrarMenu();
            userOption = GetData.getInt("Introduce una opción: ", 1, 3);
            switch (userOption) {
                case 1 -> mostrarFirmas();
                case 2 -> añadirFirma();
                case 3 -> exit = true;
                default -> System.out.println("Opción incorrecta.");
            }
        }

        guardarFirmas();

    }

    private static void guardarFirmas() {
        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(fichero))) {
            ois.writeObject(firmas);
            System.out.println("Firmas guardadas.");
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero de firmas.");
        }
    }

    private static void añadirFirma() {
        String firma = GetData.getString("Introduce la firma: ");
        if (firmas.add(firma)) {
            System.out.println("Firma añadida.");
        } else {
            System.out.println("La firma ya existe.");
        }
    }

    private static void mostrarFirmas() {
        if (firmas.isEmpty()) {
            System.out.println("No hay firmas.");
        } else {
            int counter = 1;
            System.out.println("Firmas:");
            for (String firma : firmas) {
                System.out.println(counter++ + ". " + firma);
            }
            System.out.println("-----------------");
        }
    }

    private static void cargarFirmas() {
        if (fichero.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                firmas = (HashSet<String>) ois.readObject();
                System.out.println("Firmas cargadas.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar el fichero de firmas.");
            }
        } else {
            System.out.println("El fichero de firmas no existe. Se creará uno nuevo.");
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Mostrar libro de firmas
                2. Añadir firma
                3. Salir""");
    }
}

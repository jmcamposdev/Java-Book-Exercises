package unit12.Actividad40_Ampliacion;

import Functions.GetData;
import unit12.Actividad14.Registro;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.TreeSet;

/*
    Amplía la Actividad 14, de forma que se gestionen los registros de temperatura de diferentes días en la misma aplicación.
    Para ello, implementa un mapa cuyas entradas tendrán como clave la fecha y como valor el conjunto con los registros de un dia.
    Implementa también un programa que gestione los registros del día actual y permita visualizar los de un día cualquiera, junto con sus estadísticas.
    Al arrancar el programa se cargará en memoria el mapa a partir del fichero correspondiente y, al terminar, se volverá a guardar actualizado.
 */
public class Actividad40 {
    private static final File fileDatosTemperaturas = new File("src/unit12/Actividad40_Ampliacion/datosTemperaturas.dat");
    private static HashMap<LocalDate, TreeSet<Registro>> mapaTemperaturas = new HashMap<>();
    public static void main(String[] args) {
        cargarDatosTemperaturas();

        boolean exit = false;
        int userOption;

        while (!exit) {
            mostrarMenu();
            userOption = GetData.getInt("Introduce una opción: ", 1, 4);
            switch (userOption) {
                case 1 -> altaTemperatura();
                case 2 -> listarTemperaturas();
                case 3 -> {
                    exit = true;
                    guardarDatosTemperaturas();
                }
            }
        }
    }

    private static void guardarDatosTemperaturas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileDatosTemperaturas))) {
            oos.writeObject(mapaTemperaturas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listarTemperaturas() {
        LocalDate fecha = GetData.getFecha("Introduce la fecha: ");
        if (mapaTemperaturas.containsKey(fecha)) {
            System.out.println("Temperaturas del día " + fecha);
            for (Registro registro : mapaTemperaturas.get(fecha)) {
                System.out.println(registro);
            }
        } else {
            System.out.println("No hay datos para esa fecha.");
        }
    }

    private static void altaTemperatura() {
        LocalDate fecha = GetData.getFecha("Introduce la fecha: ");
        double temperatura = GetData.getDouble("Introduce la temperatura: ");
        Registro registro = new Registro(temperatura);
        if (mapaTemperaturas.containsKey(fecha)) {
            mapaTemperaturas.get(fecha).add(registro);
        } else {
            TreeSet<Registro> registros = new TreeSet<>();
            registros.add(registro);
            mapaTemperaturas.put(fecha, registros);
        }
    }

    private static void cargarDatosTemperaturas () {
        if (fileDatosTemperaturas.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileDatosTemperaturas))) {
                mapaTemperaturas = (HashMap<LocalDate, TreeSet<Registro>>) ois.readObject();
                System.out.println("Datos cargados correctamente.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                fileDatosTemperaturas.createNewFile();
                System.out.println("Archivo creado correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Alta de temperatura.
                2. Listar temperaturas.
                3. Salir.""");
    }
}

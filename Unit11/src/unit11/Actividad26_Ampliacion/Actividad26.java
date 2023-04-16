package unit11.Actividad26_Ampliacion;

import Functions.GetData;

import java.io.*;
import java.time.LocalDate;
import java.util.HashSet;

/*
    Se quiere mantener un registro de las temperaturas máximo y minima diaria en una estación meteorológica.
    Define la clase Registro con los atributos tempMax, tempMiny fecha, cuyos valores se introducen por teclado.
    Los dos primeros como valores double El tercero como cadena con el formato dd/mm/aaaa.
    Implementa un programa que yo cestre por pantalla un menú con las opciones:
    1. Nuevo registro;
    2. Mostrar historial
    3. Mostrar estadísticas
    4. Salir.

    La opción 2 mostrará en cuatro columnas las fechas los valores máximo y mínimo diario y la variación (la diferencia entre el máximo y el mi nimo) diaria.
    La opción 3 mostrará los valores medios, máximos y minimos de las temperaturas máximas, de las mínimas y de las variaciones diarias.
    Todos los registros se insertarán en una tabla, que se guardará en un archivo binario de forma que, al arrancar la aplicación,
    se leerá del archivo y al salir de ella (opción 4) se volverá a guardar actualizada.
 */
public class Actividad26 {
    private static final File FICHERO_REGISTROS = new File("src/unit11/Actividad26_Ampliacion/registros.dat");
    private static HashSet<Registro> registros = new HashSet<>();
    public static void main(String[] args) {
        cargarRegistros();
        boolean exit = false;
        int userOption;

        while (!exit) {
            mostrarMenu();
            userOption = GetData.getInt("Introduce una opción: ", 1, 4);
            switch (userOption) {
                case 1 -> añadirRegistro();
                case 2 -> mostrarHistorial();
                case 3 -> mostrarEstadisticas();
                case 4 -> exit = true;
                default -> System.out.println("Opción incorrecta");
            }
        }

        guardarRegistros(); // Guardamos los registros al salir

    }




    private static void añadirRegistro() {
        double tempMin = GetData.getDouble("Introduce la temperatura mínima: ");
        double tempMax = GetData.getDouble("Introduce la temperatura máxima: ", tempMin);
        LocalDate fecha = GetData.getFecha("Introduce la fecha (dd/mm/aaaa): ");

        if (registros.add(new Registro(tempMax, tempMin, fecha))) {
            System.out.println("Registro añadido correctamente");
        } else {
            System.out.println("Ya existe un registro con esa fecha");
        }
    }

    private static void mostrarHistorial() {
        if (registros.isEmpty()) {
            System.out.println("No hay registros");
            return;
        }

        System.out.println("Fecha\t\tTemp. máxima\tTemp. mínima\tVariación");
        for (Registro registro : registros) {
            System.out.println(registro);
        }
    }

    private static void mostrarEstadisticas() {
        if (registros.isEmpty()) {
            System.out.println("No hay registros");
            return;
        }

        double tempMaxMedia = 0;
        double tempMinMedia = 0;
        double variacionMedia = 0;
        double tempMaxMax = Double.MIN_VALUE;
        double tempMinMin = Double.MAX_VALUE;
        double variacionMax = Double.MIN_VALUE;

        for (Registro registro : registros) {
            tempMaxMedia += registro.getTempMax();
            tempMinMedia += registro.getTempMin();
            variacionMedia += registro.getTempMax() - registro.getTempMin();

            if (registro.getTempMax() > tempMaxMax) {
                tempMaxMax = registro.getTempMax();
            }

            if (registro.getTempMin() < tempMinMin) {
                tempMinMin = registro.getTempMin();
            }

            if (registro.getTempMax() - registro.getTempMin() > variacionMax) {
                variacionMax = registro.getTempMax() - registro.getTempMin();
            }
        }

        tempMaxMedia /= registros.size();
        tempMinMedia /= registros.size();
        variacionMedia /= registros.size();

        System.out.println("Temperatura máxima media: " + tempMaxMedia);
        System.out.println("Temperatura mínima media: " + tempMinMedia);
        System.out.println("Variación media: " + variacionMedia);
        System.out.println("Temperatura máxima máxima: " + tempMaxMax);
        System.out.println("Temperatura mínima mínima: " + tempMinMin);
        System.out.println("Variación máxima: " + variacionMax);
    }
    private static void cargarRegistros() {
        if (FICHERO_REGISTROS.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO_REGISTROS))) {
                registros = (HashSet<Registro>) ois.readObject();
                System.out.println("Registros cargados correctamente");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer el fichero");
            }
        } else {
            System.out.println("No existe el fichero de registros, se creará uno nuevo al salir del programa.");
        }
    }

    private static void guardarRegistros() {
        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(FICHERO_REGISTROS))) {
            ois.writeObject(registros);
            System.out.println("Registros guardados correctamente");
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero");
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Nuevo registro
                2. Mostrar historial
                3. Mostrar estadísticas
                4. Salir
                """);
    }
}

package unit11.Actividad19_Aplicacion;

/*
    Por motivos puramente estadísticos se desea llevar constancia del número de llamadas recibidas cada día en una oficina.
    Para ello, al terminar cada jornada laboral se guarda dicho número al final de un archivo binario.
    Implementa una aplicación con un menú, que nos permita añadir el número correspondiente cada día y
    ver la lista completa en cualquier momento.
 */

import Functions.GetData;

import java.io.*;
import java.util.ArrayList;

public class Actividad19 {
    private static final int OPCION_AÑADIR_LLAMADA = 1;
    private static final int OPCION_LISTAR_LLAMADAS = 2;
    private static final int OPCION_SALIR = 3;
    private static final File fichero = new File("src/unit11/Actividad19_Aplicacion/llamadas.dat");
    private static ArrayList<Integer> llamadas = new ArrayList<>();
    public static void main(String[] args) {
        cargarLlamadas(); // Cargamos el fichero si existe
        boolean exit = false;
        int userOption;

        while (!exit) {
            mostrarMenu();
            userOption = GetData.getInt("Elige una opción: ", 1, 3);
            switch (userOption) {
                case OPCION_AÑADIR_LLAMADA -> {
                    int llamadasDia = GetData.getInt("Introduce el número de llamadas del día: ",0);
                    llamadas.add(llamadasDia);
                }
                case OPCION_LISTAR_LLAMADAS -> {
                    if (llamadas.isEmpty()) {
                        System.out.println("No hay llamadas");
                    } else {
                        System.out.println("Llamadas recibidas:");
                        for (Integer llamada : llamadas) {
                            System.out.println(llamada);
                        }
                        System.out.println("-----------------");
                    }
                }
                case OPCION_SALIR -> exit = true;
            }
        }

        guardarLlamadas();

    }

    private static void guardarLlamadas() {
        try (ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(fichero))) {
            flujoSalida.writeObject(llamadas);
            System.out.println("Se han guardado las llamadas en el fichero llamadas.dat");
        } catch (IOException ex) {
            System.out.println("Error al guardar el fichero");
        }
    }

    private static void cargarLlamadas() {
        if (fichero.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                llamadas = (ArrayList<Integer>) ois.readObject();
                System.out.println("Se han cargado las llamadas del fichero llamadas.dat");
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Error al cargar el fichero");
            }
        } else {
            System.out.println("Se ha creado el fichero llamadas.dat para guardar las llamadas");
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Añadir llamada
                2. Mostrar llamadas
                3. Salir""");
    }
}

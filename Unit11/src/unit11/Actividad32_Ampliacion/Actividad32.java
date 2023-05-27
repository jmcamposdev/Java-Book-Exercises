package unit11.Actividad32_Ampliacion;

import Functions.GetData;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/*
    Con la clase Llamada de la Actividad 31 del Tema 9 crea un registro de las llamadas efectuada en una centralita,
    que se guardarán en el archivo binario centralita.dat. Al arrancar la aplicación se leerán los datos del archivo
    y a continuación se mostrará el menú:
    1. Nuevo registro de Llamada
    2. Listar las llamadas de un número de teléfono
    3. Listas todas las llamadas
    4. Salir

    En el apartado 1 las fechas y horas se introducirán como cadenas en formato dd/MM/yyyy y hh:mm respectivamente.
    En los apartados 2 y 3 mostrará el número de teléfono del titular el del interlocutor, la fecha y hora de inicio
    y la duración en minutos de cada llamada. Los registros se insertarán en una tabla por su orden natural.
    Al terminar la aplicación se guardarán la tabla actualizada en el mismo archivo.
 */
public class Actividad32 {
    private static final String FICHERO = "src/unit11/Actividad32_Ampliacion/centralita.dat";
    private static ArrayList<Llamada> llamadas = new ArrayList<>();
    public static void main(String[] args) {
        cargarLlamadas();
        
        boolean exit = false;
        int option = 0;
        
        while (!exit) {
            menu();
            option = GetData.getInt("Introduce una opción: ", 1, 4);
            switch (option) {
                case 1 -> llamadas.add(getLlamada());
                case 2 -> {
                    String numero = GetData.getString("Introduce el número de teléfono: ");
                    mostrarLlamadasDeNumero(numero);
                }
                case 3 -> llamadas.forEach(System.out::println);
                case 4 -> {
                    exit = true;
                    guardarLlamadas();
                }
                default -> System.out.println("Opción no válida");
            }
        }
    }
    
    private static Llamada getLlamada() {
        String numero = GetData.getString("Introduce el número de teléfono: ");
        String numeroInterlocutor = GetData.getString("Introduce el número de teléfono del interlocutor: ");
        boolean esSaliente = GetData.getBoolean("¿Es saliente? (si/no): ");
        LocalDateTime fechaInicio = GetData.getDateTime("Introduce la fecha de la llamada: ");
        LocalDateTime fechaFin = GetData.getDateTime("Introduce la fecha de la llamada: ");
        ZonaTarifa zonaTarifa = getZonaTarifa();
        
        return new Llamada(numero, numeroInterlocutor, esSaliente, fechaInicio, fechaFin, zonaTarifa);
    }

    private static ZonaTarifa getZonaTarifa() {
        for (ZonaTarifa zonaTarifa : ZonaTarifa.values()) {
            System.out.println(zonaTarifa.ordinal() + ". " + zonaTarifa);
        }
        return ZonaTarifa.values()[GetData.getInt("Introduce la zona tarifa: ", 0, ZonaTarifa.values().length - 1)];
    }

    private static void mostrarLlamadasDeNumero(String numero) {
        ArrayList<Llamada> llamadasRealizadas = new ArrayList<>();
        for (Llamada llamada : llamadas) {
            if (llamada.getNumeroTelefonoCliente().equals(numero)) {
                llamadasRealizadas.add(llamada);
            }
        }

        if (llamadasRealizadas.isEmpty()) {
            System.out.println("No hay llamadas realizadas");
        } else {
            llamadasRealizadas.forEach(System.out::println);
        }
    }

    private static void menu() {
        System.out.println("""
                1. Nuevo registro de Llamada
                2. Listar las llamadas de un número de teléfono
                3. Listas todas las llamadas
                4. Salir""");
    }

    private static void cargarLlamadas() {
        if (new File(FICHERO).exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {
                llamadas = (ArrayList<Llamada>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar las llamadas");
            }
        }
    }

    private static void guardarLlamadas() {
        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            ois.writeObject(llamadas);
        } catch (IOException e) {
            System.out.println("Error al guardar las llamadas");
        }
    }
}

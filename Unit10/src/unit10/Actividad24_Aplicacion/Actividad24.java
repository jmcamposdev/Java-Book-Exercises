package unit10.Actividad24_Aplicacion;

import Functions.GetData;
import java.io.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/*
    Implementa una aplicación que mantenga un registro de las temperaturas máxima y mínima diarias medidas en una estación meteorológica.
    Los datos se guardarán en un archivo de texto con el siguiente formato:
    Fecha           Temperatura máxima      Temperatura mínima
    2020-01-15      12                      -1
    2020-01-16      15                      2

    Al arrancar la aplicación aparecerá un menú con las opciones:
    1. Registrar nueva temperatura.
    2. Mostrar historial de registros.
    3. Salir.
    El historial de registros mostrará todos los datos registrados junto con el máximo valor
    de las temperaturas máximas y el mínimo de las temperaturas mínimas.
 */
public class Actividad24 {
    public static final int OPCION_REGISTRAR_TEMPERATURA = 1;
    public static final int OPCION_HISTORIAL_REGISTROS = 2;
    public static final int OPCION_SALIR_PROGRAMA = 3;

    public static void main(String[] args) {
        boolean salirPrograma = false;
        File fileRegistros = new File("./src/unit10/Actividad24_Aplicacion/temperaturas.txt");
        ArrayList<Registro> registros = new ArrayList<>();
        if (!fileRegistros.exists() || !obtenerDatosFichero(fileRegistros, registros)) {
            System.out.println("El fichero \"temperaturas.txt\" no existe y es necesario para la ejecución del programa");
        } else {
            while (!salirPrograma) {
                System.out.println("""
                        1. Registrar nueva Temperatura
                        2. Mostrar historial de Registros
                        3. Salir""");
                int userOption = GetData.getInt("Ingrese una opción (1 - 3): ",1,3);
                System.out.println(userOption);
                switch (userOption) {
                    case OPCION_REGISTRAR_TEMPERATURA -> {
                        LocalDate fecha = GetData.getFecha("Ingrese la Fecha (yyyy/MM/dd): ");
                        int temperaturaMaxima = GetData.getInt("Ingrese la Temperatura Máxima: ");
                        int temperaturaMinima;
                        do {                            
                            temperaturaMinima = GetData.getInt("Ingrese la Temperatura Minima: ");
                            if (temperaturaMinima > temperaturaMaxima) {
                                System.out.println("La Temperatura Mínima no puede ser superior a la Máxima");
                            }
                        } while (temperaturaMinima > temperaturaMaxima);
                        registros.add(new Registro(fecha,temperaturaMaxima,temperaturaMinima));
                        try (PrintWriter pw = new PrintWriter(new FileWriter(fileRegistros, true))) {
                            pw.println(fecha+" "+temperaturaMaxima+" "+temperaturaMinima);
                        } catch (IOException e) {
                            System.out.println("No se ha podido acceder al fichero para la escritura");
                        }
                    }
                    case OPCION_HISTORIAL_REGISTROS -> {
                        if (registros.isEmpty()) {
                            System.out.println("No poseemos registros de temperaturas.");
                        } else {
                            int temperaturaMaximaHistorica = registros.get(0).getTemperaturaMaxima();
                            int temperaturaMinimaHistorica = registros.get(0).getTemperaturaMinima();
                            System.out.println("Los registros de temperatura son : ");
                            for (Registro registro : registros) {
                                System.out.print(registro+"\n");
                                if (registro.getTemperaturaMaxima() > temperaturaMaximaHistorica) {
                                    temperaturaMaximaHistorica = registro.getTemperaturaMaxima();
                                }
                                if (registro.getTemperaturaMinima() < temperaturaMinimaHistorica) {
                                    temperaturaMinimaHistorica = registro.getTemperaturaMinima();
                                }
                            }
                            System.out.println("La temperatura Máxima Histórica es: "+ temperaturaMaximaHistorica);
                            System.out.println("La temperatura Mínima Histórica es: "+ temperaturaMinimaHistorica);
                        }
                    }
                    case OPCION_SALIR_PROGRAMA -> salirPrograma = true;
                }
            }
            System.out.println("Se ha guardado todo los datos correctamente");
        }
    }

    public static boolean obtenerDatosFichero (File fileRegistros, ArrayList<Registro> registros) {
        boolean datosObtenidos = false;
        try (Scanner sc = new Scanner(fileRegistros)) {
            String[] fechaString;
            LocalDate fecha;
            int temperaturaMaxima;
            int temperaturaMinima;
            sc.nextLine();// Pasamos la Cabecera
            while (sc.hasNext()) {
                fechaString = sc.next().split("-");
                fecha = LocalDate.of(Integer.parseInt(fechaString[0]),Integer.parseInt(fechaString[1]),Integer.parseInt(fechaString[2])); // Convertimos a LocalDate
                // Obtenemos las Temperaturas Maxima y Mínima
                temperaturaMaxima = Integer.parseInt(sc.next());
                temperaturaMinima = Integer.parseInt(sc.next());
                // Añadimos el registro al ArrayList
                registros.add(new Registro(fecha,temperaturaMaxima,temperaturaMinima));
            }
            datosObtenidos = true;
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no se ha encontrado o no se puede acceder a él");
        }
        return datosObtenidos;
    }

}

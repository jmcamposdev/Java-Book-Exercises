package unit11.Actividad30_Ampliacion;

import Functions.GetData;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

/*
    Con la clase jornada de la Actividad 28 del Tema 9 implementa una aplicación
    que gestione una lista con las jornadas de los trabajadores, controlando las
    entradas y salidas ()lo que comúnmente se llama fichar). El programa pedirá
    el DNI dul usuario. A continuación presentará un menú:
    1. Entrada
    2. Salida
    Al elegir la opción se leerá la fecha y hora, que se asignará al atributo correspondiente.
    Con esta información se creará un resgistro  de la jornada. La aplicación terminará cuando
    se introduzca como DNI un número clave que solo conoce un directivo responsable. Los registros
    se insertarán según el orden natural descrito en la Actividad, en una tabla redimensionable.
    Que se grabará en disco al finalizar la aplicación y se volverá a cargar al arrancar el día siguiente.
 */
public class Main {
    private static final String DNI_DIRECTIVO = "12345678A";
    private static final String FICHERO = "src/unit11/Actividad30_Ampliacion/jornadas.dat";
    private static HashSet<Jornada> jornadas = new HashSet<>();

    // Variables de Swich
    public static void main(String[] args) {
        boolean exit = false;
        String userDni = "";

        if (new File(FICHERO).exists()) {
            cargarJornadas();
        }
        while (!exit) {
            userDni = getDNI(); // Pedir DNI
            if (!userDni.equals(DNI_DIRECTIVO)) { // Si el DNI no es el del Directivo
                if (jornadas.contains(new Jornada(userDni))) { // Si el DNI ya ha fichado
                    System.out.println("Ya has fichado hoy"); // Mensaje de error
                } else { // Si el DNI no ha fichado
                    System.out.println("Bienvenido trabajador"); // Saludo
                    entrada(userDni); // Entrada
                }
            } else { // Si el DNI es el del Directivo
                exit = true;
                if (jornadas.size() > 0) {
                    guardarJornadas();
                }
            }
        }
    }


    private static void entrada(String dniTrabajador) {
        if (jornadas.contains(dniTrabajador)) {
            System.out.println("Ya has fichado hoy");
        } else {
            LocalDate fecha = LocalDate.now(); // Fecha actual
            LocalTime horaEntrada = getHora("Introduce la hora de entrada (hh:mm): "); // Hora de entrada
            LocalTime horaSalida = null;
            do {
                horaSalida = getHora("Introduce la hora de salida (hh:mm): "); // Hora de salida
                if (horaSalida.isBefore(horaEntrada)) {
                    System.out.println("La hora de salida debe ser posterior a la de entrada");
                }
                if (horaSalida.equals(horaEntrada)) {
                    System.out.println("La hora de salida no puede ser igual a la de entrada");
                }
            } while (horaSalida.isBefore(horaEntrada) || horaSalida.equals(horaEntrada));
            jornadas.add(new Jornada(dniTrabajador, fecha, horaEntrada, horaSalida));
        }
    }

    private static void modificarJornada(String dniTrabajador) {


    }

    private static LocalTime getHora(String message) {
        LocalTime hora = null;
        do {
            String horaString = GetData.getString(message);
            if (horaString.matches("\\d{2}:\\d{2}")) {
                String[] horaArray = horaString.split(":");
                int horaInt = Integer.parseInt(horaArray[0]);
                int minutoInt = Integer.parseInt(horaArray[1]);
                if (horaInt >= 0 && horaInt <= 23 && minutoInt >= 0 && minutoInt <= 59) {
                    hora = LocalTime.of(horaInt, minutoInt);
                } else {
                    System.out.println("La hora debe estar entre 0 y 23 y los minutos entre 0 y 59");
                }
            }
        } while (hora == null);

        return hora;
    }
    private static String getDNI() {
        String dni = "";
        do {
            dni = GetData.getString("Introduce tu DNI: ");
            if (dni.length() != 9) {
                System.out.println("El DNI debe tener 9 caracteres");
            }
        } while (dni.length() != 9);
        return dni;
    }

    private static void guardarJornadas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            oos.writeObject(jornadas);
        } catch (IOException e) {
            System.out.println("Error al guardar las jornadas");
        }
    }

    private static void cargarJornadas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {
            jornadas = (HashSet<Jornada>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las jornadas");
        }
    }
}

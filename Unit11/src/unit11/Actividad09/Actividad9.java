package unit11.Actividad09;

import Functions.GetData;

import java.io.*;
import java.util.ArrayList;

/*
    Implementar un programa que registra la evolución temporal de la temperatura en una ciudad.
    La aplicación mostrará un menú que permite añadir nuevos registros de temperatura y mostrar el listado de todos los registros históricos.
    Cada registro constará de la temperatura en grados centígrados, introducida por teclado, y la fecha y hora,
    que se leerá del sistema en el momento de la creación del registro.
 */
public class Actividad9 {
    public static final int OPCION_AÑADIR_REGISTRO = 1;
    public static final int OPCION_MOSTRAR_REGISTROS = 2;
    public static final int OPCION_SALIR = 3;

    public static void main(String[] args) {
        ArrayList<Registro> registro = new ArrayList<>();
        File archivo = new File("src/unit11/Actividad09/temperaturas.dat");
        try (ObjectInputStream flujoEntrada = new ObjectInputStream( new FileInputStream(archivo))) {
            registro = (ArrayList<Registro>) flujoEntrada.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Registro vacío.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        boolean salida = false;
        while (!salida) {
            mostrarMenu();
            int opcion = GetData.getInt("Introduzca una opción: ", 1, 3);
            switch (opcion) {
                case OPCION_AÑADIR_REGISTRO -> {
                    double temperatura = GetData.getDouble("Introduzca la temperatura: ");
                    registro.add(new Registro(temperatura));
                }
                case OPCION_MOSTRAR_REGISTROS -> {
                    if (registro.isEmpty()) {
                        System.out.println("No hay registros.");
                    } else {
                        for (Registro r : registro) {
                            System.out.println(r);
                        }
                    }

                }
                case OPCION_SALIR -> salida = true;
            }

            try (ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(archivo))) {
                flujoSalida.writeObject(registro);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("1. Añadir nuevo registro.");
        System.out.println("2. Mostrar todos los registros.");
        System.out.println("3. Salir.");
    }

}

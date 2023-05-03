package unit06.Actividad19_Aplicacion;

import java.util.Arrays;
import java.util.Scanner;

/*
    Diseña una aplicación que se comporte como una pestaña agenda. Mediante un menú, el usuario podrá
    elegir entre:
    1. Añadir un contacto (nombre y teléfono)
    2. Buscar un contacto (por nombre)
    3 Mostrar la información de todos los contactos ordenados alfabéticamente mediante el nombre;

    Pista: El nombre y el teléfono se puede codificar como un String, separando ambos datos como "nombre:teléfono"
 */
public class Actividad19 {
    // Constantes
    private static final int AÑADIR_CONTACTO = 1;
    private static final int BUSCAR_CONTACTO = 2;
    private static final int MOSTRAR_CONTACTOS = 3;
    private static final int SALIR = 4;

    public static void main(String[] args) {
        String[] agenda = new String[0];
        int opcion;
        boolean salir = false;

        while (!salir) { // Mientras no se elija la opción de salir
            // Mostramos el menú y pedimos la opción
            opcion = getInt("""
                    1. Añadir un contacto
                    2. Buscar un contacto
                    3. Mostrar la información de todos los contactos ordenados alfabéticamente mediante el nombre
                    4. Salir

                    Elige una opción:\s""", 1, 4);

            switch (opcion) { // Según la opción elegida
                case AÑADIR_CONTACTO -> agenda = anadirContacto(agenda); // Añadimos un contacto
                case BUSCAR_CONTACTO -> buscarContacto(agenda); // Buscamos un contacto
                case MOSTRAR_CONTACTOS -> mostrarContactos(agenda); // Mostramos los contactos
                case SALIR -> salir = true;
            }
        }



    }

    private static void mostrarContactos(String[] agenda) {
        String[] contactosOrdenados = ordenarContactos(agenda); // Ordenamos los contactos

        for (String contacto : contactosOrdenados) { // Mostramos los contactos
            String nombre = contacto.split(":")[0];
            String telefono = contacto.split(":")[1];
            System.out.println(nombre+" - "+telefono);
        }
    }

    private static String[] ordenarContactos(String[] agenda) {
        String[] contactosOrdenados = agenda.clone();
        String aux;
        for (int i = 0; i < contactosOrdenados.length-1; i++) { // Ordenamos los contactos
            for (int j = i+1; j < contactosOrdenados.length; j++) { // Recorremos los contactos
                if (contactosOrdenados[i].split(":")[0].compareTo(contactosOrdenados[j].split(":")[0]) > 0) { // Si el nombre del contacto i es mayor que el nombre del contacto j
                    aux = contactosOrdenados[i]; // Intercambiamos los contactos
                    contactosOrdenados[i] = contactosOrdenados[j]; // Intercambiamos los contactos
                    contactosOrdenados[j] = aux; // Intercambiamos los contactos
                }
            }
        }
        return contactosOrdenados;
    }

    private static void buscarContacto(String[] agenda) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        String[] contactosEncontrados = new String[2];

        // Pedimos el nombre
        System.out.print("Introduce el nombre: ");
        nombre = sc.nextLine();

        // Buscamos el contacto
        for (String contacto : agenda) {
            if (contacto.split(":")[0].equals(nombre)) {
                contactosEncontrados[0] = contacto.split(":")[0];
                contactosEncontrados[1] = contacto.split(":")[1];
            }
        }

        // Mostramos el contacto
        if (contactosEncontrados[0] != null) { // Si se ha encontrado el contacto
            System.out.println("Nombre: "+contactosEncontrados[0]);
            System.out.println("Teléfono: "+contactosEncontrados[1]);
        } else { // Si no se ha encontrado el contacto
            System.out.println("No se ha encontrado ningún contacto con ese nombre.");
        }

    }

    private static String[] anadirContacto(String[] agenda) {
        Scanner sc = new Scanner(System.in);
        String nombre, telefono;

        // Pedimos el nombre
        System.out.print("Introduce el nombre: ");
        nombre = sc.nextLine();

        // Pedimos el teléfono
        System.out.print("Introduce el teléfono: ");
        telefono = sc.nextLine();

        // Añadimos el contacto a la agenda
        agenda = Arrays.copyOf(agenda, agenda.length+1);
        agenda[agenda.length-1] = nombre+":"+telefono;

        return agenda;
    }


    public static int getInt(String mensaje, int minimo, int maximo) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print(mensaje);
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextInt();
            if (numero < minimo || numero > maximo) {
                System.out.println("Ingrese un valor entre "+minimo+" y "+maximo+".");
                System.out.print(mensaje);
            }
        } while (numero < minimo || numero > maximo);
        return numero;
    }
}

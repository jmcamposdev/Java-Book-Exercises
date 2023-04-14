package unit10.Actividad21_Aplicacion;

import Functions.GetData;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/*
    Diseña una pequeña agenda, que muestre el siguiente menú:
    1. Nuevo contacto.
    2. Buscar por nombre.
    3. Mostrar todos.
    4. Salir.
    En ella, guardaremos el nombre y el teléfono de un máximo de 20 personas.
    La opción 1 nos permitirá introducir un nuevo contacto siempre y cuando la agenda no esté llena, comprobando que el nombre no se encuentra insertado ya.
    La opción 2 muestra todos los teléfonos que coinciden con la cadena que se busca. Por ejemplo, si tecleamos «Pe», mostrará el teléfono de Pedro, de Pepe y de Petunia.
    La opción 3 mostrará un listado con toda la información (nombres y teléfonos) ordenados alfabéticamente por el nombre.
    Por último, la opción 4 guarda todos los datos de la agenda en el archivo agenda.ixt.
    La próxima vez que se ejecute la aplicación, si hay datos guardados, se cargarán en me moria.
 */
public class Actividad21 {
    public static final int OPCION_AÑADIR_CONTACTO = 1;
    public static final int OPCION_BUSCAR_POR_NOMBRE = 2;
    public static final int OPCION_MOSTRAR_TODOS = 3;
    public static final int OPCION_SALIR = 4;
    private static final File fileAgenda = new File("./src/unit10/Actividad21_Aplicacion/agenda.txt");
    private static final HashMap<String, String> agenda = new HashMap<>();

    public static void main(String[] args) {
        boolean ficheroAgendaInaccesible = false;
        if (!fileAgenda.exists() &&!crearFicheroAgenda()) {
            System.out.println("No se puede crear el fichero agenda.txt es necesario para el programa");
            ficheroAgendaInaccesible = true;
        }
        
        if (fileAgenda.exists() && !ficheroAgendaInaccesible && !leerFicheroAgenda()) {
            System.out.println("No se puede acceder al fichero "+ fileAgenda.getAbsolutePath());
            ficheroAgendaInaccesible = true;
        }
        
        if (!ficheroAgendaInaccesible) {
            boolean salidaPrograma = false;
            int userOption;
            
            while (!salidaPrograma) {
                System.out.println(menuString());
                userOption = GetData.getInt("Ingrese una opción (1-4): ",1,4);
                switch (userOption) {
                    case OPCION_AÑADIR_CONTACTO -> añadirContacto();
                    case OPCION_BUSCAR_POR_NOMBRE -> buscarNombre();
                    case OPCION_MOSTRAR_TODOS -> mostrarTodosLosContactos();
                    case OPCION_SALIR -> {
                        salidaPrograma = true;
                        System.out.println("Todo los valores se han guardado en el fichero.");
                    }
                }
            }
        }
    }
    
    
    public static boolean crearFicheroAgenda () {
        boolean ficheroCreado = true;
        if (!fileAgenda.exists()) {
            try {
                fileAgenda.createNewFile();
            } catch (IOException e) {
                ficheroCreado = false;
            }
        }
        return ficheroCreado;
    }
    
    public static boolean leerFicheroAgenda () {
        boolean ficheroLeido = true;
        if (fileAgenda.exists()) {
            try(BufferedReader br = new BufferedReader(new FileReader(fileAgenda))) {
                String cad;
                String[] values;
                while ((cad = br.readLine()) != null) {
                    values = cad.split(" ");
                    agenda.put(values[0],values[1]);
                }
            } catch (IOException e) {
                System.out.println("No se puede acceder al fichero "+ fileAgenda.getAbsolutePath());
                ficheroLeido = false;
            }
        }
        return ficheroLeido;
    }
    
    public static void añadirContacto() {
        if (agenda.size() >= 20) {
            System.out.println("La agenda se encuentra llena.");
        } else {
            String nombre = GetData.getString("Ingrese su Nombre: ");
            String telefono = GetData.getString("Ingrese su Telefono: ");
            
            if (agenda.containsKey(nombre)) {
                System.out.println("El nombre insertado ya se encuentra en la agenda.");
            } else {
                agenda.put(nombre,telefono); // Lo añadimos al HashMap
                if (añadirContactoFichero(nombre, telefono)) { // Lo añadimos al fichero
                    System.out.println("Se ha añadido el contacto Correctamente");
                } else {
                    System.out.println("No se ha podido añadir el contacto");
                }
            }
        }
    }
    
    public static boolean añadirContactoFichero(String nombre, String telefono) {
        boolean contactoAñadido = true;
        
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileAgenda , true))) {
            pw.println(nombre+" "+telefono);
            pw.flush();
        } catch (IOException e) {
            contactoAñadido = false;
        }
        return contactoAñadido;
    }
    
    private static void buscarNombre() {
        String busqueda = GetData.getString("Ingrese que desea buscar: ");
        if (agenda.isEmpty()) {
            System.out.println("No disponemos de contacto actualmente");
        } else {
            HashMap<String, String> contactosEncontrado = new HashMap<>();
            agenda.forEach((key, value) -> {
                if (key.startsWith(busqueda)) {
                    contactosEncontrado.put(key,value);
                }
            });
            if (contactosEncontrado.isEmpty()) {
                System.out.println("No se han encontrado contactos.");
            } else {
                contactosEncontrado.forEach((key, value) -> System.out.println(key + " - " +  value));
            }
        }
    }
    
    private static void mostrarTodosLosContactos() {
        if (agenda.isEmpty()) {
            System.out.println("No disponemos de contacto actualmente");
        } else {
            TreeMap<String, String> sortedAgenda = new TreeMap<>(agenda);
            sortedAgenda.forEach((key, value) -> {
                System.out.println(key + " - " + value);
            });
        }
    }    

    
    
    
    
    
    
    
    public static String menuString() {
        return """
                        1. Nuevo contacto
                        2. Buscar por nombre
                        3. Mostrar todos
                        4. Salir""";
    }
}

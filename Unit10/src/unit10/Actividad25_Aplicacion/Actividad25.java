package unit10.Actividad25_Aplicacion;

import Functions.GetData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/*
    Repite la Actividad 21 pero guardando los datos en un fichero XML
 */
public class Actividad25 {
    public static final int OPCION_AÑADIR_CONTACTO = 1;
    public static final int OPCION_BUSCAR_POR_NOMBRE = 2;
    public static final int OPCION_MOSTRAR_TODOS = 3;
    public static final int OPCION_SALIR = 4;
    private static final File fileAgenda = new File("./src/unit10/Actividad25_Aplicacion/agenda.xml");
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
                        if (añadirContactoFichero())
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
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbFactory.newDocumentBuilder();
                Document doc = db.parse(fileAgenda);

                NodeList nList = doc.getElementsByTagName("contacto");

                for (int i = 0; i < nList.getLength(); i++) {
                    Element elemento = (Element) nList.item(i);
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    String telefono = elemento.getElementsByTagName("telefono").item(0).getTextContent();
                    agenda.put(nombre,telefono);
                }

            } catch (ParserConfigurationException | IOException | SAXException e) {
                throw new RuntimeException(e);
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
               agenda.put(nombre,telefono);
               System.out.println("Contacto añadido.");
            }
        }
    }

    public static boolean añadirContactoFichero() {
        boolean ficheroGuardado = true;
        try  {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.newDocument();

            // Crear el elemento raíz y añadirlo al documento
            Element root = doc.createElement("agenda");
            doc.appendChild(root);

            // Crear un elemento contacto y añadirlo al elemento raíz
            for (Map.Entry<String, String> entry : agenda.entrySet()) {
                Element contacto = doc.createElement("contacto");
                root.appendChild(contacto);

                // Crear un elemento nombre y añadirlo al elemento contacto
                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(entry.getKey()));
                contacto.appendChild(nombre);

                // Crear un elemento telefono y añadirlo al elemento contacto
                Element telefono = doc.createElement("telefono");
                telefono.appendChild(doc.createTextNode(entry.getValue()));
                contacto.appendChild(telefono);
            }

            // Escribir el documento en un fichero
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            StreamResult result = new StreamResult(fileAgenda);
            DOMSource source = new DOMSource(doc);

            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            ficheroGuardado = false;
        }
        return ficheroGuardado;
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

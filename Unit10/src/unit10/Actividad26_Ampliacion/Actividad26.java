package unit10.Actividad26_Ampliacion;

import Functions.GetData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import unit10.Actividad24_Aplicacion.Registro;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
public class Actividad26 {
    public static final int OPCION_REGISTRAR_TEMPERATURA = 1;
    public static final int OPCION_HISTORIAL_REGISTROS = 2;
    public static final int OPCION_SALIR_PROGRAMA = 3;

    public static void main(String[] args) {
        boolean salirPrograma = false;
        File fileRegistros = new File("./src/unit10/Actividad26_Ampliacion/temperaturas.xml");
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
                    case OPCION_SALIR_PROGRAMA -> {
                        salirPrograma = true;
                        if (registros.isEmpty()) {
                            System.out.println("No se ha guardado ningún registro");
                        } else {
                            añadirRegistrosFichero(registros, fileRegistros);
                        }
                    }
                }
            }
            System.out.println("Se ha guardado todo los datos correctamente");
        }
    }

    public static boolean obtenerDatosFichero (File fileRegistros, ArrayList<Registro> registros) {
        boolean datosObtenidos = false;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbFactory.newDocumentBuilder();
            Document doc = db.parse(fileRegistros);

            NodeList nodeList = doc.getElementsByTagName("registro");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String fecha = element.getElementsByTagName("fecha").item(0).getTextContent();
                int temperaturaMaxima = Integer.parseInt(element.getElementsByTagName("maxTemp").item(0).getTextContent());
                int temperaturaMinima = Integer.parseInt(element.getElementsByTagName("minTemp").item(0).getTextContent());

                registros.add(new Registro(LocalDate.parse(fecha),temperaturaMaxima,temperaturaMinima));
            }
            datosObtenidos = true;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println("El fichero no se ha encontrado o no se puede acceder a él");
        }
        return datosObtenidos;
    }

    public static boolean añadirRegistrosFichero(ArrayList<Registro> registros, File fileRegistros) {
        boolean datosAñadidos = true;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbFactory.newDocumentBuilder();
            Document doc = db.newDocument();

            // Crear el elemento raíz
            Element rootElement = doc.createElement("registros");
            doc.appendChild(rootElement);

            // Crear los elementos hijos
            for (Registro registro : registros) {
                Element registroElement = doc.createElement("registro");
                rootElement.appendChild(registroElement);

                Element fechaElement = doc.createElement("fecha");
                fechaElement.appendChild(doc.createTextNode(registro.getFecha().toString()));
                registroElement.appendChild(fechaElement);

                Element maxTempElement = doc.createElement("maxTemp");
                maxTempElement.appendChild(doc.createTextNode(String.valueOf(registro.getTemperaturaMaxima())));
                registroElement.appendChild(maxTempElement);

                Element minTempElement = doc.createElement("minTemp");
                minTempElement.appendChild(doc.createTextNode(String.valueOf(registro.getTemperaturaMinima())));
                registroElement.appendChild(minTempElement);
            }

            // Escribir el contenido en un archivo XML
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            // Formatear el fichero
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            StreamResult result = new StreamResult(fileRegistros);
            DOMSource source = new DOMSource(doc);

            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            datosAñadidos = false;
        }

        return datosAñadidos;
    }

}

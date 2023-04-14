package unit10.Actividad02;
import java.io.FileReader;

/*
    Leer un archivo de texto .java de uno de los proyectos que hayamos terminado
    y mostrarlos por pantalla.
*/
public class Actividad2 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        FileReader lector = null;
        try {
            lector = new FileReader("./src/unit10/Actividad1/Actividad1.java");
            int character = lector.read(); // Leemos el caracter
            while (character != -1) { // Si el caracter no es -1
                text.append((char) character); // Añadimos el caracter al text
                character = lector.read(); // Volvemos a coger otro caracter
            }
        } catch (Exception e) {
            System.out.println("No existe el fichero");
         } finally { // Se usa para cerrar el FileReader
            if (lector != null) {
                try {
                    lector.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        System.out.println(text); // Imprimimos el fichero
    }
    
}

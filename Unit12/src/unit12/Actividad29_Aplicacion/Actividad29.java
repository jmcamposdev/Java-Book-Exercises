package unit12.Actividad29_Aplicacion;

import Functions.GetData;

import java.util.Set;
import java.util.TreeSet;

/*
    Repite la Actividad de aplicación 28 de forma que se inserten los nombres manteniendo el orden alfabético.
 */
public class Actividad29 {
    public static void main(String[] args) {
        Set<String> nombres = new TreeSet<>();
        String nombre;
        do {
            nombre = GetData.getString("Introduce un nombre: ");
            if (!nombre.equals("fin")) {
                nombres.add(nombre);
            }
        } while (!nombre.equals("fin"));

        System.out.println(nombres);
    }
}

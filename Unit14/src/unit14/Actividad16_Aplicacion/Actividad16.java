package unit14.Actividad16_Aplicacion;

import unit14.Actividad15_Aplicacion.DAO.OficinaDAO;
import unit14.Actividad15_Aplicacion.Oficina;

import java.util.ArrayList;

/*
     Utiliza la técnica de mapeo objeto-relacional para cargar todas las oficinas de la base de datos
     en una lista de oficinas. Muestra el contenido de la lista de objetos creada.
 */
public class Actividad16 {
    public static void main(String[] args) {
        OficinaDAO oficinaDAO = new OficinaDAO();
        ArrayList<Oficina> oficinas = (ArrayList<Oficina>) oficinaDAO.readAll();
        for (Oficina oficina : oficinas) {
            System.out.println(oficina);
        }
    }
}

package unit14.Actividad22_Aplicacion;

import unit14.Actividad15_Aplicacion.DAO.OficinaDAO;
import unit14.Actividad15_Aplicacion.Oficina;
import unit14.Funciones.GetData;

import java.util.ArrayList;

/*
    Aprovecha el método de la Actividad 21 para mostrar las oficinas cuya superficie es superior a una
    extensión introducida por teclado.
 */
public class Actividad22 {
    public static void main(String[] args) {
        OficinaDAO oficinaDAO = new OficinaDAO(); // Instancia de OficinaDAO
        ArrayList<Oficina> oficinas = (ArrayList<Oficina>) oficinaDAO.readAll(); // ArrayList de oficinas

        // Pedimos la superficie
        int superficie = GetData.getInt("Introduce la superficie: ", 1, Integer.MAX_VALUE);

        // Mostramos las oficinas cuya superficie es superior a la introducida
        oficinas.stream().filter(oficina -> oficina.getSuperficie() > superficie).forEach(System.out::println);
    }
}

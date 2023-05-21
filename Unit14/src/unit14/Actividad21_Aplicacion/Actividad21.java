package unit14.Actividad21_Aplicacion;

import unit14.Actividad15_Aplicacion.DAO.OficinaDAO;

/*
    Añade a la clase OficinaDAO un método que devuelva una lista con todas las ofocinas.
    Prueba el método mostrando todas las oficinas existentes en la base de datos
 */
public class Actividad21 {
    public static void main(String[] args) {
        OficinaDAO oficinaDAO = new OficinaDAO(); // Instancia de OficinaDAO
        // He utilizado expresiones lambda para mostrar las oficinas
        oficinaDAO.readAll().forEach(System.out::println); // Mostramos todas las oficinas
    }
}

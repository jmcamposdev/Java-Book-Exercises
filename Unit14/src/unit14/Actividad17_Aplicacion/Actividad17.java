package unit14.Actividad17_Aplicacion;

import unit14.Actividad15_Aplicacion.DAO.EmpleadoDAO;
import unit14.Actividad15_Aplicacion.Empleado;
import unit14.Funciones.GetData;

import java.util.ArrayList;

/*
    Mustra un listado con el nombre y la edad de todos los empleados cuya edad se encuentra
    comprendida entre unos valores máximos y mínimos que introducirá el usuario
 */
public class Actividad17 {
    public static void main(String[] args) {
        // Pedimos los valores mínimo y máximo
        int min = GetData.getInt("Introduce la edad mínima: ");
        int max = GetData.getInt("Introduce la edad máxima: ", min);

        // Obtenemos los empleados cuya edad se encuentra entre los valores introducidos
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        ArrayList<Empleado> empleados = (ArrayList<Empleado>) empleadoDAO.readAllRangeAge(min, max);

        if (empleados.isEmpty()) { // Si no se han encontrado empleados
            System.out.println("No se han encontrado empleados con esas características");
        } else { // Si se han encontrado empleados los mostramos
            for (Empleado empleado : empleados) {
                System.out.println(empleado.getNombre() + " " + empleado.getEdad());
            }
        }
    }
}

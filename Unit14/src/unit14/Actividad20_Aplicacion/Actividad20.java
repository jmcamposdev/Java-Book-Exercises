package unit14.Actividad20_Aplicacion;

import unit14.Actividad15_Aplicacion.DAO.EmpleadoDAO;
import unit14.Funciones.GetData;

/*
    Solicita por teclado el número de un empleado y bórralo de la base de datos. Implementa
    la solución como parte de la clase DAO para empleados
 */
public class Actividad20 {
    public static void main(String[] args) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO(); // Instancia de EmpleadoDAO
        // Pedimos el número de empleado
        int numemp = GetData.getInt("Introduce el número de empleado: ", 1, Integer.MAX_VALUE);
        empleadoDAO.delete(numemp); // Eliminamos el empleado
        System.out.println("Empleado eliminado correctamente");
    }
}

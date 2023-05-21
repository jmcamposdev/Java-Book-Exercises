package unit14.Actividad15_Aplicacion;

import unit14.Actividad15_Aplicacion.DAO.EmpleadoDAO;

/*
    Crea un programa que muestre todos los empleados
 */
public class Actividad15 {
    public static void main(String[] args) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        for (Empleado empleado : empleadoDAO.readAll()) {
            System.out.println(empleado);
        }
    }
}

package unit14.Actividad19_Aplicacion;

import unit14.Actividad15_Aplicacion.DAO.EmpleadoDAO;
import unit14.Actividad15_Aplicacion.DAO.OficinaDAO;
import unit14.Actividad15_Aplicacion.Empleado;
import unit14.Actividad15_Aplicacion.Oficina;
import unit14.Funciones.GetData;

import java.util.ArrayList;

/*
    Escribe una aplicación que cambie a todos los empleados que trabajan en una oficina a otra. Muestra
    a los empleados afectados po rel cambio de oficina antes y después de la modificación
 */
public class Actividad19 {
    public static void main(String[] args) {
        OficinaDAO oficinaDAO = new OficinaDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        ArrayList<Oficina> oficinas = (ArrayList<Oficina>) oficinaDAO.readAll(); // ArrayList de oficinas
        int oficinaID = pedirOficina(oficinas); // ID de la oficina a cambiar

        // ArrayList de empleados que trabajan en la oficina a cambiar
        ArrayList<Empleado> empleados = (ArrayList<Empleado>) empleadoDAO.readAllByOficina(oficinaID);

        // Mostramos los empleados que trabajan en la oficina a cambiar
        mostrarEmpleados(empleados);

        // Pedimos la nueva oficina
        int nuevaOficinaID = pedirOficina(oficinas);
        // Obtenemos la nueva oficina a partir del ID
        Oficina nuevaOficina = oficinaDAO.read(String.valueOf(nuevaOficinaID));
        // Cambiamos la oficina de los empleados
        for (Empleado empleado : empleados) {
            empleado.setOficina(nuevaOficina); // Cambiamos la oficina
            empleadoDAO.update(empleado); // Actualizamos el empleado de la base de datos
        }

        // Mostramos los empleados que trabajan en la nueva oficina
        mostrarEmpleados(empleados);
    }

    private static int pedirOficina(ArrayList<Oficina> oficinas) {
        mostrarOficinas(oficinas);
        return GetData.getInt("Introduce el ID de la oficina: ", 1, oficinas.size());
    }

    private static void mostrarOficinas(ArrayList<Oficina> oficinas) {
        for (int i = 0; i < oficinas.size(); i++) {
            System.out.println((i+1) + " - " + oficinas.get(i));
        }
    }

    private static void mostrarEmpleados(ArrayList<Empleado> empleados) {
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println((i+1) + " - " + empleados.get(i));
        }
    }
}

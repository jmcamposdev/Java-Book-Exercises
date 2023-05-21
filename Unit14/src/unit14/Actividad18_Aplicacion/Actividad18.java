package unit14.Actividad18_Aplicacion;

import unit14.Actividad15_Aplicacion.DAO.EmpleadoDAO;
import unit14.Actividad15_Aplicacion.DAO.OficinaDAO;
import unit14.Actividad15_Aplicacion.Empleado;
import unit14.Actividad15_Aplicacion.Oficina;
import unit14.Funciones.GetData;

import java.time.LocalDate;

/*
    Crea un programa que lea todos los datos de un empleado, excepto la fecha de contratación
    que será la de hoy, y los inserte en la base de datos
 */
public class Actividad18 {
    public static void main(String[] args) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();

        // Pedimos los datos del empleado
        String nombre = GetData.getString("Introduce el nombre: ");
        int edad = GetData.getInt("Introduce la edad: ",18);
        Oficina oficina = getOficina();
        String puesto = GetData.getString("Introduce el puesto: ");

        // Insertamos el empleado en la base de datos
        Empleado empleado = new Empleado(0, nombre, edad, oficina, puesto, LocalDate.now());
        empleadoDAO.insert(empleado);

        System.out.println("Empleado insertado correctamente");


    }

    private static Oficina getOficina() {
        OficinaDAO oficinaDAO = new OficinaDAO();
        Oficina oficina;
        do {
            int codigoOficina = GetData.getInt("Introduce el código de la oficina: ");
            oficina = oficinaDAO.read(String.valueOf(codigoOficina));
            if (oficina == null) {
                System.out.println("No existe ninguna oficina con ese código");
            }
        } while (oficina == null);
        return oficina;
    }
}

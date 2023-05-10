package unit14.Actividad07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    Implementar un programa que solicite el nombre de un alumno y lo elimine. Aprovechar esta aplicación para
    practicar la técnica de SQL Injection.
 */
public class Actividad7 {
    public static void main(String[] args) {
        String nombre;
        do { // Pedimos el nombre del alumno a eliminar
            nombre = unit14.Funciones.GetData.getString("Introduce el nombre del alumno a eliminar: ");
            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío");
            }
            if (nombre.length() > 30) {
                System.out.println("El nombre no puede tener más de 30 caracteres");
            }
        } while (nombre.isBlank() || nombre.length() > 30);

        eliminarAlumno(nombre); // Eliminamos el alumno de la base de datos
    }

    private static void eliminarAlumno(String nombreAlumno) {
        String url = "jdbc:postgresql://localhost:5432/instituto"; // URL de la base de datos
        Connection con; // Conexión a la base de datos
        Statement statement; // Creación de un objeto Statement
        // Con esta consulta SQL eliminamos un alumno de la base de datos
        /*
            Esta consulta SQL es vulnerable a SQL Injection, ya que el usuario puede introducir cualquier
            consulta SQL y se ejecutará sin problemas.
            Consulta: DELETE FROM alumnos WHERE nombre = 'xxx' OR '1' = '1'; Probar a introducir esta consulta             eliminará todos los alumnos de la base de datos.
            
            
         */
        String sql = "DELETE FROM alumnos WHERE nombre = '" + nombreAlumno + "'";

        try { // Intentamos realizar la conexión
            con = DriverManager.getConnection(url, "postgres", ""); // Conexión a la base de datos
            statement = con.createStatement();
            statement.executeUpdate(sql); // Ejecución de la consulta
            System.out.println("Alumno eliminado correctamente"); // Si se ha ejecutado correctamente la consulta, mostramos un mensaje
        } catch (SQLException e) { // Si no se ha podido realizar la conexión, mostramos un mensaje de error
            System.out.println("Error al eliminar el alumno");
        }

    }
}


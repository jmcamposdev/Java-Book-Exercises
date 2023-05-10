package unit14.Actividad03;

import unit14.Funciones.GetData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    Solicita el número de un alumno y elimínalo de la base de datos
 */
public class Actividad3 {
    public static void main(String[] args) {
        // Pedimos el número del alumno a eliminar
        int numAlumno = GetData.getInt("Introduce el número del alumno a eliminar: ");

        // Intentamos eliminar el alumno
        eliminarAlumno(numAlumno);
    }

    private static void eliminarAlumno(int numAlumno) {
        String url = "jdbc:postgresql://localhost:5432/instituto"; // URL de la base de datos
        Connection con; // Conexión a la base de datos
        Statement statement; // Creación de un objeto Statement
        // Con esta consulta SQL eliminamos un alumno de la base de datos
        String sql = "DELETE FROM alumnos WHERE num = " + numAlumno + "";

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

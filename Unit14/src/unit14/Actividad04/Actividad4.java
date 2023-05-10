package unit14.Actividad04;

import java.sql.*;

/*
    Mostrar el nombre y la fecha de nacimiento de todos los alumnos de un curso que se le
    solicitará al usuario por teclado;
 */
public class Actividad4 {
    public static void main(String[] args) {
        String curso;
        boolean cursoValido;
        do { // Pedimos el curso al usuario
            cursoValido = true;
            curso = unit14.Funciones.GetData.getString("Introduce el curso del que quieres ver los alumnos: ");
            curso = curso.toUpperCase(); // Convertimos el curso a mayúsculas para que no haya problemas con la expresión regular
            if (!curso.matches("^[1-4][A-D]$")) {
                System.out.println("El curso debe ser un número del 1 al 4 seguido de una letra de la A a la D");
                cursoValido = false;
            }
        } while (!cursoValido);

        ResultSet rs = obtenerDatosAlumnos(curso); // Obtenemos los datos de los alumnos del curso
        mostrarDatosAlumnos(rs); // Mostramos los datos de los alumnos



    }

    private static void mostrarDatosAlumnos(ResultSet rs) {
        try { // Intentamos realizar la conexión
            while (rs.next()) { // Mientras haya datos en el ResultSet
                // Mostramos el nombre y la fecha de nacimiento del alumno
                System.out.println("Nombre: " + rs.getString("nombre") + " Fecha de nacimiento: " + rs.getDate("fnac"));
            }
        } catch (SQLException e) { // Si no se ha podido realizar la conexión, mostramos un mensaje de error
            System.out.println("Error al obtener los datos de los alumnos");
        }
    }

    private static ResultSet obtenerDatosAlumnos(String curso) {
        String url = "jdbc:postgresql://localhost:5432/instituto"; // URL de la base de datos
        Connection con; // Conexión a la base de datos
        Statement statement; // Creación de un objeto Statement
        // Con esta consulta SQL obtenemos los datos de los alumnos de un curso
        String sql = "SELECT nombre, fnac FROM alumnos WHERE curso = '" + curso + "'";
        ResultSet rs = null;
        try { // Intentamos realizar la conexión
            con = DriverManager.getConnection(url, "postgres", ""); // Conexión a la base de datos
            statement = con.createStatement();
            rs = statement.executeQuery(sql); // Ejecución de la consulta
        } catch (SQLException e) { // Si no se ha podido realizar la conexión, mostramos un mensaje de error
            System.out.println("Error al obtener los datos de los alumnos");
        }
        return rs;
    }
}

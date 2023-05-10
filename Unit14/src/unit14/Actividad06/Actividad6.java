package unit14.Actividad06;

import java.sql.*;

/*
    Mostrar el nombre y nota de todos los alumnos y a posteriore mostrar al alumno con la mejor nota y al alumno
    con la peor nota media.

    Obtener a los alumnos con la mejor y, pero nota es posible mediante una consulta SQL.
    Existe distintas soluciones: operador UNION, subconsultas, etc. En lugar de eso aprovecharemos
    la consulta que devuelve a todos los alumnos ordenados por su nota media en orden decreciente,
    ya que el primer alumno será el que posea la mejor nota y el último el que posea la peor nota..
    Por sencillez supondremos que no existen alumnos con notas repetidas
 */
public class Actividad6 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/instituto"; // URL de la base de datos
        Connection con; // Conexión a la base de datos
        Statement statement; // Creación de un objeto Statement
        ResultSet rs; // Creación de un objeto ResultSet
        // Con esta consulta SQL obtenemos los datos de los alumnos ordenados por su nota media en orden decreciente
        String sql = "SELECT nombre, media FROM alumnos ORDER BY media DESC";

        try {
            con = DriverManager.getConnection(url, "postgres", ""); // Conexión a la base de datos
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sql); // Ejecución de la consulta

            // Mostramos los datos de los alumnos
            System.out.println("Todos los Alumnos:");
            while (rs.next()) { // Mientras haya datos en el ResultSet
                // Mostramos el nombre y la nota media del alumno
                System.out.println("Nombre: " + rs.getString("nombre") + " Nota media: " + rs.getFloat("media"));
            }
            System.out.println();
            // Mostramos el alumno con la mejor nota media
            if (rs.first()) { // Si hay datos en el ResultSet
                System.out.println("Alumno con la mejor nota media: " + rs.getString("nombre") + " Nota media: " + rs.getFloat("media"));
            } else { // Si no hay datos en el ResultSet
                System.out.println("No hay alumnos");
            }

            // Mostramos el alumno con la peor nota media
            if (rs.last()) { // Si hay datos en el ResultSet
                System.out.println("Alumno con la peor nota media: " + rs.getString("nombre") + " Nota media: " + rs.getFloat("media"));
            } else { // Si no hay datos en el ResultSet
                System.out.println("No hay alumnos");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package unit14.Actividad01;

import java.sql.*;

/*
    Incrementar la nota media en un punto a todos los alumnos del curso 1B. Usar una consulta SQL que haga
    uso de UPDATE
 */
public class Actividad1 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/instituto";
        Connection con;
        Statement stmt;
        String sql;
        try {
            con = DriverManager.getConnection(url, "postgres", ""); // Conexión a la base de datos
            stmt = con.createStatement(); // Creación de un objeto Statement
            // Con esta consulta SQL incrementamos la nota media de todos los alumnos del curso 1B en un punto
            sql = "UPDATE alumnos SET media = media + 1 WHERE curso = '1B'"; // Consulta SQL
            stmt.executeUpdate(sql); // Ejecución de la consulta
            stmt.close(); // Cierre de la conexión
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

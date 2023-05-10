package unit14.Actividad09;

import java.sql.*;

import static unit14.Actividad08.Actividad8.mostrarDatosAlumnos;

/*
    Diseñar una aplicación que muestre un informe de los alumnos, según sus notas:
     todos los alumnos cuya nota es Bien (6 y 7) y todos los alumnos cuya nota es Notable (entre 7 y 9)
     Cada informe debe ordenarse por la nota de forma ascendente.

     Para realizar esta actividad usaremos una consulta con parámetros y la reutilizaremos
 */
public class Actividad9 {
    public static void main(String[] args) {
        System.out.println("Alumnos con nota Bien (6 y 7)");
        ResultSet rs = obtenerAlumnosEntreXNotas(6, 7); // Obtenemos los datos de los alumnos del curso
        mostrarDatosAlumnos(rs); // Mostramos los datos de los alumnos

        System.out.println("\nAlumnos con nota Notable (entre 7 y 9)");
        rs = obtenerAlumnosEntreXNotas(7, 9); // Obtenemos los datos de los alumnos del curso
        mostrarDatosAlumnos(rs); // Mostramos los datos de los alumnos

        System.out.println("\nAlumnos con nota Sobresaliente (entre 9 y 10)");
        rs = obtenerAlumnosEntreXNotas(9, 10); // Obtenemos los datos de los alumnos del curso
        mostrarDatosAlumnos(rs); // Mostramos los datos de los alumnos

    }

    private static ResultSet obtenerAlumnosEntreXNotas(double notaMin, double notaMax) {
        // Comprobamos que la nota mínima no sea mayor que la nota máxima
        notaMin = Math.min(notaMin, notaMax);
        notaMax = Math.max(notaMin, notaMax);

        Connection con; // Conexión a la base de datos
        PreparedStatement ps; // Creación de un objeto Statement
        // Con esta consulta SQL obtenemos los datos de los alumnos de un curso y con una nota mayor que la nota de corte
        String sql = "SELECT nombre, media, curso " +
                     "FROM alumnos " +
                     "WHERE media BETWEEN ? AND ?" +
                     "ORDER BY media";
        ResultSet rs = null;

        try { // Establecemos la conexión con la base de datos
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/instituto", "postgres", ""); // Conexión a la base de datos
            ps = con.prepareStatement(sql); // Preparamos la consulta

            // Parametrizamos la consulta
            ps.setInt(1, (int) notaMin);
            ps.setInt(2, (int) notaMax);

            rs = ps.executeQuery(); // Ejecución de la consulta
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
        }
        return rs;
    }
}

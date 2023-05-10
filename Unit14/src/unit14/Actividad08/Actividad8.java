package unit14.Actividad08;

import unit14.Funciones.GetData;

import java.sql.*;


/*
    Escribir un programa que muestre todos los alumnos de un curso cuya nota es mayor que cierta nota de corte.
    Tanto el curso como la nota de corte será introducida por el usuario.
 */
public class Actividad8 {
    public static void main(String[] args) {
        String curso = getCurso();
        double notaCorte = GetData.getDouble("Introduce la nota de corte: ", 0, 10);
        ResultSet rs = obtenerDatosAlumnos(curso, notaCorte); // Obtenemos los datos de los alumnos del curso
        if (rs != null) { // Si se han encontrado alumnos
            mostrarDatosAlumnos(rs); // Mostramos los datos de los alumnos
        } else { // Si no se han encontrado alumnos
            System.out.println("No se han encontrado alumnos");
        }
    }

    private static void mostrarDatosAlumnos(ResultSet rs) {
        try { // Mostramos los datos de los alumnos
            if (!rs.next()) { // Si no hay alumnos
                System.out.println("No se han encontrado alumnos");
            } else {
                while (rs.next()) {
                    System.out.println("Nombre: " + rs.getString("nombre") + " | Media: " + rs.getDouble("media") + " | " + rs.getString("curso"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al mostrar los datos de los alumnos");
        }
    }

    private static ResultSet obtenerDatosAlumnos(String curso, double notaCorte) {
        Connection con; // Conexión a la base de datos
        PreparedStatement ps; // Creación de un objeto Statement
        // Con esta consulta SQL obtenemos los datos de los alumnos de un curso y con una nota mayor que la nota de corte
        String sql = "SELECT nombre, media, curso " +
                     "FROM alumnos " +
                     "WHERE curso = ? AND media > ?";
        ResultSet rs = null;

        try { // Establecemos la conexión con la base de datos
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/instituto", "postgres", ""); // Conexión a la base de datos
            ps = con.prepareStatement(sql); // Preparamos la consulta

            // Parametrizamos la consulta
            ps.setString(1, curso);
            ps.setDouble(2, notaCorte);

            rs = ps.executeQuery(); // Ejecución de la consulta
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error al conectar con la base de datos");
        }
        return rs;
    }


    public static String getCurso() {
        String curso;
        boolean cursoValido;
        do {
            cursoValido = true;
            curso = GetData.getString("Introduce el curso del que quieres ver los alumnos: ");
            curso = curso.toUpperCase();
            if (!curso.matches("^[1-4][A-D]$")) {
                System.out.println("El curso debe ser un número del 1 al 4 seguido de una letra de la A a la D");
                cursoValido = false;
            }
        } while (!cursoValido);

        return curso;
    }
}

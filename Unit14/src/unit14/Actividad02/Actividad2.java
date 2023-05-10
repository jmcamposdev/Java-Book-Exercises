package unit14.Actividad02;

import unit14.Funciones.GetData;
import java.sql.*;
import java.time.LocalDate;

/*
    Realizar una aplicación que solicite todos los datos de un nuevo alumno
    y los inserte en la base de datos
 */
public class Actividad2 {
    public static void main(String[] args) {
        System.out.println("Creamos un nuevo alumno");
        String nombre;
        do { // Pedimos el nombre del alumno y comprobamos que no esté vacío y que no tenga más de 30 caracteres
            nombre = GetData.getString("Introduce el nombre del alumno: ");
            if (nombre.length() == 0) {
                System.out.println("El nombre no puede estar vacío");
            } else if (nombre.length() > 30) {
                System.out.println("El nombre no puede tener más de 30 caracteres");
            }
        } while (nombre.length() == 0 || nombre.length() > 30); // Ya que en SQL tenemos un VARCHAR(30)

        // Pedimos la fecha de nacimiento del alumno
        LocalDate fechaNacimiento = GetData.getFecha("Introduce la fecha de nacimiento del alumno: ");
        // Pedimos la media del alumno
        double media = GetData.getDouble("Introduce la media del alumno", 0, 10);

        String curso;
        boolean cursoValido;
        do { // Pedimos el curso del alumno y comprobamos que posea un formato válido Ej: 1A, 2B, 3C, 4D
            cursoValido = true;
            curso = GetData.getString("Introduce el curso del alumno: ");
            curso = curso.toUpperCase(); // Convertimos el curso a mayúsculas para que no haya problemas con la expresión regular
            if (!curso.matches("^[1-4][A-D]$")) { // Comprobamos que el curso tenga el formato correcto
                System.out.println("El curso debe ser un número del 1 al 4 seguido de una letra de la A a la D");
                cursoValido = false;
            }
        } while (!cursoValido);

        insertarAlumno(nombre, fechaNacimiento, media, curso); // Insertamos el alumno en la base de datos

    }

    private static void insertarAlumno(String nombre, LocalDate fechaNacimiento, double media, String curso) {
        String url = "jdbc:postgresql://localhost:5432/instituto"; // URL de la base de datos
        Connection con; // Conexión a la base de datos
        Statement statement; // Creación de un objeto Statement
        // Con esta consulta SQL insertamos un nuevo alumno en la base de datos
        String sql = "INSERT INTO alumnos (nombre, fnac, media, curso) VALUES ('" + nombre + "', '" + fechaNacimiento + "', " + media + ", '" + curso + "')";

        try { // Intentamos realizar la conexión
            con = DriverManager.getConnection(url, "postgres", ""); // Conexión a la base de datos
            statement = con.createStatement();
            statement.executeUpdate(sql); // Ejecución de la consulta
            System.out.println("Alumno insertado correctamente"); // Si se ha ejecutado correctamente la consulta, mostramos un mensaje
        } catch (SQLException e) { // Si no se ha podido realizar la conexión, mostramos un mensaje de error
            System.out.println("Error al insertar el alumno");
        }

    }
}

package unit14.Actividad11;

import unit14.Actividad10.Alumno;

import java.sql.*;

/**
 * Clase que permite realizar operaciones CRUD sobre la tabla Alumnos de la base de datos Instituto
 * (Data Object Access)
 */
public class AlumnoDAO {

    // Conexión a la base de datos
    private static Connection conexion() {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/instituto";
        try {
            con = DriverManager.getConnection(url, "postgres", "");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
        }
        return con;
    }

    /**
     * Inserta el Alumno pasado por parámetro como un registro de la
     * tabla Alumnos de la base de datos Instituto
     * @param alumno Alumno a insertar en la base de datos
     */
    public static void create(Alumno alumno) {
        String sql = "INSERT INTO alumnos (num, nombre, fnac, media, curso) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (Connection con = conexion()) {
            PreparedStatement ps = con.prepareStatement(sql); // Creamos el PreparedStatement
            // Asignamos los valores a los parámetros
            ps.setInt(1, alumno.getId());
            ps.setString(2, alumno.getNombre());
            ps.setDate(3, new java.sql.Date(alumno.getFecNacimiento().getTime()));
            ps.setDouble(4, alumno.getNotaMedia());
            ps.setString(5, alumno.getCurso());
            // Ejecutamos la consulta
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar el alumno");
        }
    }

    /**
     * Lee los datos del alumno con clave id, construye un objeto Alumno y lo devuelve
     * @param id Identificador del Alumno
     * @return Devuelve un objeto Alumno con los datos del registro leído o null si no lo encuentra
     */
    public static Alumno read(int id) {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumnos WHERE num = ?";

        try (Connection con = conexion()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                alumno = new Alumno(
                    result.getInt("num"),
                    result.getString("nombre"),
                    result.getDate("fnac"),
                    result.getDouble("media"),
                    result.getString("curso")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al leer el alumno");
        }
        return alumno;
    }

    /**
     * Actualiza el registro de la Base de Datos con los datos del Alumno pasado por parámetro
     * @param alumno Alumno con los datos a actualizar
     */
    public static void update(Alumno alumno) {
        if (alumno != null) {
            String sql = "UPDATE alumnos SET nombre = ?, fnac = ?, media = ?, curso = ? WHERE num = ?";
            try (Connection con = conexion()) {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, alumno.getNombre());
                ps.setDate(2, new java.sql.Date(alumno.getFecNacimiento().getTime()));
                ps.setDouble(3, alumno.getNotaMedia());
                ps.setString(4, alumno.getCurso());
                ps.setInt(5, alumno.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error al actualizar el alumno");
            }
        }
    }

    /**
     * Borra el registro de la Base de Datos con él, id pasado por parámetro
     * @param id Identificador del Alumno a borrar
     */
    public static void delete(int id) {
        String sql = "DELETE FROM alumnos WHERE num = ?";
        try (Connection con = conexion()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al borrar el alumno");
        }
    }
}

package unit14.Actividad12_14;

import unit14.Actividad10.Alumno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
    ACTIVIDAD 12
    Rediseñar la calse AlumnoDAO para que permita una política distinta con respecto a la conexión de la DDBB
    1. Conectamos con la BD al principio
    2. Se realizan multitud de operaciones
    3. Se cierra la conexión al final

    Para implementar este enfoque debemos mantener un atributo con la conexión, que se abrirá en cuanto
    un objeto AlumnoDAO se construya. Ahora los métodos no podrán ser estáticos, ya que requieren el uso de
    un atributo del objeto.

    Podemos aprovechar el enfoque no estático para definir unas constantes que sirvan para configurar los parámetros de la conexión a la BD

    ACTIVIDAD 13
    Añadir un método a la clase AlumnoDAO que devuelva una lista con todos los alumnos que existen en la base de datos

    ACTIVIDAD 14
    Incluir en la clase AlumnoDAO un método que permita buscar a todos los alumnos que comparten curso.
 */
public class AlumnoDAO {
    private final Connection con;
    private final String USUARIO = "postgres";
    private final String PASSWORD = "";
    private final String URL = "jdbc:postgresql://localhost:5432/instituto";

    public AlumnoDAO() {
        this.con = conexion();
    }
    // Conexión a la base de datos
    private Connection conexion() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
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
    public void create(Alumno alumno) {
        String sql = "INSERT INTO alumnos (num, nombre, fnac, media, curso) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = this.con.prepareStatement(sql); // Creamos el PreparedStatement
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
    public Alumno read(int id) {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumnos WHERE num = ?";

        try {
            PreparedStatement ps = this.con.prepareStatement(sql);
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
    public void update(Alumno alumno) {
        if (alumno != null) {
            String sql = "UPDATE alumnos SET nombre = ?, fnac = ?, media = ?, curso = ? WHERE num = ?";
            try {
                PreparedStatement ps = this.con.prepareStatement(sql);
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
    public void delete(int id) {
        String sql = "DELETE FROM alumnos WHERE num = ?";
        try {
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al borrar el alumno");
        }
    }

    // ACTIVIDAD 13
    public List<Alumno> todosAlumnos() {
        List<Alumno> listaAlumnos = new ArrayList<>();
        Alumno alumno;
        String sql = "SELECT * FROM alumnos";

        try {
            Statement st = this.con.createStatement();
            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                alumno = new Alumno(
                        result.getInt("num"),
                        result.getString("nombre"),
                        result.getDate("fnac"),
                        result.getDouble("media"),
                        result.getString("curso")
                );
                listaAlumnos.add(alumno);
            }
        } catch (SQLException e) {
            System.out.print("Error al leer los alumnos");
        }
        return listaAlumnos;
    }

    // ACTIVIDAD 14
    public List<Alumno> alumnosXCurso(String curso) {
        List<Alumno> listaAlumnos = new ArrayList<>();
        Alumno alumno;
        String sql = "SELECT * FROM alumnos WHERE curso = ?";

        try {
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, curso);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                alumno = new Alumno(
                        result.getInt("num"),
                        result.getString("nombre"),
                        result.getDate("fnac"),
                        result.getDouble("media"),
                        result.getString("curso")
                );
                listaAlumnos.add(alumno);
            }
        } catch (SQLException e) {
            System.out.print("Error al leer los alumnos");
        }
        return listaAlumnos;
    }
}

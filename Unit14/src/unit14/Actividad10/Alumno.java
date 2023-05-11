package unit14.Actividad10;

import java.sql.*;
import java.util.Date;

/*
    Diseñar la clase Alumno que tiene los siguientes atributos, de manera que se puede almacenar sus
    objetos en la base de datos Instituto:
    - id: Es el único identificativo único asignado a cada alumno, que sirve para distinguirlo de forma unívoca
    - nombre: del alumno, Su tamaño nunca superará los 30 caracteres. En cado de tener una longitud superior
    se acortará a 30 caracteres.
    - fecNacimiento: fecha de nacimiento del alumno
    - notaMedia: la calificación media del alumno en el curso.
    - curso:cadena formada por dos caracteres que identifica el curso donde está matriculado el alumno.
 */
public class Alumno {
    private static final int TAM_MAX_NOMBRE = 30;
    private int id;
    private String nombre;
    private Date fecNacimiento;
    private double notaMedia;
    private String curso;

    /**
     * Constructor que crea un Objeto Alumno con su identificador
     * se usa para leer los datos desde la BD a partir de la clave primaria
     * @param id Identificador del Alumno
     */
    public Alumno(int id) {
        this.id = id;
    }

    /**
     * Constructor que crea un Objeto Alumno con todos sus atributos
     * @param id Identificador del Alumno
     * @param nombre Nombre del Alumno
     * @param fecNacimiento Fecha de nacimiento del Alumno
     * @param notaMedia Nota media del Alumno
     * @param curso Curso del Alumno
     */
    public Alumno(int id, String nombre, Date fecNacimiento, double notaMedia, String curso) {
        this.id = id;
        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
        this.notaMedia = notaMedia;
        this.curso = curso;
    }


    /**
     * Crea una conexión con la base de datos. Si no se puede conectar, devuelve null
     * La responsabilidad de cerrar la conexión queda en manos de quien la use.
     * @return Conexión con la base de datos (Connection)
     */
    private static Connection conexion() {
        String url = "jdbc:postgresql://localhost:5432/instituto";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, "postgres", "");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
        }
        return con;
    }

    /**
     * Inserta un alumno en la base de datos
     */
    public void insertar() {
        // Consulta SQL para insertar un alumno
        String sql = "INSERT INTO alumnos (num, nombre, fnac, media, curso) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = conexion()) { // Se crea la conexión con la BD
            PreparedStatement ps = con.prepareStatement(sql); // Creamos el PreparedStatement
            // Asignamos los valores a los parámetros
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setDate(3, new java.sql.Date(fecNacimiento.getTime()));
            ps.setDouble(4, notaMedia);
            ps.setString(5, curso);

            ps.executeUpdate(); // Ejecutamos la consulta

        } catch (SQLException e) {
            System.out.println("Error al insertar el alumno");
        }
    }

    /**
     * Busca un alumno en la base de datos a partir de su identificador
     * Si lo encuentra devuelve un objeto Alumno con todos sus datos en caso contrario devuelve null
     * @param id Identificador del alumno
     * @return Devuelve un objeto Alumno con todos sus datos o null si no lo encuentra
     */
    public static Alumno read (int id) {
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
     * Busca en la base de datos un registro con la misma clave
     * lo lee y asigna los valores a los atributos del objeto (this)
     */
    public void read() {
        String sql = "SELECT * FROM alumnos WHERE num = ?";
        try (Connection con = conexion()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                this.nombre = result.getString("nombre");
                this.fecNacimiento = result.getDate("fnac");
                this.notaMedia = result.getDouble("media");
                this.curso = result.getString("curso");
            }
        } catch (SQLException e) {
            System.out.println("Error al leer el alumno");
        }
    }

    /**
     * Actualiza los datos de un alumno en la base de datos con los valores de los atributos del objeto (this)
     */
    public void update() {
        String sql = "UPDATE alumnos SET nombre = ?, fnac = ?, media = ?, curso = ? WHERE num = ?";
        try (Connection con = conexion()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setDate(2, new java.sql.Date(fecNacimiento.getTime()));
            ps.setDouble(3, notaMedia);
            ps.setString(4, curso);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el alumno");
        }
    }

    /**
     * Eliminar el registro del objeto this de la Base de Datos
     */
    public void delete() {
        String sql = "DELETE FROM alumnos WHERE num = ?";
        try (Connection con = conexion()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el alumno");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre.trim();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.substring(0, Math.min(nombre.length(), TAM_MAX_NOMBRE));
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        if (curso.matches("^[1-4][A-D]$"))
            this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno [id=" + id + ", nombre=" + nombre + ", fecNacimiento=" + fecNacimiento + ", notaMedia="
                + notaMedia + ", curso=" + curso + "]";
    }


}

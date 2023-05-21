package unit14.Actividad15_Aplicacion.DAO;

import unit14.Actividad15_Aplicacion.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements DAO<Empleado>{
    private final Connection conexion; // Conexión con la base de datos
    private final String USER = "postgres"; // Usuario de la base de datos
    private final String PASSWORD = ""; // Contraseña de la base de datos
    private final String URL = "jdbc:postgresql://localhost:5432/empleado"; // URL de la base de datos

    public EmpleadoDAO() {
        conexion = getConnection();
    }

    private Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
        }
        return con;
    }

    @Override
    public Empleado read (String id) {
        Empleado empleado = null;
        if (conexion != null) {
            String query = "SELECT * FROM empleado WHERE numemp = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    empleado = extractEmpleadoFromResultSet(rs);
                }
            } catch (SQLException e) {
                System.out.println("Error al leer el empleado");
            }
        }
        return empleado;
    }

    @Override
    public List<Empleado> readAll() {
        List<Empleado> empleados = new ArrayList<>();
        if (conexion != null) {
            String query = "SELECT * FROM empleado";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    empleados.add(extractEmpleadoFromResultSet(rs));
                }
            } catch (SQLException e) {
                System.out.println("Error al leer los empleados");
            }
        }
        return empleados;
    }

    public List<Empleado> readAllRangeAge(int min, int max) {
        List<Empleado> empleados = new ArrayList<>();
        if (conexion != null) {
            String query = "SELECT * FROM empleado WHERE edad BETWEEN ? AND ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, min);
                ps.setInt(2, max);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    empleados.add(extractEmpleadoFromResultSet(rs));
                }
            } catch (SQLException e) {
                System.out.println("Error al leer los empleados");
            }
        }
        return empleados;
    }

    @Override
    public void insert(Empleado empleado) {
        if (conexion != null) {
            String query = "INSERT INTO empleado VALUES (DEFAULT, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, empleado.getNombre());
                ps.setInt(2, empleado.getEdad());
                ps.setInt(3, empleado.getOficina().getOficina());
                ps.setString(4, empleado.getPuesto());
                ps.setDate(5, Date.valueOf(empleado.getContrato()));
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void update(Empleado empleado) {
        if (conexion != null) {
            String query = "UPDATE empleado SET nombre = ?, edad = ?, oficina = ?, puesto = ?, contrato = ? WHERE numemp = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, empleado.getNombre());
                ps.setInt(2, empleado.getEdad());
                ps.setInt(3, empleado.getOficina().getOficina());
                ps.setString(4, empleado.getPuesto());
                ps.setDate(5, Date.valueOf(empleado.getContrato()));
                ps.setInt(6, empleado.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error al actualizar el empleado");
            }
        }
    }

    @Override
    public void delete(Empleado empleado) {
        if (conexion != null) {
            String query = "DELETE FROM empleado WHERE numemp = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, empleado.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error al eliminar el empleado");
            }
        }

    }

    private Empleado extractEmpleadoFromResultSet(ResultSet rs) throws SQLException {
        OficinaDAO oficinaDAO = new OficinaDAO();
        return new Empleado(
                rs.getInt("numemp"),
                rs.getString("nombre"),
                rs.getInt("edad"),
                oficinaDAO.read(rs.getString("oficina")),
                rs.getString("puesto"),
                rs.getDate("contrato").toLocalDate()
        );
    }

}



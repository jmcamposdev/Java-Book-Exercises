package unit14.Actividad15_Aplicacion.DAO;

import unit14.Actividad15_Aplicacion.Oficina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OficinaDAO implements DAO<Oficina> {
    private final Connection conexion; // Conexión con la base de datos
    private final String USER = "postgres"; // Usuario de la base de datos
    private final String PASSWORD = ""; // Contraseña de la base de datos
    private final String URL = "jdbc:postgresql://localhost:5432/empleado"; // URL de la base de datos

    public OficinaDAO() {
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
    public Oficina read(String id) {
        Oficina oficina = null;
        if (conexion != null) {
            String query = "SELECT * FROM oficina WHERE oficina = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, Integer.parseInt(id));
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    oficina = extractOficinaFromResultSet(rs);
                }
            } catch (SQLException e) {
                System.out.println("Error al leer la oficina");
            }
        }
        return oficina;
    }

    public List<Oficina> readAll() {
        List<Oficina> oficinas = new ArrayList<>();
        if (conexion != null) {
            String query = "SELECT * FROM oficina";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    oficinas.add(extractOficinaFromResultSet(rs));
                }
            } catch (SQLException e) {
                System.out.println("Error al leer las oficinas");
            }
        }
        return oficinas;
    }

    @Override
    public void insert(Oficina oficina) {
        if (conexion != null) {
            String query = "INSERT INTO oficina VALUES (DEFAULT, ?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, oficina.getCiudad());
                ps.setInt(2, oficina.getSuperficie());
                ps.setInt(3, oficina.getVentas());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error al insertar la oficina");
            }
        }
    }

    public void update (Oficina oficina) {
        if (conexion != null) {
            String query = "UPDATE oficina SET ciudad = ?, superficie = ?, ventas = ? WHERE oficina = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, oficina.getCiudad());
                ps.setInt(2, oficina.getSuperficie());
                ps.setInt(3, oficina.getVentas());
                ps.setInt(4, oficina.getOficina());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error al actualizar la oficina");
            }
        }
    }

    public void delete (Oficina oficina) {
        if (conexion != null) {
            String query = "DELETE FROM oficina WHERE oficina = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, oficina.getOficina());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error al eliminar la oficina");
            }
        }
    }

    private Oficina extractOficinaFromResultSet(ResultSet rs) throws SQLException {
        return new Oficina(rs.getInt("oficina"), rs.getString("ciudad"), rs.getInt("superficie"), rs.getInt("ventas"));
    }



}

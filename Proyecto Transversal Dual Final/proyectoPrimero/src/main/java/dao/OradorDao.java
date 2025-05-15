package dao;

import modelo.Orador;
import modelo.PuntuacionOrador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OradorDao extends JdbcDao {

    // 1. Listado de mejores oradores ordenados por puntuación
    public List<Orador> obtenerMejoresOradoresOrdenados() throws SQLException {
        List<Orador> lista = new ArrayList<>();
        String sql = "SELECT o.id, o.nombre, SUM(p.puntuacion) AS total_puntuacion " +
                     "FROM Oradores o JOIN PuntuacionesOradores p ON o.id = p.id_orador " +
                     "GROUP BY o.id, o.nombre " +
                     "ORDER BY total_puntuacion DESC";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Orador o = new Orador();
                o.setId(rs.getInt("id"));
                o.setNombre(rs.getString("nombre"));
                o.setPuntuacionTotal(rs.getInt("total_puntuacion")); // Añade este atributo en Orador
                lista.add(o);
            }
        }
        return lista;
    }

    // 2. Consulta del detalle de la puntuación del mejor orador
    public PuntuacionOrador obtenerDetallePuntuacionMejorOrador(int idOrador) throws SQLException {
        String sql = "SELECT * FROM PuntuacionesOradores WHERE id_orador = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idOrador);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    PuntuacionOrador detalle = new PuntuacionOrador();
                    detalle.setId(rs.getInt("id"));
                    detalle.setIdOrador(rs.getInt("id_orador"));
                    detalle.setPuntuacion(rs.getInt("puntuacion"));
                    detalle.setIdFase(rs.getInt("id_fase"));
                    detalle.setDetalle(rs.getString("detalle"));
                    return detalle;
                }
            }
        }
        return null;
    }
}
package dao;

import modelo.Equipo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoDao extends JdbcDao {

    // 3. Listados equipos clasificados por fases
    public List<Equipo> obtenerEquiposClasificadosPorFase(int idFase) throws SQLException {
        List<Equipo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Equipos WHERE id_fase = ? AND clasificado = TRUE";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFase);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Equipo e = new Equipo();
                    e.setId(rs.getInt("id"));
                    e.setNombre(rs.getString("nombre"));
                    e.setIdFase(rs.getInt("id_fase"));
                    e.setClasificado(rs.getBoolean("clasificado"));
                    lista.add(e);
                }
            }
        }
        return lista;
    }

    // 4. Listado equipos participantes por fases
    public List<Equipo> obtenerEquiposParticipantesPorFase(int idFase) throws SQLException {
        List<Equipo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Equipos WHERE id_fase = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFase);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Equipo e = new Equipo();
                    e.setId(rs.getInt("id"));
                    e.setNombre(rs.getString("nombre"));
                    e.setIdFase(rs.getInt("id_fase"));
                    e.setClasificado(rs.getBoolean("clasificado"));
                    lista.add(e);
                }
            }
        }
        return lista;
    }
}

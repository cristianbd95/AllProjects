package misrcPaginacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpCrud {

    public List<Medico> mostrarConsultas(Connection conexion, int start, int end) {
        List<Medico> medicos_al = new ArrayList<Medico>();
        String query = "Select * from consulta limit " + (start - 1) + "," + end;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Medico medico = new Medico(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                medicos_al.add(medico);
            }
            ps.close();
        } catch (SQLException ex) {
            medicos_al = null;
        }

        return medicos_al;
    }

    public int totalConsultas(Connection conexion) {
        int total = 0;
        String query = "select count(*) from consulta;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
            ps.close();
        } catch (SQLException ex) {
            total = 0;
        }

        return total;
    }

}

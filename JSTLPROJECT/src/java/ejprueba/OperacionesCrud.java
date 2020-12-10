package ejprueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperacionesCrud {
    
    public List<String> obtenerTodasBaseDatos(Connection conexion) {
        List<String> tablas_al = new ArrayList<String>();
        String query = "SHOW DATABASES;";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                tablas_al.add(rs.getString(1));
            }
            ps.close();

        } catch (SQLException ex) {
            tablas_al = null;
        }

        return tablas_al;
    }
    
    public List<String> obtenerTodasTablasBaseDatos(Connection conexion, String database) {
        List<String> tablas_al = new ArrayList<String>();
        String query1 = "USE " + database + ";";
        String query = "SHOW TABLES;";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(query1);
            rs = ps.executeQuery();
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                tablas_al.add(rs.getString(1));
            }
            ps.close();

        } catch (SQLException ex) {
            tablas_al = null;
        }

        return tablas_al;
    }
    
    
    
}

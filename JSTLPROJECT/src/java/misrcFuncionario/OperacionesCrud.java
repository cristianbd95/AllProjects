
package misrcFuncionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OperacionesCrud {
    
    public List<String> obtenerFuncionario(int id ,Connection conexion) {
        List<String> funcionarios_al = new ArrayList<String>();
        String query = "select * from funcionarios WHERE id = " + id + ";" ;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                funcionarios_al.add(rs.getString(1));
                funcionarios_al.add(rs.getString(2));
                funcionarios_al.add(rs.getString(3));
            }
            ps.close();

        } catch (SQLException ex) {
            funcionarios_al = null;
        }

        return funcionarios_al;

    }
    
    public List<String> mostrarFuncionarios(Connection conexion) {
        List<String> funcionarios_al = new ArrayList<String>();
        String query = "select * from funcionarios;" ;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                funcionarios_al.add(rs.getString(1));
                funcionarios_al.add(rs.getString(2));
                funcionarios_al.add(rs.getString(3));
            }
            ps.close();

        } catch (SQLException ex) {
            funcionarios_al = null;
        }

        return funcionarios_al;

    }
    
        public boolean crearUsuario(String id, String nombre, int password, Connection conexion) {

        String query = "INSERT INTO funcionarios (id, nombre, password) VALUES ('" 
                        + id + "','" + nombre + "', " + password + ");";
        boolean bandera = false;
        try {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.executeUpdate();
            bandera = true;
        } catch (SQLException ex) {
            bandera=false;
        }
        return bandera;
    }
    
    
}

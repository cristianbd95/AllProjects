package factoria2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperacionCrud {
    
    private Connection conexion;

    public OperacionCrud(Connection conexion) {
        this.conexion = conexion;
    }
    
    

    public List<Vendedor> obtenerListaVendedores() {
        List<Vendedor> vendedores_al= new ArrayList<Vendedor>();
        String mysql = "SELECT Nombre,idVendedor FROM vendedor";
        try {
            Statement sql=conexion.createStatement();
            ResultSet rs = sql.executeQuery(mysql);
            while(rs.next()){
                Vendedor vendedor = new Vendedor();
                vendedor.setNombre(rs.getString(1));
                vendedor.setIdVendedor(rs.getInt(2));
                vendedores_al.add(vendedor);
            }
        } catch (SQLException ex) {
            System.out.println("Error");
            vendedores_al=null;
        }
        return vendedores_al;
    }
    
    public Vendedor Validar(String user, int idV) {
        Vendedor vendedor = null;
        String query = "SELECT Nombre,idVendedor FROM vendedor WHERE Nombre=? AND idVendedor=?;";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1,user);
            ps.setInt(2,idV);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                vendedor = new Vendedor();
                vendedor.setNombre(rs.getString(1));
                vendedor.setIdVendedor(rs.getInt(2));
            }
        } catch (SQLException ex) {
            System.out.println("Error");
        }
        return vendedor;
    }
}

package misrcMenu;

//CONTIENE LOS METODOS PARA REVISAR OPERACIONES DE LA BBDD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesCrud {

    private Connection conexion;

    public OperacionesCrud(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crearTabla() {
        boolean bandera = true;
        try {
            String query = "create table Empleado  (id INT, nombre VARCHAR(30), salario float)"; // tambien se puede hacer asi la query
            Statement sql = conexion.createStatement();
            sql.executeUpdate("create table Empleado  ("
                    + "id           INT , "
                    + "nombre VARCHAR(30), "
                    + "salario          float " //el ultimo campo nunca lleva coma
                    + ")"
            );
            sql.close();
        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    public boolean insertarEmpleado(Empleado empleado) {
        boolean bandera = true;
        String query = "INSERT INTO empleado (id, nombre, salario) VALUES (" + empleado.getId() + ",'" + empleado.getNombre() + "', " + empleado.getSalario() + ")";
        int x = -1;
        try {
            Statement sql = conexion.createStatement();
            x = sql.executeUpdate(query);
        } catch (SQLException ex) {
            bandera = false;
        }
        return bandera;
    }

    public List<Empleado> mostrarEmpleado() {
        List<Empleado> empleado_al = new ArrayList<Empleado>();
        String query = "SELECT * FROM empleado;";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("id"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setSalario(rs.getFloat("salario"));
                empleado_al.add(empleado);
            }
            ps.close();

        } catch (SQLException ex) {
            empleado_al = null;
        }

        return empleado_al;
    }

    public List<Empleado> buscarEmpleado(int id) {
        List<Empleado> empleado_al = new ArrayList<Empleado>();
        String query = "Select * from empleado where id = " + id + ";";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("id"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setSalario(rs.getFloat("salario"));
                empleado_al.add(empleado);
            }
        } catch (SQLException ex) {
            empleado_al = null;
        }

        return empleado_al;
    }
    
    public boolean eliminarEmpleado(int id){
        boolean bandera = false;
        String query = "DELETE FROM empleado WHERE id = " + id + ";";
        
        try {
            Statement sql = conexion.createStatement();
            sql.executeUpdate(query);
            bandera = true;
        } catch (SQLException ex) {
            bandera = false;
        }
        return bandera;
    }
    
    
    public boolean actualizarEmpleado(Empleado empleado) {
        boolean bandera = false;
        String query = "UPDATE empleado SET nombre='"+ empleado.getNombre() + "', salario= " + empleado.getSalario() + "WHERE id = " + empleado.getId() + ";";
        
        int x = -1;
        try {
            Statement sql = conexion.createStatement();
            x = sql.executeUpdate(query);
            bandera = true;
        } catch (SQLException ex) {
            bandera = false;
        }
        return bandera;

    }
}

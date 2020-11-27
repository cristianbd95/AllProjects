/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misrcAficionado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import misrcMenu.Empleado;

/**
 *
 * @author Campus FP
 */
public class OCAficionado {

    private Connection conexion;

    public OCAficionado(Connection conexion) {
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

    public boolean registrarAficionado(Aficionado aficionado) {
        boolean bandera = true;
        String query = "INSERT INTO aficionado (nombre, fecha-nacimiento, ciudad, estadocivil) VALUES ('" + aficionado.getNombre() + "','" + aficionado.getFechanacimiento() 
                                                                                                          + "', '" + aficionado.getCiudad() + "', '" + aficionado.getEstadocivil() + "')";
        String queryClub = null;
        int x = -1;
        try {
            Statement sql = conexion.createStatement();
            x = sql.executeUpdate(query);
            for (int i = 0; i < aficionado.getAficionado_al().size(); i++) {
                queryClub = "INSERT INTO clubsAficionado (idAficionado, idClub) VALUE(" + aficionado.getIdaficionado() + ", " + aficionado.aficionado_al.get(i) + ")";
                x = sql.executeUpdate(queryClub);
            }
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

    public boolean eliminarEmpleado(int id) {
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
        String query = "UPDATE empleado SET nombre='" + empleado.getNombre() + "', salario= " + empleado.getSalario() + "WHERE id = " + empleado.getId() + ";";

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
    
    public List<Club> guardarNombreClub() {
        List<Club> club_al = new ArrayList<Club>();
        
        String query = "select id from clubs;";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Club club = new Club();
                club.setId(rs.getString("id"));
                club_al.add(club);
            }
        } catch (SQLException ex) {
            club_al = null;
        }
        return club_al;

    }
}

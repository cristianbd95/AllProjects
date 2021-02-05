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

    public boolean registrarAficionado(Aficionado aficionado) {
        boolean bandera = false;
        String query = "INSERT INTO `aficionado` (`nombre`, `fecha-nacimiento`, `ciudad`, `estadocivil`) VALUES ('" + aficionado.getNombre() + "','2020-09-09', '" + aficionado.getCiudad() + "', '" + aficionado.getEstadocivil() + "')";
        String queryClub = null;
        PreparedStatement sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            sql = conexion.prepareStatement(query);
            sql.executeUpdate();
            String queryprueba = "SELECT * FROM aficionado ORDER BY idaficionado DESC limit 1;";
            sql = conexion.prepareStatement(queryprueba);
            rs = sql.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < aficionado.getAficionado_al().size(); i++) {
                    queryClub = "INSERT INTO `clubaficionado` (`idAficionado`, `idClub`) VALUES('" + rs.getInt(1) + "', '" + aficionado.aficionado_al.get(i) + "')";
                    sql = conexion.prepareStatement(queryClub);
                    sql.executeUpdate();
                }
            }
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
    
    public List<String> mostrarTablaAficionado() {
        List<String> aficionado_al = new ArrayList<String>();
        String query = "select  clubAficionado.idaficionado, aficionado.nombre, clubAficionado.idClub from clubAficionado INNER JOIN aficionado ON aficionado.idaficionado = clubAficionado.idAficionado WHERE aficionado.idaficionado = clubAficionado.idaficionado;";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                aficionado_al.add("<br>" + rs.getString(1)+ " " + rs.getString(2)+ " " + rs.getString(3)+ "\n <br>");
            }
            ps.close();

        } catch (SQLException ex) {
            aficionado_al = null;
        }

        return aficionado_al;
    }
    
    public int eliminarAficionado(int x){
        String query = "DELETE FROM aficionado WHERE idaficionado=" + x + ";";
        String query2 = "DELETE FROM clubAficionado WHERE idAficionado=" + x + ";";

        try {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.executeUpdate();
            PreparedStatement sql2 = conexion.prepareStatement(query2);
            sql2.executeUpdate();

        } catch (SQLException ex) { 
            System.out.println("ERROR DELETE");
        }
        return x;
    }
    
        
    public int sacarIdAficionado() {
        int idAf = 0;
        String query = "SELECT * FROM aficionado ORDER BY idaficionado DESC limit 1;";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                idAf = rs.getInt(1);
            }
            ps.close();

        } catch (SQLException ex) {
            idAf = 0;
        }

        return idAf;
    }
}

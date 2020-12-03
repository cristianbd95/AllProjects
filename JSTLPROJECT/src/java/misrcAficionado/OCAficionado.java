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
        boolean bandera = true;
        String query = "INSERT INTO `aficionado` (`nombre`, `fecha-nacimiento`, `ciudad`, `estadocivil`) VALUES ('" + aficionado.getNombre() + "','" + aficionado.getFechanacimiento()
                + "', '" + aficionado.getCiudad() + "', '" + aficionado.getEstadocivil() + "')";
        String queryClub = null;
        int x = -1;
        try {
            Statement sql = conexion.createStatement();
            x = sql.executeUpdate(query);
            for (int i = 0; i < aficionado.getAficionado_al().size(); i++) {
                queryClub = "INSERT INTO `clubaficionado` (`idAficionado`, `idClub`) VALUES('" + aficionado.getIdaficionado() + "', '" + aficionado.aficionado_al.get(i) + "')";
                x = sql.executeUpdate(queryClub);
            }
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

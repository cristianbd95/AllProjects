/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos25112020;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import misrc13112020.Alumno;

public class OperacionesCrud {
    private Connection conexion;

    public OperacionesCrud(Connection conexion) {
        this.conexion = conexion;
    }
    public List<Consulta> obtenerTodasLasConsultas() {
        List<Consulta> consultas_al = new ArrayList<Consulta>();
        String query = "select * from consulta";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Consulta consulta = new Consulta(rs.getString(1),
                        rs.getDate(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                consultas_al.add(consulta);
            }
            ps.close();

        } catch (SQLException ex) {
            consultas_al = null;
        }

        return consultas_al;

    }
}

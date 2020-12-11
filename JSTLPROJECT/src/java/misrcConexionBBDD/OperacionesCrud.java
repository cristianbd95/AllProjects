package misrcConexionBBDD;;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperacionesCrud {

    
    
    public boolean crearTabla(Connection conexion) {
        boolean bandera = true;
        try {
            Statement sql = conexion.createStatement();
            sql.executeUpdate("create table Alumno ("
                    + "id               VARCHAR(15) , "
                    + "nombresApellidos VARCHAR(100), "
                    + "carrera          VARCHAR(50) , "
                    + "direccion        VARCHAR(120), "
                    + "mail             VARCHAR(70) , "
                    + "edad             INTEGER     , "
                    + "telefono         INTEGER       "
                    + ");"
            );
            sql.close();
        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }

    /**
     * Método para verificar si exite la tabla alumno
     */
    public boolean existeTabla(Connection conexion) {
        boolean bandera = true;
        try {
            Statement sql = conexion.createStatement();
            ResultSet rs = sql.executeQuery("select * from Alumno");
            rs.close();
            sql.close();
        } catch (SQLException e) {
            bandera = false;
        }
        return bandera;
    }
    
    public List<Alumno> mostrarAlumno(Connection conexion) {
        List<Alumno> alumnos_al = new ArrayList<Alumno>();
        String query = "select * from alumno;";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                alumnos_al.add(alumno);
            }
            ps.close();

        } catch (SQLException ex) {
            alumnos_al = null;
        }

        return alumnos_al;

    }
    
    public boolean crearAlumno(Alumno alumno, Connection conexion) {

        String query = "INSERT INTO alumno (id, nombresapellidos, carrera, direccion, mail, edad, telefono) VALUES ('" 
                        + alumno.getId() + "','" + alumno.getNombresApellidos() + "', '" + alumno.getCarrera() + "' ,'" + alumno.getDireccion() + "', '" + alumno.getEmail() + "', " + alumno.getEdad() + ", " + alumno.getTelefono() + ");";
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
    
    public boolean actualizarAlumno(int id, Alumno alumno, Connection conexion) {
        String query = "UPDATE alumno SET nombresapellidos = '" + alumno.getNombresApellidos() + "', carrera = '" + alumno.getCarrera() + "', direccion = '" + alumno.getDireccion() 
                        + "', mail = '" + alumno.getEmail()+ "', edad = " + alumno.getEdad() +  ", telefono = " + alumno.getTelefono()+ " WHERE id = '" + id + "';";
        boolean bandera = false;
        try {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.executeUpdate();
            bandera = true;
            
        } catch (SQLException ex) {
            bandera = false;
        }
        
        return bandera;
    }
    
    public boolean borrarAlumno(int id, Connection conexion) {
        String query = "DELETE FROM alumno WHERE id=" + id + ";";
        boolean bandera = false;

        try {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.executeUpdate();
            bandera = true;
        } catch (SQLException ex) {
            bandera = false;
        }
        return bandera;
    }

}

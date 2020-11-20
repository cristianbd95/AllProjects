package misrc13112020;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesCrud implements Operaciones {

    private Connection conexion;

    public OperacionesCrud(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Alumno> obtenerTodosLosAlumnos() {
        List<Alumno> alumnos_al = new ArrayList<Alumno>();
        String query = "select * from Alumno";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5));
                alumnos_al.add(alumno);
            }
            ps.close();

        } catch (SQLException ex) {
            alumnos_al = null;
        }

        return alumnos_al;

    }

    @Override
    public Alumno buscarAlumnoPorId(int id) {
        String query = "select * from Alumno where id = " + id;
        Alumno alumno = new Alumno();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                alumno = new Alumno(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5));
            }
            ps.close();

        } catch (SQLException ex) {
            alumno = null;
        }

        return alumno;

    }

    @Override
    public List<Alumno> buscarAlumnoPorApellido(String apellido) {
        List<Alumno> alumnos_al = new ArrayList<Alumno>();
        String query = "select * from Alumno where apellidos LIKE '" + apellido + "%'";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5));
                alumnos_al.add(alumno);
            }
            ps.close();

        } catch (SQLException ex) {
            alumnos_al = null;
        }

        return alumnos_al;
    }

    @Override
    public Alumno obtenerUltimoAlumno() {

        String query = "select * from Alumno ORDER BY id DESC limit 1;";
        Alumno alumno = new Alumno();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                alumno = new Alumno(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5));
            }
            ps.close();

        } catch (SQLException ex) {
            alumno = null;
        }

        return alumno;
    }

    @Override
    public int crearAlumno(Alumno alumno) {

        String query = "INSERT INTO Alumno (id, nombre, apellidos, grupo, fecha_nacimiento) VALUES (" + alumno.getId() + ",'" + alumno.getNombre() + "', '" + alumno.getApellidos() + "' ,'" + alumno.getGrupo() + "', '" + alumno.getFecha_nac() + "');";
        int x = -1;
        try {
            PreparedStatement sql = conexion.prepareStatement(query);
            x = sql.executeUpdate();
        } catch (SQLException ex) {
            alumno = null;
        }
        System.out.println(x);
        return x;
    }

    @Override
    public int actualizarAlumno(int id, Alumno alumno) {
        String query = "UPDATE alumno SET id = '" + alumno.getId() + "', nombre = '" + alumno.getNombre() + "', apellidos = '" + alumno.getApellidos() + "', grupo = '" + alumno.getGrupo() + "', fecha_nacimiento = '" + alumno.getFecha_nac() + "' WHERE id = " + id + ";";
        int x = -1;
        try {
            PreparedStatement sql = conexion.prepareStatement(query);
            x = sql.executeUpdate();

        } catch (SQLException ex) {
            alumno = null;
        }
        System.out.println(x);
        return x;
    }

    @Override
    public int borrarAlumno(int id) {
        String query = "DELETE FROM alumno WHERE id=" + id + ";";
        int x = -1;

        try {
            PreparedStatement sql = conexion.prepareStatement(query);
            x = sql.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(x);
        return x;
    }

    @Override
    public boolean existeTablaAlumno() {
        boolean bandera = false;
        String query = "SHOW TABLES LIKE 'alumno';";
        PreparedStatement sql;
        try {
            sql = conexion.prepareStatement(query);
            sql.executeUpdate();
            if (bandera = true) {
                System.out.println("La tabla existe");
            }
        } catch (SQLException ex) {
            bandera = false;
        }

        return bandera;
    }

    @Override
    public boolean borrarTablaAlumno() {
        boolean bandera = false;
        String query = "drop table alumno;";
        PreparedStatement sql;
        try {
            sql = conexion.prepareStatement(query);
            sql.executeUpdate();
            if (bandera = true) {
                System.out.println("La tabla ha sido eliminada");
            }
        } catch (SQLException ex) {
            bandera = false;
        }

        return bandera;
    }

    @Override
    public List<String> obtenerTodasTablasBaseDatos() {
        List<String> tablas_al = new ArrayList<String>();
        String query = "SHOW TABLES;";

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

    @Override
    public List<String> obtenerTodasBaseDatos() {
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

    @Override
    public List<String> obtenerTodasColumnasTablaAlumno() {
        List<String> columns_al = new ArrayList<String>();
        String query = "Show columns FROM alumno;";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareCall(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                columns_al.add(rs.getString(1));
            }
            ps.close();
        } catch (SQLException ex) {
            columns_al = null;
            System.out.println("error");
        }

        return columns_al;

    }

    @Override
    public List<String> obtenerTodasTablasDadoBaseDatos(String database) {
        List<String> columns_al = new ArrayList<String>();
        String query = "SELECT table_name FROM information_schema.tables WHERE table_schema = '" + database + "';";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareCall(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                columns_al.add(rs.getString(1));
            }
            ps.close();
        } catch (SQLException ex) {
            columns_al = null;
            System.out.println("error");
        }

        return columns_al;
    }

    @Override
    public List<String> obtenerTodasColumnasDadoTabla(String tabla) {
        List<String> columns_al = new ArrayList<String>();
        String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'BD0001' AND TABLE_NAME = '" + tabla + "';;";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareCall(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                columns_al.add(rs.getString(1));
            }
            ps.close();
        } catch (SQLException ex) {
            columns_al = null;
            System.out.println("error");
        }

        return columns_al;
    }

    @Override
    public String tablaMysqlToJson(String database, String table) {
        String query = "SELECT * FROM " + database + "." + table + ";";
        String json = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareCall(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                json = "{\n"
                        + "id: " + rs.getInt(1) + ",\n"
                        + "nombre: " + rs.getString(2) + ",\n"
                        + "apellidos: " + rs.getString(3) + ",\n"
                        + "grupo: " + rs.getString(4) + ",\n"
                        + "fecha_nac: " + rs.getDate(5) + "\n"
                        + "}";
            }
            ps.close();
            System.out.println(json);
        } catch (SQLException ex) {
            System.out.println("error");
        }
        return json;
    }

    @Override
    public String tablaMysqlToXml(String database, String table) {
        String query = "SELECT * FROM " + database + "." + table + ";";
        String json = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareCall(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                json = "<alumno>\n"
                        + "<id> " + rs.getInt(1) + "</id>\n"
                        + "<nombre> " + rs.getString(2) + "</nombre>\n"
                        + "<apellidos> " + rs.getString(3) + "</apellidos>\n"
                        + "<grupo> " + rs.getString(4) + "</grupo>\n"
                        + "<fecha_nac> " + rs.getDate(5) + "</fecha_nac>\n"
                        + "</alumno>";
            }
            ps.close();
            System.out.println(json);
        } catch (SQLException ex) {
            System.out.println("error");
        }
        return json;
    }

}

package misrcPaginacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionSqlite{

    private static String url;
    private static Connection conexion;

    public ConexionSqlite(String url) {
        ConexionSqlite.url = url;
    }

    public void setConexion(boolean bandera) {
        try {
            if (bandera == true) {
                Class.forName("org.sqlite.JDBC");
                conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
                
                if (conexion != null) {
                    System.out.println("CONEXION EXITOSA");
                }
            } else {
                conexion.close();
            }
        } catch (SQLException ex) {
            conexion = null;
            System.out.println("SQLEXCEPTION --> ERROR EN ABRIR\\CERRAR CONEXION");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

}
/*
C:\\Users\\RAMON\\Documents\\clinica\\mydatabase.clinica
*/
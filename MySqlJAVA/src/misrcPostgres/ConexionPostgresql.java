
package misrcPostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionPostgresql extends Conexion{
    private Connection conexion;
    
    private static final String PROTOCOLO = "jdbc:postgresql";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String SERVERNAME = "localhost"; //"127.0.0.1";
    private static final String PORT = "5432";
    private static final String DATABASE = "universidad";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12345678";
    
    private static final String URL = PROTOCOLO + "://"
            + SERVERNAME + ":"
            + PORT + "/"
            + DATABASE;

    public ConexionPostgresql() {
    }
    
    public ConexionPostgresql(boolean flag) {
        setConexion(flag);
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
        public void setConexion(boolean flag){
        try{
            if(flag){
                Class.forName(DRIVER);
                conexion = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);

            }else{
                conexion.close();
            }
        
        }catch(SQLException e){
            conexion = null;
        } catch (ClassNotFoundException ex) {
            conexion = null;
        }
        
        
    }
    
    
}

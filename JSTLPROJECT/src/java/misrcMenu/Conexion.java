
package misrcMenu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    //PARAMETROS DE CONEXION(ATRIBUTOS DE LA CLASE)
    private Connection conexion;
    
    private static final String PROTOCOLO = "jdbc:mysql";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String SERVERNAME = "localhost"; //"127.0.0.1";
    private static final String PORT = "3306";
    private static final String DATABASE = "fabrica";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    //URL
     private static final String URL = PROTOCOLO + "://"
            + SERVERNAME + ":"
            + PORT + "/"
            + DATABASE + "?autoReconnect=true&useSSL=false";
    
    //CONSTRUCTOR DE LA CLASE
    public Conexion(){
        
    }
    
    public Conexion(boolean flag){ //la bandera true abrir conexion, si false cerrar conexion
        setConexion(flag);
    }
    
    //SET Y GET
    public void setConexion(boolean flag){
        try{
            if(flag){
                Class.forName(DRIVER);
                conexion = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
                String query = "USE " + DATABASE;
                Statement sql = conexion.createStatement();
                sql.executeUpdate(query);
            }else{
                conexion.close();
            }
        
        }catch(SQLException e){
            conexion = null;
        } catch (ClassNotFoundException ex) {
            conexion = null;
        }
        
        
    }
    public Connection getConexion(){
        return conexion;
    }
    
}
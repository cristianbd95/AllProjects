package hilos25112020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;

public class Conexion1 {

    private Connection conexion;

    private String protocolo;
    private String driver;
    private String servername;
    private String port;
    private String database;
    private String username;
    private String password;
    private String url;

    public Conexion1(boolean flag) {
        this.database = "BD0001";
        setUrl();
        setConexion(flag, "BD0001");
    }

    public Conexion1(boolean flag, String database) {
        this.database = database;
        setUrl();
        setConexion(flag, database);
    }

    public void setConexion(boolean flag, String database) {
        try {
            this.database = database;
            setUrl();
            if (flag) {
                Class.forName(this.driver);
                conexion = (Connection) DriverManager.getConnection(this.url, this.username, this.password);
                String query = "use " + database;
                Statement sql = conexion.createStatement();
                sql.executeUpdate(query);
            } else {
                conexion.close();
                conexion = null;
            }
        } catch (Exception e) {
            conexion = null;
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setUrl() {
        this.protocolo = "jdbc:mysql";
        this.driver = "com.mysql.jdbc.Driver";
        this.servername = "localhost"; //"127.0.0.1";
        this.port = "3306";
        this.username = "root";
        this.password = "";
        this.url = protocolo + "://"
                + servername + ":"
                + port + "/"
                + database + "?autoReconnect=true&useSSL=false";
    }
    
    public String getUrl() {
        return this.url;
    }

}


package misrcSqlite3;

import java.sql.Connection;


public class Main {

    public static void main(String[] args) {
        String database = "C:\\universidad\\mydatabase.universidad";
        Connection conexion;
        ConexionSqlite csl = new ConexionSqlite(database);
        csl.setConexion(true);
        conexion = csl.getConexion();
        
        OperacionesCrud oc = new OperacionesCrud();
        
        if(conexion != null){
            if(oc.crearTabla(conexion)){
                System.out.println("Crear tabla correcto");
            }else{
                System.out.println("Error Crear tabla correcto");
            }
        }else{
            System.out.println("ERROR CONEXIOn");
        }
    }
    
}

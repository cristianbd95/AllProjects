package misrcSqlite3;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OperacionesCrud {
    
    
    public boolean crearTabla(Connection conexion) {
        boolean bandera = true;
        try {
            Statement sql = conexion.createStatement();
            sql.executeUpdate("create table gestanteo(id int not null primary key, "
                    + "fecha varchar(20), "
                    + "nombre varchar(100), "
                    + "sexo varchar(20))");
            sql.close();
            System.out.println("SE CREO CORRECTAMENTE LA TABLA");
        } catch (SQLException ex) {
            System.out.println("SQLEXCEPTION --> YA EXISTE TABLA");
            bandera = false;
        }
        return bandera;
    }
    
}

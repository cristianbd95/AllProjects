/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misrcConexionBBDD;

import java.sql.Connection;

/**
 *
 * @author Campus FP
 */
public abstract class Conexion {
    
    public abstract void setConexion(boolean flag);
    public abstract Connection getConexion();
    
}

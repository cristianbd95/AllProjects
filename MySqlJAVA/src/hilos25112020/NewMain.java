/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos25112020;

import java.sql.Connection;

/**
 *
 * @author kk
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion1 c = new Conexion1(true);
        Connection conexion = c.getConexion();
        OperacionesCrud oc = new OperacionesCrud(conexion);
        
        System.out.println("=======MEDICO A JSON=======");
        if (conexion != null) {
            oc.obtenerTodasLasConsultas();

            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        
        System.out.println("=======MEDICO A JSON=======");
        if (conexion != null) {
            oc.tablaMysqlToJsonMedico("salud", "consulta");

            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
    }
    
}

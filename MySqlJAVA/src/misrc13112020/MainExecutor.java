/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misrc13112020;

import hilo6.CajeraRunnable;
import hilo6.Cliente;
import hilo6.Cuenta;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainExecutor {

    public static void main(String[] args) {
        Conexion c = new Conexion(true);
        Connection conexion = c.getConexion();
        OperacionesCrud oc = new OperacionesCrud(conexion);
        
        String json = oc.tablaMysqlToJsonMedico("salud", "consulta");
        
        
        
        int numeroRun = 3;
        
        
    }
}

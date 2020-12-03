/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misrc13112020;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainExecutor {

    public static void main(String[] args) throws InterruptedException {
        Conexion c = new Conexion(true);
        Connection conexion = c.getConexion();
        OperacionesCrud oc = new OperacionesCrud(conexion);
        
        Ventana v1 = new Ventana("Ventana 1");
        Ventana v2 = new Ventana("Ventana 2");
        Ventana v3 = new Ventana("Ventana 3");
        
        v1.setVisible(true);
        v2.setVisible(true);
        v3.setVisible(true);
        
        int numeroRun = 3;
        
        /*ExecutorService executor = Executors.newFixedThreadPool(numeroRun);
        
        Runnable cliente1 = new Cliente(oc, v1);
        Runnable cliente2 = new Cliente(oc, v2);
        Runnable cliente3 = new Cliente(oc, v3);
        
        executor.execute(cliente1);
        executor.execute(cliente2);
        executor.execute(cliente3);*/
        
        Cliente cliente1 = new Cliente(oc, v1);
        Cliente cliente2 = new Cliente(oc, v2);
        Cliente cliente3 = new Cliente(oc, v3);
        
        Thread[] hilo = new Thread[3];
        
        hilo[0] = new  Thread(cliente1);
        hilo[1] = new  Thread(cliente2);
        hilo[2] = new  Thread(cliente3);
        
        hilo[0].start();
        hilo[0].join();
        
        hilo[1].start();
        hilo[1].join();
        
        hilo[2].start();
        hilo[2].join();
        
    }
}

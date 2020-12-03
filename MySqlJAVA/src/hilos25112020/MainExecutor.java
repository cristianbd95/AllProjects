package hilos25112020;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutor {

    public static void main(String[] args) throws InterruptedException {
        final long startTime = System.currentTimeMillis();

        Conexion1 c = new Conexion1(true, "salud");
        Connection conexion = c.getConexion();

        int numeroRun = 3;

        List<Thread> hilos_al = new ArrayList<Thread>(numeroRun);
        
        for(int i = 0; i<hilos_al.size(); i++){
            Ventana v = new Ventana("Ventana " + i);
            v.setVisible(true);
            Cliente cliente = new Cliente(conexion,v);
            hilos_al.add(new Thread(cliente));
        }
        
        for (int i = 0; i<hilos_al.size();i++){
            hilos_al.get(i).start();
        }
        
        for (int i = 0; i<hilos_al.size();i++){
            hilos_al.get(i).join();
        }
        
        
        
        
     
    }

}

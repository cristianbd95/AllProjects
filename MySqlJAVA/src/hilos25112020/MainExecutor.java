package hilos25112020;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutor {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();

        Conexion1 c = new Conexion1(true, "salud");
        Connection conexion = c.getConexion();
        OperacionesCrud oc = new OperacionesCrud(conexion);

        int numeroRun = 3;

        Ventana v1 = new Ventana("Ventana 1");
        Ventana v2 = new Ventana("Ventana 2");
        Ventana v3 = new Ventana("Ventana 3");

        v1.setVisible(true);
        v2.setVisible(true);
        v3.setVisible(true);

        ExecutorService executor = Executors.newFixedThreadPool(numeroRun);

        Runnable cliente1 = new Cliente(conexion,v1);
        Runnable cliente2 = new Cliente(conexion,v2);
        Runnable cliente3 = new Cliente(conexion,v3);

        executor.execute(cliente1);
        executor.execute(cliente2);
        executor.execute(cliente3);

    }

}

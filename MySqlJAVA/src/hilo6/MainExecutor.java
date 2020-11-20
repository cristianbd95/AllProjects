package hilo6;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutor {
    public static void main(String[] args) {
        int numeroCajeras = 3;
        int numeroClientes = 7;
        int saldo = 10000;
        Cuenta cuenta = new Cuenta(saldo);
        
        { //INICIIO
        int cantidad = 100;
        
        ArrayList<Cliente> clientes_al = new ArrayList<Cliente>();
        for(int i=0; i<numeroClientes; i++) {
           clientes_al.add(new Cliente(cuenta, cantidad, (i + 1),"ingresa"));  
        }
        
        ExecutorService executor = Executors.newFixedThreadPool(numeroCajeras);
        for (Cliente cliente: clientes_al) {
            Runnable cajera = new CajeraRunnable(cliente);
            executor.execute(cajera);
        }
        executor.shutdown();
        while(!executor.isTerminated()) {
             //Espero a que terminen de ejecutarse todos los procesos 
             //para pasar a las siguientes instrucciones 
        }
        } //FIN
        
        System.out.println();
        
        { //INICIIO
        int cantidad = 200;
        
        ArrayList<Cliente> clientes_al = new ArrayList<Cliente>();
        for(int i=0; i<numeroClientes; i++) {
           clientes_al.add(new Cliente(cuenta, cantidad, (i + 1),"ingresa"));  
        }
        
        ExecutorService executor = Executors.newFixedThreadPool(numeroCajeras);
        for (Cliente cliente: clientes_al) {
            Runnable cajera = new CajeraRunnable(cliente);
            executor.execute(cajera);
        }
        executor.shutdown();
        while(!executor.isTerminated()) {
             //Espero a que terminen de ejecutarse todos los procesos
             //para pasar a las siguientes instrucciones 
        }
        } //FIN 
         
        System.out.println(); 
         
        { //INICIIO
        int cantidad = -300;
        
        ArrayList<Cliente> clientes_al = new ArrayList<Cliente>();
        for(int i=0; i<numeroClientes; i++) {
           clientes_al.add(new Cliente(cuenta, cantidad, (i + 1),"retira"));  
        }
        
        ExecutorService executor = Executors.newFixedThreadPool(numeroCajeras);
        for (Cliente cliente: clientes_al) {
            Runnable cajera = new CajeraRunnable(cliente);
            executor.execute(cajera);
        }
        executor.shutdown();
        while(!executor.isTerminated()) {
             //Espero a que terminen de ejecutarse todos los procesos 
             //para pasar a las siguientes instrucciones 
        }
        } //FIN          
    }
}
    


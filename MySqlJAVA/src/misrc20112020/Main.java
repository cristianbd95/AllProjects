
package misrc20112020;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        int numeroClientes = 1000;
        
        Cuenta cuenta = new Cuenta (0);
        
        Thread[] hilo = new Thread[numeroClientes];
        
        for(int i=0; i<numeroClientes; i++){
            Cliente cliente= new Cliente(cuenta,100);
            hilo[i] = new Thread(cliente); //convertir clientes en hilos
            hilo[i].start();//hilo se ejecuta
            hilo[i].join();
            
        }
        for (int i = 0; i<numeroClientes;i++){
            hilo[i].join();
        }
        System.out.println("Saldo : " + cuenta.getSaldo());
        /*if(cuenta.esSimulacionCorrecta()){
            System.out.println("La simulación fue correcta");
            System.out.println("Saldo : " + cuenta.getSaldo());
        }else{
            System.out.println("La simulación falló");
        }*/
        
        
          
        
    }
    
}

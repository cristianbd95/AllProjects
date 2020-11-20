/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misrc20112020;

/**
 *
 * @author Campus FP
 */
public class Main2 {

        public static void main(String[] args) throws InterruptedException {
        Ventana v1 = new Ventana("Luis");
        Ventana v2 = new Ventana("Miguel");
        Ventana v3 = new Ventana("Carlos");
        
        v1.setVisible(true);
        v2.setVisible(true);
        v3.setVisible(true);
            
        Cliente1 luis = new Cliente1("Luis",v1);
        Cliente1 miguel = new Cliente1("Miguel",v2);
        Cliente1 carlos = new Cliente1("Carlos",v3);
        
        Thread[] hilo = new Thread[3];
        
        hilo[0] = new  Thread(luis);
        hilo[1] = new  Thread(miguel);
        hilo[2] = new  Thread(carlos);
        
        hilo[0].start();
        hilo[0].join();
        
        hilo[1].start();
        hilo[1].join();
        
        hilo[2].start();
        hilo[2].join();
        
      
    }
    
}

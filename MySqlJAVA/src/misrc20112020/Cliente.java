
package misrc20112020;


public class Cliente implements Runnable{
    Cuenta cuenta;
    int cantidad;
    
    public Cliente(Cuenta cuenta, int cantidad){
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }
   
    @Override
    public void run(){
        //for(int i=0;i<100;i++){
            cuenta.hacerMovimiento(cantidad);
        //}
    }
}

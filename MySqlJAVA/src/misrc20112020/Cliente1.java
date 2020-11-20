
package misrc20112020;

public class Cliente1 implements Runnable {
    private String nombre;
    private Ventana v;

    public Cliente1() {
    }

    public Cliente1(String nombre, Ventana v) {
        this.nombre = nombre;
        this.v = v;
    }
    
    
    
    
    @Override
    public void run() {
        for(int i=0; i<1000;i++){
            v.escribir(i);
            //System.out.println(nombre + " " +i);
        }
    } 
}

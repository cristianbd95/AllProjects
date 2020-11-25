
package hilos25112020;

import java.sql.Connection;
import java.util.List;

public class Cliente implements Runnable{
    private OperacionesCrud oc;
    private Ventana v;
    
    public Cliente(){
    };
    public Cliente(Connection conexion, Ventana v){
        this.oc = oc;
        this.v = v;
        
    }

    @Override
    public void run() {
        List<Consulta> consultas_al = oc.obtenerTodasLasConsultas();
        for(int i = 0; i<consultas_al.size(); i++){
            Consulta consulta = consultas_al.get(i);
            v.escribir(consulta.toString());
        }
    }
    
}

package misrc13112020;

import java.sql.Connection;

public class Cliente implements Runnable {
    
    OperacionesCrud json;
    Ventana v;

    public Cliente(OperacionesCrud json, Ventana v) {
        this.json = json;
        this.v = v;
    }
    
    

    @Override
    public void run() {
        String x = json.tablaMysqlToJsonMedico("salud", "consulta");
        v.escribir(x);
    }

}

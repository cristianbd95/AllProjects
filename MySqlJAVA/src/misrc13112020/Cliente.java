package misrc13112020;

import java.sql.Connection;

public class Cliente implements Runnable {
    
    OperacionesCrud json;

    public Cliente(OperacionesCrud json) {
        this.json = json;
    }
    
    

    @Override
    public void run() {
        
    }

}

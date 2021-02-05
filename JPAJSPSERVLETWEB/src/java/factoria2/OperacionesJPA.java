package factoria2;

import controladores.ClienteJpaController;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class OperacionesJPA {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAJSPSERVLETWEBPU");
    EntityManager em = emf.createEntityManager();
    ClienteJpaController cjc = new ClienteJpaController(emf);
    
    public Cliente buscar(int idCliente) {
        Cliente cliente = cjc.findCliente(idCliente);

        return cliente;
    }
    public List<Cliente> BuscarTodosClientes(){
        List<Cliente> clientes_al = cjc.findClienteEntities();
        List<Cliente> clientes_al2 = new ArrayList<Cliente>();
        for(int i=0; i<clientes_al.size();i++){
            Cliente cliente = clientes_al.get(i);
            
            
        }
        return clientes_al;
    }
    
    
    
    
}

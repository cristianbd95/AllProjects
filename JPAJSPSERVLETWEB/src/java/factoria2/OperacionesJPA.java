package factoria2;

import controladores.ClienteJpaController;
import entidades.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class OperacionesJPA {
    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAJSPSERVLETWEBPU");
    static EntityManager em = emf.createEntityManager();
    static ClienteJpaController cjc = new ClienteJpaController(emf);
    
    public Cliente buscar(int idCliente) {
        Cliente cliente = cjc.findCliente(idCliente);

        return cliente;
    }
    
    
}

package factoria2;

import controladores.VendedorJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class OperacionesJPA {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("APLICACIONWEBSERVLETPU");
    EntityManager em = emf.createEntityManager();
    VendedorJpaController vjc = new VendedorJpaController(emf);

    public List<Vendedor> obtenerListaVendedores() {
        List<Vendedor> vendedor_al = new ArrayList<Vendedor>();
        String jpql = "SELECT v.nombre, v.idVendedor FROM vendedor v";
        try {
            Query query = em.createQuery(jpql);
            vendedor_al = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error");
            vendedor_al = null;
        }
        return vendedor_al;
    }
    
    public Vendedor Validar(String nombre, int password){
        Vendedor vendedor = null;
        String jpql = "SELECT v FROM vendedor v WHERE v.nombre = '" + nombre + "' AND v.idVendedor = " + password;
        try {
            Query query = em.createQuery(jpql);
            List<Vendedor> vendedor_al = query.getResultList();
            for(int i=0; i<vendedor_al.size(); i++){
                vendedor = vendedor_al.get(i);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return vendedor;
    }
}

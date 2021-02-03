
package prueba2CamposSelect;

import controladores.ArticuloJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Controlador {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAJSPSERVLETPU");
    EntityManager em = emf.createEntityManager();
    ArticuloJpaController ajc = new ArticuloJpaController(emf);
    
    public void listarDescripcionPrecioUnitarioTodosArticulos(){
        String jpql = "select a.descripcion, a.preciounitario from articulos a";
        Query query = em.createQuery(jpql);
        List<Object[]> tuplas = (List<Object[]>) query.getResultList();
        for(Object[] tupla : tuplas){
            System.out.println("Descripcion: " + tupla[0].toString());
            System.out.println("PrecioUnitario: " + tupla[1].toString());
        }
        em.close();
    }
}

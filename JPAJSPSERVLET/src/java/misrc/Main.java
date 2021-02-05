package misrc;

import controladores.ArticuloJpaController;
import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import entidades.Articulo;
import entidades.Articuloxfactura;
import entidades.Factura;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Main {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAJSPSERVLETPU");
    static EntityManager em = emf.createEntityManager();
    static ArticuloJpaController ajc = new ArticuloJpaController(emf);

    public static void main(String[] args) {
        /*
        System.out.println("BUSCAR");
        String idArticulo = "IdA002";
        Articulo articulo = buscar(idArticulo);
        System.out.println("IdArticulo " + articulo.getIdArticulo());
        System.out.println("Descripcion " + articulo.getDescripcion());
        System.out.println("Precio " + articulo.getPrecioUnitario());
        //-------------------------------------------------
        System.out.println("MOSTRAR TODOS LOS ARTICULOS");
        List<Articulo> articulos_al = obtenerTodosObjetosArt();
        for (Articulo articulo1 : articulos_al) {
            System.out.println("IdArticulo " + articulo1.getIdArticulo());
            System.out.println("Descripcion " + articulo1.getDescripcion());
            System.out.println("Precio " + articulo1.getPrecioUnitario());
        }
        //-------------------------------------------------
        System.out.println("ELIMINAR");
        eliminarArticuloPorid(idArticulo);*/
        //-------------------------------------------------
        /*
        System.out.println("ACTUALIZAR");
        Articulo articulo2 = new Articulo();
        articulo2.setIdArticulo("IdA003");
        articulo2.setDescripcion("ReglaACTUprue22");
        //articulo2.setPrecioUnitario(2.5);
        actualizarArticulo(articulo2);
         */
        //-------------------------------------------------
        /* Articulo articulo3 = new Articulo();
        articulo3.setIdArticulo("IdA008");
        articulo3.setDescripcion("Lapicero");
        articulo3.setPrecioUnitario(3.5);
        crearArticulo(articulo3);*/
        //---- VALIDAR
        //validar("IdA005", "Compas");
        //System.out.println("OK");
        //listarDescripcionPrecioUnitarioTodosArticulos();
        //listarDescripcionPrecioUnitarioTodosArticulos2();
        //listarNumeroItemsPorFactura();
        //listarArticulosConElPrecioUnitarioMayorQueOtroArticulo("portaminas");
        listarTodosNombresArticulosEnMayusculaOrdenadoAscDistintos();
        ObtenerArticuloMaximoPrecioUnitario();
        listarArticulosPorCadaFactura_join();

    }

    public static Articulo buscar(String idArticulo) {
        Articulo articulo = ajc.findArticulo(idArticulo);

        return articulo;
    }

    public static List<Articulo> obtenerTodosObjetosArt() {
        List<Articulo> articulos_al = ajc.findArticuloEntities();

        return articulos_al;
    }

    public static int eliminar(String idArticulo) {
        int numero;
        try {
            ajc.destroy(idArticulo);
            numero = 1;
        } catch (IllegalOrphanException ex) {
            System.out.println("ERROR");
            numero = -2;
        } catch (NonexistentEntityException ex) {
            System.out.println("ERROR2");
            numero = -1;
        }
        return numero;
    }

    public static void eliminarArticuloPorid(String idArticulo) {
        try {
            //Busco el articulo
            Articulo articulo = em.find(Articulo.class, idArticulo);
            System.out.println("IdArticulo " + articulo.getIdArticulo());
            System.out.println("Descripcion " + articulo.getDescripcion());
            System.out.println("Precio " + articulo.getPrecioUnitario());
            //ELIMINO ARTICULO
            em.getTransaction().begin();
            em.remove(articulo);
            em.getTransaction().commit();
            System.out.println();
        } catch (Exception e) {
            System.out.println("NO EXISTE EL ARTICULO ");
        }
    }

    public static void actualizar(Articulo articulo) {
        try {
            ajc.edit(articulo);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void actualizarArticulo(Articulo articulo) {

        em.getTransaction().begin();
        em.merge(articulo);
        em.getTransaction().commit();
        System.out.println("ACT CORRECTA");
    }

    public static void crearArticulo(Articulo articulo) {
        try {
            em.getTransaction().begin();
            em.persist(articulo);
            em.getTransaction().commit();
            System.out.println("CREAR CORRECTO");
        } catch (Exception e) {
            System.out.println("ERROR CREAR");
        }
    }

    public static void validar(String idArticulo, String descripcion) {
        String jpql = "SELECT a FROM Articulo a WHERE a.idArticulo='" + idArticulo + "' AND a.descripcion = '" + descripcion + "'";

        Query query = em.createQuery(jpql);
        List<Articulo> articulos_al = query.getResultList();
        for (Articulo articulos5 : articulos_al) {
            System.out.println(articulos5.getDescripcion());
            System.out.println(articulos5.getIdArticulo());
        }
    }

    public static void listarDescripcionPrecioUnitarioTodosArticulos() {
        String jpql = "select a.descripcion, a.precioUnitario from Articulo a";
        Query query = em.createQuery(jpql);
        List<Object[]> tuplas = (List<Object[]>) query.getResultList();
        for (Object[] tupla : tuplas) {
            System.out.println("Descripcion: " + tupla[0].toString());
            System.out.println("PrecioUnitario: " + tupla[1].toString());
        }
        em.close();
    }

    public static void listarDescripcionPrecioUnitarioTodosArticulos2() {
        String jpql = "select NEW entidades.Articulo(a.descripcion, a.precioUnitario) from Articulo a";
        Query query = em.createQuery(jpql);
        List<Articulo> articulos_al = (List<Articulo>) query.getResultList();
        for (Articulo articulo : articulos_al) {
            System.out.println("Descripcion: " + articulo.getDescripcion());
            System.out.println("PrecioUnitario: " + articulo.getPrecioUnitario());
        }
        em.close();
    }

    public static void listarNumeroItemsPorFactura() {
        String jpql = "SELECT af.factura.idFactura, COUNT(af.factura) FROM Articuloxfactura af GROUP BY af.factura.idFactura";
        Query query = em.createQuery(jpql);
        List<Object[]> tuplas = (List<Object[]>) query.getResultList();
        for (Object[] tupla : tuplas) {
            System.out.println("IdFactura       :" + tupla[0].toString());
            System.out.println("Número items    :" + tupla[1].toString());
        }
    }

    //listar datos de los articulos cuyo precio es mayor que el que le pase yo
    public static void listarArticulosConElPrecioUnitarioMayorQueOtroArticulo(String descripcion) {
        String jpql = "SELECT a.descripcion, a.precioUnitario FROM Articulo a WHERE a.precioUnitario > SOME(SELECT b.precioUnitario FROM Articulo b WHERE b.descripcion = '" + descripcion + "')";
        Query query = em.createQuery(jpql);
        List<Object[]> tuplas = (List<Object[]>) query.getResultList();
        for (Object[] tupla : tuplas) {
            System.out.println("Descripcion: " + tupla[0].toString());
            System.out.println("PrecioUnitario: " + tupla[1].toString());
        }
        em.close();
    }

    //obtener el nombre de forma asc
    public static void listarTodosNombresArticulosEnMayusculaOrdenadoAscDistintos() {
        String jpql = "select distinct UPPER(a.descripcion) from Articulo a order by a.descripcion";
        Query query = em.createQuery(jpql);
        List<String> descripcion_al = query.getResultList();
        for (int i = 0; i < descripcion_al.size(); i++) {
            String s = (String) descripcion_al.get(i);
            System.out.println(s);
        }
    }

    //obtener el articulo con mayor precio
    public static void ObtenerArticuloMaximoPrecioUnitario() {
        String jpql = "select MAX(a.precioUnitario) from Articulo a";
        Query query = em.createQuery(jpql);
        Double resultado = (Double) query.getSingleResult();
        System.out.println("El mayor precio unitario es : " + resultado);
    }

    public static void listarArticulosPorCadaFactura_join() {
        String jpql = "SELECT distinct f FROM Factura f JOIN FETCH f.articuloxfacturaList";
        TypedQuery<Factura> facturas_tq = em.createQuery(jpql, Factura.class);
        List<Factura> facturas_al = facturas_tq.getResultList();
        for (Factura factura : facturas_al) {
            System.out.println(factura.getIdFactura() + " " + factura.getIdCliente().getNombre() );
            List<Articuloxfactura> articuloxfacturaList = factura.getArticuloxfacturaList();
            for (Articuloxfactura af : articuloxfacturaList) {
                int cantidad = af.getCantidad();
                Articulo articulo = af.getArticulo();
                System.out.println(articulo.getIdArticulo() + " " + articulo.getDescripcion() +" CANTIDAD: " + (articulo.getPrecioUnitario()*cantidad) );
            }
        }
    }

}

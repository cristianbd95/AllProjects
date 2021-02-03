/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Vendedor;
import entidades.Cliente;
import entidades.Articuloxfactura;
import entidades.Factura;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Campus FP
 */
public class FacturaJpaController implements Serializable {

    public FacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factura factura) throws PreexistingEntityException, Exception {
        if (factura.getArticuloxfacturaList() == null) {
            factura.setArticuloxfacturaList(new ArrayList<Articuloxfactura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vendedor idVendedor = factura.getIdVendedor();
            if (idVendedor != null) {
                idVendedor = em.getReference(idVendedor.getClass(), idVendedor.getIdVendedor());
                factura.setIdVendedor(idVendedor);
            }
            Cliente idCliente = factura.getIdCliente();
            if (idCliente != null) {
                idCliente = em.getReference(idCliente.getClass(), idCliente.getIdCliente());
                factura.setIdCliente(idCliente);
            }
            List<Articuloxfactura> attachedArticuloxfacturaList = new ArrayList<Articuloxfactura>();
            for (Articuloxfactura articuloxfacturaListArticuloxfacturaToAttach : factura.getArticuloxfacturaList()) {
                articuloxfacturaListArticuloxfacturaToAttach = em.getReference(articuloxfacturaListArticuloxfacturaToAttach.getClass(), articuloxfacturaListArticuloxfacturaToAttach.getArticuloxfacturaPK());
                attachedArticuloxfacturaList.add(articuloxfacturaListArticuloxfacturaToAttach);
            }
            factura.setArticuloxfacturaList(attachedArticuloxfacturaList);
            em.persist(factura);
            if (idVendedor != null) {
                idVendedor.getFacturaList().add(factura);
                idVendedor = em.merge(idVendedor);
            }
            if (idCliente != null) {
                idCliente.getFacturaList().add(factura);
                idCliente = em.merge(idCliente);
            }
            for (Articuloxfactura articuloxfacturaListArticuloxfactura : factura.getArticuloxfacturaList()) {
                Factura oldFacturaOfArticuloxfacturaListArticuloxfactura = articuloxfacturaListArticuloxfactura.getFactura();
                articuloxfacturaListArticuloxfactura.setFactura(factura);
                articuloxfacturaListArticuloxfactura = em.merge(articuloxfacturaListArticuloxfactura);
                if (oldFacturaOfArticuloxfacturaListArticuloxfactura != null) {
                    oldFacturaOfArticuloxfacturaListArticuloxfactura.getArticuloxfacturaList().remove(articuloxfacturaListArticuloxfactura);
                    oldFacturaOfArticuloxfacturaListArticuloxfactura = em.merge(oldFacturaOfArticuloxfacturaListArticuloxfactura);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFactura(factura.getIdFactura()) != null) {
                throw new PreexistingEntityException("Factura " + factura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factura factura) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura persistentFactura = em.find(Factura.class, factura.getIdFactura());
            Vendedor idVendedorOld = persistentFactura.getIdVendedor();
            Vendedor idVendedorNew = factura.getIdVendedor();
            Cliente idClienteOld = persistentFactura.getIdCliente();
            Cliente idClienteNew = factura.getIdCliente();
            List<Articuloxfactura> articuloxfacturaListOld = persistentFactura.getArticuloxfacturaList();
            List<Articuloxfactura> articuloxfacturaListNew = factura.getArticuloxfacturaList();
            List<String> illegalOrphanMessages = null;
            for (Articuloxfactura articuloxfacturaListOldArticuloxfactura : articuloxfacturaListOld) {
                if (!articuloxfacturaListNew.contains(articuloxfacturaListOldArticuloxfactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Articuloxfactura " + articuloxfacturaListOldArticuloxfactura + " since its factura field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idVendedorNew != null) {
                idVendedorNew = em.getReference(idVendedorNew.getClass(), idVendedorNew.getIdVendedor());
                factura.setIdVendedor(idVendedorNew);
            }
            if (idClienteNew != null) {
                idClienteNew = em.getReference(idClienteNew.getClass(), idClienteNew.getIdCliente());
                factura.setIdCliente(idClienteNew);
            }
            List<Articuloxfactura> attachedArticuloxfacturaListNew = new ArrayList<Articuloxfactura>();
            for (Articuloxfactura articuloxfacturaListNewArticuloxfacturaToAttach : articuloxfacturaListNew) {
                articuloxfacturaListNewArticuloxfacturaToAttach = em.getReference(articuloxfacturaListNewArticuloxfacturaToAttach.getClass(), articuloxfacturaListNewArticuloxfacturaToAttach.getArticuloxfacturaPK());
                attachedArticuloxfacturaListNew.add(articuloxfacturaListNewArticuloxfacturaToAttach);
            }
            articuloxfacturaListNew = attachedArticuloxfacturaListNew;
            factura.setArticuloxfacturaList(articuloxfacturaListNew);
            factura = em.merge(factura);
            if (idVendedorOld != null && !idVendedorOld.equals(idVendedorNew)) {
                idVendedorOld.getFacturaList().remove(factura);
                idVendedorOld = em.merge(idVendedorOld);
            }
            if (idVendedorNew != null && !idVendedorNew.equals(idVendedorOld)) {
                idVendedorNew.getFacturaList().add(factura);
                idVendedorNew = em.merge(idVendedorNew);
            }
            if (idClienteOld != null && !idClienteOld.equals(idClienteNew)) {
                idClienteOld.getFacturaList().remove(factura);
                idClienteOld = em.merge(idClienteOld);
            }
            if (idClienteNew != null && !idClienteNew.equals(idClienteOld)) {
                idClienteNew.getFacturaList().add(factura);
                idClienteNew = em.merge(idClienteNew);
            }
            for (Articuloxfactura articuloxfacturaListNewArticuloxfactura : articuloxfacturaListNew) {
                if (!articuloxfacturaListOld.contains(articuloxfacturaListNewArticuloxfactura)) {
                    Factura oldFacturaOfArticuloxfacturaListNewArticuloxfactura = articuloxfacturaListNewArticuloxfactura.getFactura();
                    articuloxfacturaListNewArticuloxfactura.setFactura(factura);
                    articuloxfacturaListNewArticuloxfactura = em.merge(articuloxfacturaListNewArticuloxfactura);
                    if (oldFacturaOfArticuloxfacturaListNewArticuloxfactura != null && !oldFacturaOfArticuloxfacturaListNewArticuloxfactura.equals(factura)) {
                        oldFacturaOfArticuloxfacturaListNewArticuloxfactura.getArticuloxfacturaList().remove(articuloxfacturaListNewArticuloxfactura);
                        oldFacturaOfArticuloxfacturaListNewArticuloxfactura = em.merge(oldFacturaOfArticuloxfacturaListNewArticuloxfactura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = factura.getIdFactura();
                if (findFactura(id) == null) {
                    throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura factura;
            try {
                factura = em.getReference(Factura.class, id);
                factura.getIdFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Articuloxfactura> articuloxfacturaListOrphanCheck = factura.getArticuloxfacturaList();
            for (Articuloxfactura articuloxfacturaListOrphanCheckArticuloxfactura : articuloxfacturaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Factura (" + factura + ") cannot be destroyed since the Articuloxfactura " + articuloxfacturaListOrphanCheckArticuloxfactura + " in its articuloxfacturaList field has a non-nullable factura field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Vendedor idVendedor = factura.getIdVendedor();
            if (idVendedor != null) {
                idVendedor.getFacturaList().remove(factura);
                idVendedor = em.merge(idVendedor);
            }
            Cliente idCliente = factura.getIdCliente();
            if (idCliente != null) {
                idCliente.getFacturaList().remove(factura);
                idCliente = em.merge(idCliente);
            }
            em.remove(factura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factura> findFacturaEntities() {
        return findFacturaEntities(true, -1, -1);
    }

    public List<Factura> findFacturaEntities(int maxResults, int firstResult) {
        return findFacturaEntities(false, maxResults, firstResult);
    }

    private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factura.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Factura findFactura(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factura.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factura> rt = cq.from(Factura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Factura;
import entidades.Articulo;
import entidades.Articuloxfactura;
import entidades.ArticuloxfacturaPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Campus FP
 */
public class ArticuloxfacturaJpaController implements Serializable {

    public ArticuloxfacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Articuloxfactura articuloxfactura) throws PreexistingEntityException, Exception {
        if (articuloxfactura.getArticuloxfacturaPK() == null) {
            articuloxfactura.setArticuloxfacturaPK(new ArticuloxfacturaPK());
        }
        articuloxfactura.getArticuloxfacturaPK().setIdArticulo(articuloxfactura.getArticulo().getIdArticulo());
        articuloxfactura.getArticuloxfacturaPK().setIdFactura(articuloxfactura.getFactura().getIdFactura());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura factura = articuloxfactura.getFactura();
            if (factura != null) {
                factura = em.getReference(factura.getClass(), factura.getIdFactura());
                articuloxfactura.setFactura(factura);
            }
            Articulo articulo = articuloxfactura.getArticulo();
            if (articulo != null) {
                articulo = em.getReference(articulo.getClass(), articulo.getIdArticulo());
                articuloxfactura.setArticulo(articulo);
            }
            em.persist(articuloxfactura);
            if (factura != null) {
                factura.getArticuloxfacturaList().add(articuloxfactura);
                factura = em.merge(factura);
            }
            if (articulo != null) {
                articulo.getArticuloxfacturaList().add(articuloxfactura);
                articulo = em.merge(articulo);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findArticuloxfactura(articuloxfactura.getArticuloxfacturaPK()) != null) {
                throw new PreexistingEntityException("Articuloxfactura " + articuloxfactura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Articuloxfactura articuloxfactura) throws NonexistentEntityException, Exception {
        articuloxfactura.getArticuloxfacturaPK().setIdArticulo(articuloxfactura.getArticulo().getIdArticulo());
        articuloxfactura.getArticuloxfacturaPK().setIdFactura(articuloxfactura.getFactura().getIdFactura());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Articuloxfactura persistentArticuloxfactura = em.find(Articuloxfactura.class, articuloxfactura.getArticuloxfacturaPK());
            Factura facturaOld = persistentArticuloxfactura.getFactura();
            Factura facturaNew = articuloxfactura.getFactura();
            Articulo articuloOld = persistentArticuloxfactura.getArticulo();
            Articulo articuloNew = articuloxfactura.getArticulo();
            if (facturaNew != null) {
                facturaNew = em.getReference(facturaNew.getClass(), facturaNew.getIdFactura());
                articuloxfactura.setFactura(facturaNew);
            }
            if (articuloNew != null) {
                articuloNew = em.getReference(articuloNew.getClass(), articuloNew.getIdArticulo());
                articuloxfactura.setArticulo(articuloNew);
            }
            articuloxfactura = em.merge(articuloxfactura);
            if (facturaOld != null && !facturaOld.equals(facturaNew)) {
                facturaOld.getArticuloxfacturaList().remove(articuloxfactura);
                facturaOld = em.merge(facturaOld);
            }
            if (facturaNew != null && !facturaNew.equals(facturaOld)) {
                facturaNew.getArticuloxfacturaList().add(articuloxfactura);
                facturaNew = em.merge(facturaNew);
            }
            if (articuloOld != null && !articuloOld.equals(articuloNew)) {
                articuloOld.getArticuloxfacturaList().remove(articuloxfactura);
                articuloOld = em.merge(articuloOld);
            }
            if (articuloNew != null && !articuloNew.equals(articuloOld)) {
                articuloNew.getArticuloxfacturaList().add(articuloxfactura);
                articuloNew = em.merge(articuloNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ArticuloxfacturaPK id = articuloxfactura.getArticuloxfacturaPK();
                if (findArticuloxfactura(id) == null) {
                    throw new NonexistentEntityException("The articuloxfactura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ArticuloxfacturaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Articuloxfactura articuloxfactura;
            try {
                articuloxfactura = em.getReference(Articuloxfactura.class, id);
                articuloxfactura.getArticuloxfacturaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The articuloxfactura with id " + id + " no longer exists.", enfe);
            }
            Factura factura = articuloxfactura.getFactura();
            if (factura != null) {
                factura.getArticuloxfacturaList().remove(articuloxfactura);
                factura = em.merge(factura);
            }
            Articulo articulo = articuloxfactura.getArticulo();
            if (articulo != null) {
                articulo.getArticuloxfacturaList().remove(articuloxfactura);
                articulo = em.merge(articulo);
            }
            em.remove(articuloxfactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Articuloxfactura> findArticuloxfacturaEntities() {
        return findArticuloxfacturaEntities(true, -1, -1);
    }

    public List<Articuloxfactura> findArticuloxfacturaEntities(int maxResults, int firstResult) {
        return findArticuloxfacturaEntities(false, maxResults, firstResult);
    }

    private List<Articuloxfactura> findArticuloxfacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Articuloxfactura.class));
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

    public Articuloxfactura findArticuloxfactura(ArticuloxfacturaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Articuloxfactura.class, id);
        } finally {
            em.close();
        }
    }

    public int getArticuloxfacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Articuloxfactura> rt = cq.from(Articuloxfactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

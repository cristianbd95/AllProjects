/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import entidades.Articulo;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Articuloxfactura;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Campus FP
 */
public class ArticuloJpaController implements Serializable {

    public ArticuloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Articulo articulo) throws PreexistingEntityException, Exception {
        if (articulo.getArticuloxfacturaList() == null) {
            articulo.setArticuloxfacturaList(new ArrayList<Articuloxfactura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Articuloxfactura> attachedArticuloxfacturaList = new ArrayList<Articuloxfactura>();
            for (Articuloxfactura articuloxfacturaListArticuloxfacturaToAttach : articulo.getArticuloxfacturaList()) {
                articuloxfacturaListArticuloxfacturaToAttach = em.getReference(articuloxfacturaListArticuloxfacturaToAttach.getClass(), articuloxfacturaListArticuloxfacturaToAttach.getArticuloxfacturaPK());
                attachedArticuloxfacturaList.add(articuloxfacturaListArticuloxfacturaToAttach);
            }
            articulo.setArticuloxfacturaList(attachedArticuloxfacturaList);
            em.persist(articulo);
            for (Articuloxfactura articuloxfacturaListArticuloxfactura : articulo.getArticuloxfacturaList()) {
                Articulo oldArticuloOfArticuloxfacturaListArticuloxfactura = articuloxfacturaListArticuloxfactura.getArticulo();
                articuloxfacturaListArticuloxfactura.setArticulo(articulo);
                articuloxfacturaListArticuloxfactura = em.merge(articuloxfacturaListArticuloxfactura);
                if (oldArticuloOfArticuloxfacturaListArticuloxfactura != null) {
                    oldArticuloOfArticuloxfacturaListArticuloxfactura.getArticuloxfacturaList().remove(articuloxfacturaListArticuloxfactura);
                    oldArticuloOfArticuloxfacturaListArticuloxfactura = em.merge(oldArticuloOfArticuloxfacturaListArticuloxfactura);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findArticulo(articulo.getIdArticulo()) != null) {
                throw new PreexistingEntityException("Articulo " + articulo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Articulo articulo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Articulo persistentArticulo = em.find(Articulo.class, articulo.getIdArticulo());
            List<Articuloxfactura> articuloxfacturaListOld = persistentArticulo.getArticuloxfacturaList();
            List<Articuloxfactura> articuloxfacturaListNew = articulo.getArticuloxfacturaList();
            List<String> illegalOrphanMessages = null;
            for (Articuloxfactura articuloxfacturaListOldArticuloxfactura : articuloxfacturaListOld) {
                if (!articuloxfacturaListNew.contains(articuloxfacturaListOldArticuloxfactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Articuloxfactura " + articuloxfacturaListOldArticuloxfactura + " since its articulo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Articuloxfactura> attachedArticuloxfacturaListNew = new ArrayList<Articuloxfactura>();
            for (Articuloxfactura articuloxfacturaListNewArticuloxfacturaToAttach : articuloxfacturaListNew) {
                articuloxfacturaListNewArticuloxfacturaToAttach = em.getReference(articuloxfacturaListNewArticuloxfacturaToAttach.getClass(), articuloxfacturaListNewArticuloxfacturaToAttach.getArticuloxfacturaPK());
                attachedArticuloxfacturaListNew.add(articuloxfacturaListNewArticuloxfacturaToAttach);
            }
            articuloxfacturaListNew = attachedArticuloxfacturaListNew;
            articulo.setArticuloxfacturaList(articuloxfacturaListNew);
            articulo = em.merge(articulo);
            for (Articuloxfactura articuloxfacturaListNewArticuloxfactura : articuloxfacturaListNew) {
                if (!articuloxfacturaListOld.contains(articuloxfacturaListNewArticuloxfactura)) {
                    Articulo oldArticuloOfArticuloxfacturaListNewArticuloxfactura = articuloxfacturaListNewArticuloxfactura.getArticulo();
                    articuloxfacturaListNewArticuloxfactura.setArticulo(articulo);
                    articuloxfacturaListNewArticuloxfactura = em.merge(articuloxfacturaListNewArticuloxfactura);
                    if (oldArticuloOfArticuloxfacturaListNewArticuloxfactura != null && !oldArticuloOfArticuloxfacturaListNewArticuloxfactura.equals(articulo)) {
                        oldArticuloOfArticuloxfacturaListNewArticuloxfactura.getArticuloxfacturaList().remove(articuloxfacturaListNewArticuloxfactura);
                        oldArticuloOfArticuloxfacturaListNewArticuloxfactura = em.merge(oldArticuloOfArticuloxfacturaListNewArticuloxfactura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = articulo.getIdArticulo();
                if (findArticulo(id) == null) {
                    throw new NonexistentEntityException("The articulo with id " + id + " no longer exists.");
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
            Articulo articulo;
            try {
                articulo = em.getReference(Articulo.class, id);
                articulo.getIdArticulo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The articulo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Articuloxfactura> articuloxfacturaListOrphanCheck = articulo.getArticuloxfacturaList();
            for (Articuloxfactura articuloxfacturaListOrphanCheckArticuloxfactura : articuloxfacturaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Articulo (" + articulo + ") cannot be destroyed since the Articuloxfactura " + articuloxfacturaListOrphanCheckArticuloxfactura + " in its articuloxfacturaList field has a non-nullable articulo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(articulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Articulo> findArticuloEntities() {
        return findArticuloEntities(true, -1, -1);
    }

    public List<Articulo> findArticuloEntities(int maxResults, int firstResult) {
        return findArticuloEntities(false, maxResults, firstResult);
    }

    private List<Articulo> findArticuloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Articulo.class));
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

    public Articulo findArticulo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Articulo.class, id);
        } finally {
            em.close();
        }
    }

    public int getArticuloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Articulo> rt = cq.from(Articulo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

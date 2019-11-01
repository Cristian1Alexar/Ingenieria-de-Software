/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.clases.modelo;

import com.analisis2.clases.modelo.exceptions.IllegalOrphanException;
import com.analisis2.clases.modelo.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author crist
 */
public class ProveedoresJpaController implements Serializable {

    public ProveedoresJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedores proveedores) {
        if (proveedores.getFacturacompraCollection() == null) {
            proveedores.setFacturacompraCollection(new ArrayList<Facturacompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Facturacompra> attachedFacturacompraCollection = new ArrayList<Facturacompra>();
            for (Facturacompra facturacompraCollectionFacturacompraToAttach : proveedores.getFacturacompraCollection()) {
                facturacompraCollectionFacturacompraToAttach = em.getReference(facturacompraCollectionFacturacompraToAttach.getClass(), facturacompraCollectionFacturacompraToAttach.getIdFacturaCompra());
                attachedFacturacompraCollection.add(facturacompraCollectionFacturacompraToAttach);
            }
            proveedores.setFacturacompraCollection(attachedFacturacompraCollection);
            em.persist(proveedores);
            for (Facturacompra facturacompraCollectionFacturacompra : proveedores.getFacturacompraCollection()) {
                Proveedores oldProveedoresidProveedoresOfFacturacompraCollectionFacturacompra = facturacompraCollectionFacturacompra.getProveedoresidProveedores();
                facturacompraCollectionFacturacompra.setProveedoresidProveedores(proveedores);
                facturacompraCollectionFacturacompra = em.merge(facturacompraCollectionFacturacompra);
                if (oldProveedoresidProveedoresOfFacturacompraCollectionFacturacompra != null) {
                    oldProveedoresidProveedoresOfFacturacompraCollectionFacturacompra.getFacturacompraCollection().remove(facturacompraCollectionFacturacompra);
                    oldProveedoresidProveedoresOfFacturacompraCollectionFacturacompra = em.merge(oldProveedoresidProveedoresOfFacturacompraCollectionFacturacompra);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedores proveedores) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedores persistentProveedores = em.find(Proveedores.class, proveedores.getIdProveedores());
            Collection<Facturacompra> facturacompraCollectionOld = persistentProveedores.getFacturacompraCollection();
            Collection<Facturacompra> facturacompraCollectionNew = proveedores.getFacturacompraCollection();
            List<String> illegalOrphanMessages = null;
            for (Facturacompra facturacompraCollectionOldFacturacompra : facturacompraCollectionOld) {
                if (!facturacompraCollectionNew.contains(facturacompraCollectionOldFacturacompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Facturacompra " + facturacompraCollectionOldFacturacompra + " since its proveedoresidProveedores field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Facturacompra> attachedFacturacompraCollectionNew = new ArrayList<Facturacompra>();
            for (Facturacompra facturacompraCollectionNewFacturacompraToAttach : facturacompraCollectionNew) {
                facturacompraCollectionNewFacturacompraToAttach = em.getReference(facturacompraCollectionNewFacturacompraToAttach.getClass(), facturacompraCollectionNewFacturacompraToAttach.getIdFacturaCompra());
                attachedFacturacompraCollectionNew.add(facturacompraCollectionNewFacturacompraToAttach);
            }
            facturacompraCollectionNew = attachedFacturacompraCollectionNew;
            proveedores.setFacturacompraCollection(facturacompraCollectionNew);
            proveedores = em.merge(proveedores);
            for (Facturacompra facturacompraCollectionNewFacturacompra : facturacompraCollectionNew) {
                if (!facturacompraCollectionOld.contains(facturacompraCollectionNewFacturacompra)) {
                    Proveedores oldProveedoresidProveedoresOfFacturacompraCollectionNewFacturacompra = facturacompraCollectionNewFacturacompra.getProveedoresidProveedores();
                    facturacompraCollectionNewFacturacompra.setProveedoresidProveedores(proveedores);
                    facturacompraCollectionNewFacturacompra = em.merge(facturacompraCollectionNewFacturacompra);
                    if (oldProveedoresidProveedoresOfFacturacompraCollectionNewFacturacompra != null && !oldProveedoresidProveedoresOfFacturacompraCollectionNewFacturacompra.equals(proveedores)) {
                        oldProveedoresidProveedoresOfFacturacompraCollectionNewFacturacompra.getFacturacompraCollection().remove(facturacompraCollectionNewFacturacompra);
                        oldProveedoresidProveedoresOfFacturacompraCollectionNewFacturacompra = em.merge(oldProveedoresidProveedoresOfFacturacompraCollectionNewFacturacompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = proveedores.getIdProveedores();
                if (findProveedores(id) == null) {
                    throw new NonexistentEntityException("The proveedores with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedores proveedores;
            try {
                proveedores = em.getReference(Proveedores.class, id);
                proveedores.getIdProveedores();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedores with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Facturacompra> facturacompraCollectionOrphanCheck = proveedores.getFacturacompraCollection();
            for (Facturacompra facturacompraCollectionOrphanCheckFacturacompra : facturacompraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Proveedores (" + proveedores + ") cannot be destroyed since the Facturacompra " + facturacompraCollectionOrphanCheckFacturacompra + " in its facturacompraCollection field has a non-nullable proveedoresidProveedores field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(proveedores);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedores> findProveedoresEntities() {
        return findProveedoresEntities(true, -1, -1);
    }

    public List<Proveedores> findProveedoresEntities(int maxResults, int firstResult) {
        return findProveedoresEntities(false, maxResults, firstResult);
    }

    private List<Proveedores> findProveedoresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedores.class));
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

    public Proveedores findProveedores(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedores.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedoresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedores> rt = cq.from(Proveedores.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

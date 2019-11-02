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
 * @author Juan Diego Arriola
 */
public class FacturacompraJpaController implements Serializable {

    public FacturacompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Facturacompra facturacompra) {
        if (facturacompra.getDetallefacturacompraCollection() == null) {
            facturacompra.setDetallefacturacompraCollection(new ArrayList<Detallefacturacompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedores proveedoresidProveedores = facturacompra.getProveedoresidProveedores();
            if (proveedoresidProveedores != null) {
                proveedoresidProveedores = em.getReference(proveedoresidProveedores.getClass(), proveedoresidProveedores.getIdProveedores());
                facturacompra.setProveedoresidProveedores(proveedoresidProveedores);
            }
            Collection<Detallefacturacompra> attachedDetallefacturacompraCollection = new ArrayList<Detallefacturacompra>();
            for (Detallefacturacompra detallefacturacompraCollectionDetallefacturacompraToAttach : facturacompra.getDetallefacturacompraCollection()) {
                detallefacturacompraCollectionDetallefacturacompraToAttach = em.getReference(detallefacturacompraCollectionDetallefacturacompraToAttach.getClass(), detallefacturacompraCollectionDetallefacturacompraToAttach.getIdDetalleFacturaCompra());
                attachedDetallefacturacompraCollection.add(detallefacturacompraCollectionDetallefacturacompraToAttach);
            }
            facturacompra.setDetallefacturacompraCollection(attachedDetallefacturacompraCollection);
            em.persist(facturacompra);
            if (proveedoresidProveedores != null) {
                proveedoresidProveedores.getFacturacompraCollection().add(facturacompra);
                proveedoresidProveedores = em.merge(proveedoresidProveedores);
            }
            for (Detallefacturacompra detallefacturacompraCollectionDetallefacturacompra : facturacompra.getDetallefacturacompraCollection()) {
                Facturacompra oldFacturaCompraidFacturaCompraOfDetallefacturacompraCollectionDetallefacturacompra = detallefacturacompraCollectionDetallefacturacompra.getFacturaCompraidFacturaCompra();
                detallefacturacompraCollectionDetallefacturacompra.setFacturaCompraidFacturaCompra(facturacompra);
                detallefacturacompraCollectionDetallefacturacompra = em.merge(detallefacturacompraCollectionDetallefacturacompra);
                if (oldFacturaCompraidFacturaCompraOfDetallefacturacompraCollectionDetallefacturacompra != null) {
                    oldFacturaCompraidFacturaCompraOfDetallefacturacompraCollectionDetallefacturacompra.getDetallefacturacompraCollection().remove(detallefacturacompraCollectionDetallefacturacompra);
                    oldFacturaCompraidFacturaCompraOfDetallefacturacompraCollectionDetallefacturacompra = em.merge(oldFacturaCompraidFacturaCompraOfDetallefacturacompraCollectionDetallefacturacompra);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Facturacompra facturacompra) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Facturacompra persistentFacturacompra = em.find(Facturacompra.class, facturacompra.getIdFacturaCompra());
            Proveedores proveedoresidProveedoresOld = persistentFacturacompra.getProveedoresidProveedores();
            Proveedores proveedoresidProveedoresNew = facturacompra.getProveedoresidProveedores();
            Collection<Detallefacturacompra> detallefacturacompraCollectionOld = persistentFacturacompra.getDetallefacturacompraCollection();
            Collection<Detallefacturacompra> detallefacturacompraCollectionNew = facturacompra.getDetallefacturacompraCollection();
            List<String> illegalOrphanMessages = null;
            for (Detallefacturacompra detallefacturacompraCollectionOldDetallefacturacompra : detallefacturacompraCollectionOld) {
                if (!detallefacturacompraCollectionNew.contains(detallefacturacompraCollectionOldDetallefacturacompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Detallefacturacompra " + detallefacturacompraCollectionOldDetallefacturacompra + " since its facturaCompraidFacturaCompra field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (proveedoresidProveedoresNew != null) {
                proveedoresidProveedoresNew = em.getReference(proveedoresidProveedoresNew.getClass(), proveedoresidProveedoresNew.getIdProveedores());
                facturacompra.setProveedoresidProveedores(proveedoresidProveedoresNew);
            }
            Collection<Detallefacturacompra> attachedDetallefacturacompraCollectionNew = new ArrayList<Detallefacturacompra>();
            for (Detallefacturacompra detallefacturacompraCollectionNewDetallefacturacompraToAttach : detallefacturacompraCollectionNew) {
                detallefacturacompraCollectionNewDetallefacturacompraToAttach = em.getReference(detallefacturacompraCollectionNewDetallefacturacompraToAttach.getClass(), detallefacturacompraCollectionNewDetallefacturacompraToAttach.getIdDetalleFacturaCompra());
                attachedDetallefacturacompraCollectionNew.add(detallefacturacompraCollectionNewDetallefacturacompraToAttach);
            }
            detallefacturacompraCollectionNew = attachedDetallefacturacompraCollectionNew;
            facturacompra.setDetallefacturacompraCollection(detallefacturacompraCollectionNew);
            facturacompra = em.merge(facturacompra);
            if (proveedoresidProveedoresOld != null && !proveedoresidProveedoresOld.equals(proveedoresidProveedoresNew)) {
                proveedoresidProveedoresOld.getFacturacompraCollection().remove(facturacompra);
                proveedoresidProveedoresOld = em.merge(proveedoresidProveedoresOld);
            }
            if (proveedoresidProveedoresNew != null && !proveedoresidProveedoresNew.equals(proveedoresidProveedoresOld)) {
                proveedoresidProveedoresNew.getFacturacompraCollection().add(facturacompra);
                proveedoresidProveedoresNew = em.merge(proveedoresidProveedoresNew);
            }
            for (Detallefacturacompra detallefacturacompraCollectionNewDetallefacturacompra : detallefacturacompraCollectionNew) {
                if (!detallefacturacompraCollectionOld.contains(detallefacturacompraCollectionNewDetallefacturacompra)) {
                    Facturacompra oldFacturaCompraidFacturaCompraOfDetallefacturacompraCollectionNewDetallefacturacompra = detallefacturacompraCollectionNewDetallefacturacompra.getFacturaCompraidFacturaCompra();
                    detallefacturacompraCollectionNewDetallefacturacompra.setFacturaCompraidFacturaCompra(facturacompra);
                    detallefacturacompraCollectionNewDetallefacturacompra = em.merge(detallefacturacompraCollectionNewDetallefacturacompra);
                    if (oldFacturaCompraidFacturaCompraOfDetallefacturacompraCollectionNewDetallefacturacompra != null && !oldFacturaCompraidFacturaCompraOfDetallefacturacompraCollectionNewDetallefacturacompra.equals(facturacompra)) {
                        oldFacturaCompraidFacturaCompraOfDetallefacturacompraCollectionNewDetallefacturacompra.getDetallefacturacompraCollection().remove(detallefacturacompraCollectionNewDetallefacturacompra);
                        oldFacturaCompraidFacturaCompraOfDetallefacturacompraCollectionNewDetallefacturacompra = em.merge(oldFacturaCompraidFacturaCompraOfDetallefacturacompraCollectionNewDetallefacturacompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = facturacompra.getIdFacturaCompra();
                if (findFacturacompra(id) == null) {
                    throw new NonexistentEntityException("The facturacompra with id " + id + " no longer exists.");
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
            Facturacompra facturacompra;
            try {
                facturacompra = em.getReference(Facturacompra.class, id);
                facturacompra.getIdFacturaCompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The facturacompra with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Detallefacturacompra> detallefacturacompraCollectionOrphanCheck = facturacompra.getDetallefacturacompraCollection();
            for (Detallefacturacompra detallefacturacompraCollectionOrphanCheckDetallefacturacompra : detallefacturacompraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Facturacompra (" + facturacompra + ") cannot be destroyed since the Detallefacturacompra " + detallefacturacompraCollectionOrphanCheckDetallefacturacompra + " in its detallefacturacompraCollection field has a non-nullable facturaCompraidFacturaCompra field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Proveedores proveedoresidProveedores = facturacompra.getProveedoresidProveedores();
            if (proveedoresidProveedores != null) {
                proveedoresidProveedores.getFacturacompraCollection().remove(facturacompra);
                proveedoresidProveedores = em.merge(proveedoresidProveedores);
            }
            em.remove(facturacompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Facturacompra> findFacturacompraEntities() {
        return findFacturacompraEntities(true, -1, -1);
    }

    public List<Facturacompra> findFacturacompraEntities(int maxResults, int firstResult) {
        return findFacturacompraEntities(false, maxResults, firstResult);
    }

    private List<Facturacompra> findFacturacompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Facturacompra.class));
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

    public Facturacompra findFacturacompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Facturacompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturacompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Facturacompra> rt = cq.from(Facturacompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

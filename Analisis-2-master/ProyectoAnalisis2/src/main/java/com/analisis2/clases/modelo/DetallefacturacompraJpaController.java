/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.clases.modelo;

import com.analisis2.clases.modelo.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Juan Diego Arriola
 */
public class DetallefacturacompraJpaController implements Serializable {

    public DetallefacturacompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Detallefacturacompra detallefacturacompra) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Facturacompra facturaCompraidFacturaCompra = detallefacturacompra.getFacturaCompraidFacturaCompra();
            if (facturaCompraidFacturaCompra != null) {
                facturaCompraidFacturaCompra = em.getReference(facturaCompraidFacturaCompra.getClass(), facturaCompraidFacturaCompra.getIdFacturaCompra());
                detallefacturacompra.setFacturaCompraidFacturaCompra(facturaCompraidFacturaCompra);
            }
            Producto productoidProducto = detallefacturacompra.getProductoidProducto();
            if (productoidProducto != null) {
                productoidProducto = em.getReference(productoidProducto.getClass(), productoidProducto.getIdProducto());
                detallefacturacompra.setProductoidProducto(productoidProducto);
            }
            em.persist(detallefacturacompra);
            if (facturaCompraidFacturaCompra != null) {
                facturaCompraidFacturaCompra.getDetallefacturacompraCollection().add(detallefacturacompra);
                facturaCompraidFacturaCompra = em.merge(facturaCompraidFacturaCompra);
            }
            if (productoidProducto != null) {
                productoidProducto.getDetallefacturacompraCollection().add(detallefacturacompra);
                productoidProducto = em.merge(productoidProducto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Detallefacturacompra detallefacturacompra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detallefacturacompra persistentDetallefacturacompra = em.find(Detallefacturacompra.class, detallefacturacompra.getIdDetalleFacturaCompra());
            Facturacompra facturaCompraidFacturaCompraOld = persistentDetallefacturacompra.getFacturaCompraidFacturaCompra();
            Facturacompra facturaCompraidFacturaCompraNew = detallefacturacompra.getFacturaCompraidFacturaCompra();
            Producto productoidProductoOld = persistentDetallefacturacompra.getProductoidProducto();
            Producto productoidProductoNew = detallefacturacompra.getProductoidProducto();
            if (facturaCompraidFacturaCompraNew != null) {
                facturaCompraidFacturaCompraNew = em.getReference(facturaCompraidFacturaCompraNew.getClass(), facturaCompraidFacturaCompraNew.getIdFacturaCompra());
                detallefacturacompra.setFacturaCompraidFacturaCompra(facturaCompraidFacturaCompraNew);
            }
            if (productoidProductoNew != null) {
                productoidProductoNew = em.getReference(productoidProductoNew.getClass(), productoidProductoNew.getIdProducto());
                detallefacturacompra.setProductoidProducto(productoidProductoNew);
            }
            detallefacturacompra = em.merge(detallefacturacompra);
            if (facturaCompraidFacturaCompraOld != null && !facturaCompraidFacturaCompraOld.equals(facturaCompraidFacturaCompraNew)) {
                facturaCompraidFacturaCompraOld.getDetallefacturacompraCollection().remove(detallefacturacompra);
                facturaCompraidFacturaCompraOld = em.merge(facturaCompraidFacturaCompraOld);
            }
            if (facturaCompraidFacturaCompraNew != null && !facturaCompraidFacturaCompraNew.equals(facturaCompraidFacturaCompraOld)) {
                facturaCompraidFacturaCompraNew.getDetallefacturacompraCollection().add(detallefacturacompra);
                facturaCompraidFacturaCompraNew = em.merge(facturaCompraidFacturaCompraNew);
            }
            if (productoidProductoOld != null && !productoidProductoOld.equals(productoidProductoNew)) {
                productoidProductoOld.getDetallefacturacompraCollection().remove(detallefacturacompra);
                productoidProductoOld = em.merge(productoidProductoOld);
            }
            if (productoidProductoNew != null && !productoidProductoNew.equals(productoidProductoOld)) {
                productoidProductoNew.getDetallefacturacompraCollection().add(detallefacturacompra);
                productoidProductoNew = em.merge(productoidProductoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detallefacturacompra.getIdDetalleFacturaCompra();
                if (findDetallefacturacompra(id) == null) {
                    throw new NonexistentEntityException("The detallefacturacompra with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detallefacturacompra detallefacturacompra;
            try {
                detallefacturacompra = em.getReference(Detallefacturacompra.class, id);
                detallefacturacompra.getIdDetalleFacturaCompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detallefacturacompra with id " + id + " no longer exists.", enfe);
            }
            Facturacompra facturaCompraidFacturaCompra = detallefacturacompra.getFacturaCompraidFacturaCompra();
            if (facturaCompraidFacturaCompra != null) {
                facturaCompraidFacturaCompra.getDetallefacturacompraCollection().remove(detallefacturacompra);
                facturaCompraidFacturaCompra = em.merge(facturaCompraidFacturaCompra);
            }
            Producto productoidProducto = detallefacturacompra.getProductoidProducto();
            if (productoidProducto != null) {
                productoidProducto.getDetallefacturacompraCollection().remove(detallefacturacompra);
                productoidProducto = em.merge(productoidProducto);
            }
            em.remove(detallefacturacompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Detallefacturacompra> findDetallefacturacompraEntities() {
        return findDetallefacturacompraEntities(true, -1, -1);
    }

    public List<Detallefacturacompra> findDetallefacturacompraEntities(int maxResults, int firstResult) {
        return findDetallefacturacompraEntities(false, maxResults, firstResult);
    }

    private List<Detallefacturacompra> findDetallefacturacompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Detallefacturacompra.class));
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

    public Detallefacturacompra findDetallefacturacompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Detallefacturacompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetallefacturacompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Detallefacturacompra> rt = cq.from(Detallefacturacompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

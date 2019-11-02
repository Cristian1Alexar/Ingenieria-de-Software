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
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        if (producto.getArregloHasProductoCollection() == null) {
            producto.setArregloHasProductoCollection(new ArrayList<ArregloHasProducto>());
        }
        if (producto.getDetallefacturacompraCollection() == null) {
            producto.setDetallefacturacompraCollection(new ArrayList<Detallefacturacompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Marca marcaidMarca = producto.getMarcaidMarca();
            if (marcaidMarca != null) {
                marcaidMarca = em.getReference(marcaidMarca.getClass(), marcaidMarca.getIdMarca());
                producto.setMarcaidMarca(marcaidMarca);
            }
            Collection<ArregloHasProducto> attachedArregloHasProductoCollection = new ArrayList<ArregloHasProducto>();
            for (ArregloHasProducto arregloHasProductoCollectionArregloHasProductoToAttach : producto.getArregloHasProductoCollection()) {
                arregloHasProductoCollectionArregloHasProductoToAttach = em.getReference(arregloHasProductoCollectionArregloHasProductoToAttach.getClass(), arregloHasProductoCollectionArregloHasProductoToAttach.getId());
                attachedArregloHasProductoCollection.add(arregloHasProductoCollectionArregloHasProductoToAttach);
            }
            producto.setArregloHasProductoCollection(attachedArregloHasProductoCollection);
            Collection<Detallefacturacompra> attachedDetallefacturacompraCollection = new ArrayList<Detallefacturacompra>();
            for (Detallefacturacompra detallefacturacompraCollectionDetallefacturacompraToAttach : producto.getDetallefacturacompraCollection()) {
                detallefacturacompraCollectionDetallefacturacompraToAttach = em.getReference(detallefacturacompraCollectionDetallefacturacompraToAttach.getClass(), detallefacturacompraCollectionDetallefacturacompraToAttach.getIdDetalleFacturaCompra());
                attachedDetallefacturacompraCollection.add(detallefacturacompraCollectionDetallefacturacompraToAttach);
            }
            producto.setDetallefacturacompraCollection(attachedDetallefacturacompraCollection);
            em.persist(producto);
            if (marcaidMarca != null) {
                marcaidMarca.getProductoCollection().add(producto);
                marcaidMarca = em.merge(marcaidMarca);
            }
            for (ArregloHasProducto arregloHasProductoCollectionArregloHasProducto : producto.getArregloHasProductoCollection()) {
                Producto oldProductoidProductoOfArregloHasProductoCollectionArregloHasProducto = arregloHasProductoCollectionArregloHasProducto.getProductoidProducto();
                arregloHasProductoCollectionArregloHasProducto.setProductoidProducto(producto);
                arregloHasProductoCollectionArregloHasProducto = em.merge(arregloHasProductoCollectionArregloHasProducto);
                if (oldProductoidProductoOfArregloHasProductoCollectionArregloHasProducto != null) {
                    oldProductoidProductoOfArregloHasProductoCollectionArregloHasProducto.getArregloHasProductoCollection().remove(arregloHasProductoCollectionArregloHasProducto);
                    oldProductoidProductoOfArregloHasProductoCollectionArregloHasProducto = em.merge(oldProductoidProductoOfArregloHasProductoCollectionArregloHasProducto);
                }
            }
            for (Detallefacturacompra detallefacturacompraCollectionDetallefacturacompra : producto.getDetallefacturacompraCollection()) {
                Producto oldProductoidProductoOfDetallefacturacompraCollectionDetallefacturacompra = detallefacturacompraCollectionDetallefacturacompra.getProductoidProducto();
                detallefacturacompraCollectionDetallefacturacompra.setProductoidProducto(producto);
                detallefacturacompraCollectionDetallefacturacompra = em.merge(detallefacturacompraCollectionDetallefacturacompra);
                if (oldProductoidProductoOfDetallefacturacompraCollectionDetallefacturacompra != null) {
                    oldProductoidProductoOfDetallefacturacompraCollectionDetallefacturacompra.getDetallefacturacompraCollection().remove(detallefacturacompraCollectionDetallefacturacompra);
                    oldProductoidProductoOfDetallefacturacompraCollectionDetallefacturacompra = em.merge(oldProductoidProductoOfDetallefacturacompraCollectionDetallefacturacompra);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
            Marca marcaidMarcaOld = persistentProducto.getMarcaidMarca();
            Marca marcaidMarcaNew = producto.getMarcaidMarca();
            Collection<ArregloHasProducto> arregloHasProductoCollectionOld = persistentProducto.getArregloHasProductoCollection();
            Collection<ArregloHasProducto> arregloHasProductoCollectionNew = producto.getArregloHasProductoCollection();
            Collection<Detallefacturacompra> detallefacturacompraCollectionOld = persistentProducto.getDetallefacturacompraCollection();
            Collection<Detallefacturacompra> detallefacturacompraCollectionNew = producto.getDetallefacturacompraCollection();
            List<String> illegalOrphanMessages = null;
            for (ArregloHasProducto arregloHasProductoCollectionOldArregloHasProducto : arregloHasProductoCollectionOld) {
                if (!arregloHasProductoCollectionNew.contains(arregloHasProductoCollectionOldArregloHasProducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ArregloHasProducto " + arregloHasProductoCollectionOldArregloHasProducto + " since its productoidProducto field is not nullable.");
                }
            }
            for (Detallefacturacompra detallefacturacompraCollectionOldDetallefacturacompra : detallefacturacompraCollectionOld) {
                if (!detallefacturacompraCollectionNew.contains(detallefacturacompraCollectionOldDetallefacturacompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Detallefacturacompra " + detallefacturacompraCollectionOldDetallefacturacompra + " since its productoidProducto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (marcaidMarcaNew != null) {
                marcaidMarcaNew = em.getReference(marcaidMarcaNew.getClass(), marcaidMarcaNew.getIdMarca());
                producto.setMarcaidMarca(marcaidMarcaNew);
            }
            Collection<ArregloHasProducto> attachedArregloHasProductoCollectionNew = new ArrayList<ArregloHasProducto>();
            for (ArregloHasProducto arregloHasProductoCollectionNewArregloHasProductoToAttach : arregloHasProductoCollectionNew) {
                arregloHasProductoCollectionNewArregloHasProductoToAttach = em.getReference(arregloHasProductoCollectionNewArregloHasProductoToAttach.getClass(), arregloHasProductoCollectionNewArregloHasProductoToAttach.getId());
                attachedArregloHasProductoCollectionNew.add(arregloHasProductoCollectionNewArregloHasProductoToAttach);
            }
            arregloHasProductoCollectionNew = attachedArregloHasProductoCollectionNew;
            producto.setArregloHasProductoCollection(arregloHasProductoCollectionNew);
            Collection<Detallefacturacompra> attachedDetallefacturacompraCollectionNew = new ArrayList<Detallefacturacompra>();
            for (Detallefacturacompra detallefacturacompraCollectionNewDetallefacturacompraToAttach : detallefacturacompraCollectionNew) {
                detallefacturacompraCollectionNewDetallefacturacompraToAttach = em.getReference(detallefacturacompraCollectionNewDetallefacturacompraToAttach.getClass(), detallefacturacompraCollectionNewDetallefacturacompraToAttach.getIdDetalleFacturaCompra());
                attachedDetallefacturacompraCollectionNew.add(detallefacturacompraCollectionNewDetallefacturacompraToAttach);
            }
            detallefacturacompraCollectionNew = attachedDetallefacturacompraCollectionNew;
            producto.setDetallefacturacompraCollection(detallefacturacompraCollectionNew);
            producto = em.merge(producto);
            if (marcaidMarcaOld != null && !marcaidMarcaOld.equals(marcaidMarcaNew)) {
                marcaidMarcaOld.getProductoCollection().remove(producto);
                marcaidMarcaOld = em.merge(marcaidMarcaOld);
            }
            if (marcaidMarcaNew != null && !marcaidMarcaNew.equals(marcaidMarcaOld)) {
                marcaidMarcaNew.getProductoCollection().add(producto);
                marcaidMarcaNew = em.merge(marcaidMarcaNew);
            }
            for (ArregloHasProducto arregloHasProductoCollectionNewArregloHasProducto : arregloHasProductoCollectionNew) {
                if (!arregloHasProductoCollectionOld.contains(arregloHasProductoCollectionNewArregloHasProducto)) {
                    Producto oldProductoidProductoOfArregloHasProductoCollectionNewArregloHasProducto = arregloHasProductoCollectionNewArregloHasProducto.getProductoidProducto();
                    arregloHasProductoCollectionNewArregloHasProducto.setProductoidProducto(producto);
                    arregloHasProductoCollectionNewArregloHasProducto = em.merge(arregloHasProductoCollectionNewArregloHasProducto);
                    if (oldProductoidProductoOfArregloHasProductoCollectionNewArregloHasProducto != null && !oldProductoidProductoOfArregloHasProductoCollectionNewArregloHasProducto.equals(producto)) {
                        oldProductoidProductoOfArregloHasProductoCollectionNewArregloHasProducto.getArregloHasProductoCollection().remove(arregloHasProductoCollectionNewArregloHasProducto);
                        oldProductoidProductoOfArregloHasProductoCollectionNewArregloHasProducto = em.merge(oldProductoidProductoOfArregloHasProductoCollectionNewArregloHasProducto);
                    }
                }
            }
            for (Detallefacturacompra detallefacturacompraCollectionNewDetallefacturacompra : detallefacturacompraCollectionNew) {
                if (!detallefacturacompraCollectionOld.contains(detallefacturacompraCollectionNewDetallefacturacompra)) {
                    Producto oldProductoidProductoOfDetallefacturacompraCollectionNewDetallefacturacompra = detallefacturacompraCollectionNewDetallefacturacompra.getProductoidProducto();
                    detallefacturacompraCollectionNewDetallefacturacompra.setProductoidProducto(producto);
                    detallefacturacompraCollectionNewDetallefacturacompra = em.merge(detallefacturacompraCollectionNewDetallefacturacompra);
                    if (oldProductoidProductoOfDetallefacturacompraCollectionNewDetallefacturacompra != null && !oldProductoidProductoOfDetallefacturacompraCollectionNewDetallefacturacompra.equals(producto)) {
                        oldProductoidProductoOfDetallefacturacompraCollectionNewDetallefacturacompra.getDetallefacturacompraCollection().remove(detallefacturacompraCollectionNewDetallefacturacompra);
                        oldProductoidProductoOfDetallefacturacompraCollectionNewDetallefacturacompra = em.merge(oldProductoidProductoOfDetallefacturacompraCollectionNewDetallefacturacompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
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
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ArregloHasProducto> arregloHasProductoCollectionOrphanCheck = producto.getArregloHasProductoCollection();
            for (ArregloHasProducto arregloHasProductoCollectionOrphanCheckArregloHasProducto : arregloHasProductoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the ArregloHasProducto " + arregloHasProductoCollectionOrphanCheckArregloHasProducto + " in its arregloHasProductoCollection field has a non-nullable productoidProducto field.");
            }
            Collection<Detallefacturacompra> detallefacturacompraCollectionOrphanCheck = producto.getDetallefacturacompraCollection();
            for (Detallefacturacompra detallefacturacompraCollectionOrphanCheckDetallefacturacompra : detallefacturacompraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Detallefacturacompra " + detallefacturacompraCollectionOrphanCheckDetallefacturacompra + " in its detallefacturacompraCollection field has a non-nullable productoidProducto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Marca marcaidMarca = producto.getMarcaidMarca();
            if (marcaidMarca != null) {
                marcaidMarca.getProductoCollection().remove(producto);
                marcaidMarca = em.merge(marcaidMarca);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.clases.modelo;

import com.analisis2.clases.modelo.exceptions.NonexistentEntityException;
import com.analisis2.clases.modelo.exceptions.PreexistingEntityException;
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
 * @author crist
 */
public class ArregloHasProductoJpaController implements Serializable {

    public ArregloHasProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ArregloHasProducto arregloHasProducto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Arreglo arregloidArreglo = arregloHasProducto.getArregloidArreglo();
            if (arregloidArreglo != null) {
                arregloidArreglo = em.getReference(arregloidArreglo.getClass(), arregloidArreglo.getIdArreglo());
                arregloHasProducto.setArregloidArreglo(arregloidArreglo);
            }
            Producto productoidProducto = arregloHasProducto.getProductoidProducto();
            if (productoidProducto != null) {
                productoidProducto = em.getReference(productoidProducto.getClass(), productoidProducto.getIdProducto());
                arregloHasProducto.setProductoidProducto(productoidProducto);
            }
            em.persist(arregloHasProducto);
            if (arregloidArreglo != null) {
                arregloidArreglo.getArregloHasProductoCollection().add(arregloHasProducto);
                arregloidArreglo = em.merge(arregloidArreglo);
            }
            if (productoidProducto != null) {
                productoidProducto.getArregloHasProductoCollection().add(arregloHasProducto);
                productoidProducto = em.merge(productoidProducto);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findArregloHasProducto(arregloHasProducto.getId()) != null) {
                throw new PreexistingEntityException("ArregloHasProducto " + arregloHasProducto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ArregloHasProducto arregloHasProducto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArregloHasProducto persistentArregloHasProducto = em.find(ArregloHasProducto.class, arregloHasProducto.getId());
            Arreglo arregloidArregloOld = persistentArregloHasProducto.getArregloidArreglo();
            Arreglo arregloidArregloNew = arregloHasProducto.getArregloidArreglo();
            Producto productoidProductoOld = persistentArregloHasProducto.getProductoidProducto();
            Producto productoidProductoNew = arregloHasProducto.getProductoidProducto();
            if (arregloidArregloNew != null) {
                arregloidArregloNew = em.getReference(arregloidArregloNew.getClass(), arregloidArregloNew.getIdArreglo());
                arregloHasProducto.setArregloidArreglo(arregloidArregloNew);
            }
            if (productoidProductoNew != null) {
                productoidProductoNew = em.getReference(productoidProductoNew.getClass(), productoidProductoNew.getIdProducto());
                arregloHasProducto.setProductoidProducto(productoidProductoNew);
            }
            arregloHasProducto = em.merge(arregloHasProducto);
            if (arregloidArregloOld != null && !arregloidArregloOld.equals(arregloidArregloNew)) {
                arregloidArregloOld.getArregloHasProductoCollection().remove(arregloHasProducto);
                arregloidArregloOld = em.merge(arregloidArregloOld);
            }
            if (arregloidArregloNew != null && !arregloidArregloNew.equals(arregloidArregloOld)) {
                arregloidArregloNew.getArregloHasProductoCollection().add(arregloHasProducto);
                arregloidArregloNew = em.merge(arregloidArregloNew);
            }
            if (productoidProductoOld != null && !productoidProductoOld.equals(productoidProductoNew)) {
                productoidProductoOld.getArregloHasProductoCollection().remove(arregloHasProducto);
                productoidProductoOld = em.merge(productoidProductoOld);
            }
            if (productoidProductoNew != null && !productoidProductoNew.equals(productoidProductoOld)) {
                productoidProductoNew.getArregloHasProductoCollection().add(arregloHasProducto);
                productoidProductoNew = em.merge(productoidProductoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = arregloHasProducto.getId();
                if (findArregloHasProducto(id) == null) {
                    throw new NonexistentEntityException("The arregloHasProducto with id " + id + " no longer exists.");
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
            ArregloHasProducto arregloHasProducto;
            try {
                arregloHasProducto = em.getReference(ArregloHasProducto.class, id);
                arregloHasProducto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The arregloHasProducto with id " + id + " no longer exists.", enfe);
            }
            Arreglo arregloidArreglo = arregloHasProducto.getArregloidArreglo();
            if (arregloidArreglo != null) {
                arregloidArreglo.getArregloHasProductoCollection().remove(arregloHasProducto);
                arregloidArreglo = em.merge(arregloidArreglo);
            }
            Producto productoidProducto = arregloHasProducto.getProductoidProducto();
            if (productoidProducto != null) {
                productoidProducto.getArregloHasProductoCollection().remove(arregloHasProducto);
                productoidProducto = em.merge(productoidProducto);
            }
            em.remove(arregloHasProducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ArregloHasProducto> findArregloHasProductoEntities() {
        return findArregloHasProductoEntities(true, -1, -1);
    }

    public List<ArregloHasProducto> findArregloHasProductoEntities(int maxResults, int firstResult) {
        return findArregloHasProductoEntities(false, maxResults, firstResult);
    }

    private List<ArregloHasProducto> findArregloHasProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ArregloHasProducto.class));
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

    public ArregloHasProducto findArregloHasProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ArregloHasProducto.class, id);
        } finally {
            em.close();
        }
    }

    public int getArregloHasProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ArregloHasProducto> rt = cq.from(ArregloHasProducto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
public class ArregloJpaController implements Serializable {

    public ArregloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Arreglo arreglo) {
        if (arreglo.getArregloHasProductoCollection() == null) {
            arreglo.setArregloHasProductoCollection(new ArrayList<ArregloHasProducto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<ArregloHasProducto> attachedArregloHasProductoCollection = new ArrayList<ArregloHasProducto>();
            for (ArregloHasProducto arregloHasProductoCollectionArregloHasProductoToAttach : arreglo.getArregloHasProductoCollection()) {
                arregloHasProductoCollectionArregloHasProductoToAttach = em.getReference(arregloHasProductoCollectionArregloHasProductoToAttach.getClass(), arregloHasProductoCollectionArregloHasProductoToAttach.getId());
                attachedArregloHasProductoCollection.add(arregloHasProductoCollectionArregloHasProductoToAttach);
            }
            arreglo.setArregloHasProductoCollection(attachedArregloHasProductoCollection);
            em.persist(arreglo);
            for (ArregloHasProducto arregloHasProductoCollectionArregloHasProducto : arreglo.getArregloHasProductoCollection()) {
                Arreglo oldArregloidArregloOfArregloHasProductoCollectionArregloHasProducto = arregloHasProductoCollectionArregloHasProducto.getArregloidArreglo();
                arregloHasProductoCollectionArregloHasProducto.setArregloidArreglo(arreglo);
                arregloHasProductoCollectionArregloHasProducto = em.merge(arregloHasProductoCollectionArregloHasProducto);
                if (oldArregloidArregloOfArregloHasProductoCollectionArregloHasProducto != null) {
                    oldArregloidArregloOfArregloHasProductoCollectionArregloHasProducto.getArregloHasProductoCollection().remove(arregloHasProductoCollectionArregloHasProducto);
                    oldArregloidArregloOfArregloHasProductoCollectionArregloHasProducto = em.merge(oldArregloidArregloOfArregloHasProductoCollectionArregloHasProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Arreglo arreglo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Arreglo persistentArreglo = em.find(Arreglo.class, arreglo.getIdArreglo());
            Collection<ArregloHasProducto> arregloHasProductoCollectionOld = persistentArreglo.getArregloHasProductoCollection();
            Collection<ArregloHasProducto> arregloHasProductoCollectionNew = arreglo.getArregloHasProductoCollection();
            List<String> illegalOrphanMessages = null;
            for (ArregloHasProducto arregloHasProductoCollectionOldArregloHasProducto : arregloHasProductoCollectionOld) {
                if (!arregloHasProductoCollectionNew.contains(arregloHasProductoCollectionOldArregloHasProducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ArregloHasProducto " + arregloHasProductoCollectionOldArregloHasProducto + " since its arregloidArreglo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<ArregloHasProducto> attachedArregloHasProductoCollectionNew = new ArrayList<ArregloHasProducto>();
            for (ArregloHasProducto arregloHasProductoCollectionNewArregloHasProductoToAttach : arregloHasProductoCollectionNew) {
                arregloHasProductoCollectionNewArregloHasProductoToAttach = em.getReference(arregloHasProductoCollectionNewArregloHasProductoToAttach.getClass(), arregloHasProductoCollectionNewArregloHasProductoToAttach.getId());
                attachedArregloHasProductoCollectionNew.add(arregloHasProductoCollectionNewArregloHasProductoToAttach);
            }
            arregloHasProductoCollectionNew = attachedArregloHasProductoCollectionNew;
            arreglo.setArregloHasProductoCollection(arregloHasProductoCollectionNew);
            arreglo = em.merge(arreglo);
            for (ArregloHasProducto arregloHasProductoCollectionNewArregloHasProducto : arregloHasProductoCollectionNew) {
                if (!arregloHasProductoCollectionOld.contains(arregloHasProductoCollectionNewArregloHasProducto)) {
                    Arreglo oldArregloidArregloOfArregloHasProductoCollectionNewArregloHasProducto = arregloHasProductoCollectionNewArregloHasProducto.getArregloidArreglo();
                    arregloHasProductoCollectionNewArregloHasProducto.setArregloidArreglo(arreglo);
                    arregloHasProductoCollectionNewArregloHasProducto = em.merge(arregloHasProductoCollectionNewArregloHasProducto);
                    if (oldArregloidArregloOfArregloHasProductoCollectionNewArregloHasProducto != null && !oldArregloidArregloOfArregloHasProductoCollectionNewArregloHasProducto.equals(arreglo)) {
                        oldArregloidArregloOfArregloHasProductoCollectionNewArregloHasProducto.getArregloHasProductoCollection().remove(arregloHasProductoCollectionNewArregloHasProducto);
                        oldArregloidArregloOfArregloHasProductoCollectionNewArregloHasProducto = em.merge(oldArregloidArregloOfArregloHasProductoCollectionNewArregloHasProducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = arreglo.getIdArreglo();
                if (findArreglo(id) == null) {
                    throw new NonexistentEntityException("The arreglo with id " + id + " no longer exists.");
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
            Arreglo arreglo;
            try {
                arreglo = em.getReference(Arreglo.class, id);
                arreglo.getIdArreglo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The arreglo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ArregloHasProducto> arregloHasProductoCollectionOrphanCheck = arreglo.getArregloHasProductoCollection();
            for (ArregloHasProducto arregloHasProductoCollectionOrphanCheckArregloHasProducto : arregloHasProductoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Arreglo (" + arreglo + ") cannot be destroyed since the ArregloHasProducto " + arregloHasProductoCollectionOrphanCheckArregloHasProducto + " in its arregloHasProductoCollection field has a non-nullable arregloidArreglo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(arreglo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Arreglo> findArregloEntities() {
        return findArregloEntities(true, -1, -1);
    }

    public List<Arreglo> findArregloEntities(int maxResults, int firstResult) {
        return findArregloEntities(false, maxResults, firstResult);
    }

    private List<Arreglo> findArregloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Arreglo.class));
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

    public Arreglo findArreglo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Arreglo.class, id);
        } finally {
            em.close();
        }
    }

    public int getArregloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Arreglo> rt = cq.from(Arreglo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

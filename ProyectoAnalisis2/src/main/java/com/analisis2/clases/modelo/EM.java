package com.analisis2.clases.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * @author Juan Diego Arriola
 */
public class EM{
    
    private EntityManager em;
    private static EM e;

    private EM()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexion");
        em = emf.createEntityManager();
    }
    
    public static EM crearEntityManager()
    {
        if (e == null)
        {
            e = new EM();
        }
        return e;
    }
    
    public EntityManager getEntity()
    {
        return em;
    }
    
    public void cerrarEntity()
    {
        em.close();
    }
}

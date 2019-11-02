package com.analisis2.consultas.modelo;

import com.analisis2.clases.modelo.EM;
import com.analisis2.clases.modelo.Marca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/*
 * @author Juan Diego Arriola
 */
public class ConsultaMarcas implements ConsultaDeObjetos{

    @Override
    public List consultar() {
        EM e = EM.crearEntityManager();
        EntityManager em = e.getEntity();
        TypedQuery<Marca> queryMarca = em.createNamedQuery("Marca.findAll", Marca.class);
        List<Marca> listaMarca = queryMarca.getResultList();
        return listaMarca;
    }
    
}

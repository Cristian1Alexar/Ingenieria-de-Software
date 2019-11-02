package com.analisis2.consultas.modelo;

import com.analisis2.clases.modelo.EM;
import com.analisis2.clases.modelo.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/*
 * @author Juan Diego Arriola
 */
public class ConsultaProductos implements ConsultaDeObjetos{
    
    public ConsultaProductos(){}

    @Override
    public List consultar() {
        EM e = EM.crearEntityManager();
        EntityManager em = e.getEntity();
        TypedQuery<Producto> queryProducto = em.createNamedQuery("Producto.findAll", Producto.class);
        List<Producto> listaProducto = queryProducto.getResultList();
        return listaProducto;
    }  
}

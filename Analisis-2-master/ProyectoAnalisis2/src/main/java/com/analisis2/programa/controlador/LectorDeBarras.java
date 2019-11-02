package com.analisis2.programa.controlador;

import com.analisis2.clases.modelo.EM;
import com.analisis2.clases.modelo.Producto;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/*
 * @author Juan Diego Arriola
 */
public class LectorDeBarras {
    private Producto producto;
    private final IFactura facturaObservador;
    
    public LectorDeBarras(){
        facturaObservador = new FacturaContado();
    }
    
    public Producto leerCodigo(int codigo)
    {
        EM e = EM.crearEntityManager();
        EntityManager em = e.getEntity();
        TypedQuery<Producto> queryProducto = em.createNamedQuery("Producto.findByIdProducto", Producto.class);
        queryProducto.setParameter("idProducto", codigo);
        producto = queryProducto.getSingleResult();
        
        return producto;
    }
    
    public float notificar(int cantidad, float precio)
    {
        float subtotal = facturaObservador.actualizar(cantidad, precio);
        return subtotal;
    }
    
    public IFactura getFactura()
    {
        return this.facturaObservador;
    }
}

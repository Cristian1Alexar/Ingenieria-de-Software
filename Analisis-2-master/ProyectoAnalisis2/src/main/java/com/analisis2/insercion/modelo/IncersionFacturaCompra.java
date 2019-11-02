package com.analisis2.insercion.modelo;

import com.analisis2.clases.modelo.Detallefacturacompra;
import com.analisis2.clases.modelo.DetallefacturacompraJpaController;
import com.analisis2.clases.modelo.EM;
import com.analisis2.clases.modelo.Facturacompra;
import com.analisis2.clases.modelo.FacturacompraJpaController;
import com.analisis2.clases.modelo.Producto;
import com.analisis2.clases.modelo.Proveedores;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/*
 * @author Juan Diego Arriola
 */
public class IncersionFacturaCompra implements IncersionFactura{
    Facturacompra factura;
    
    public IncersionFacturaCompra(float total)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexion");
        
        EM e = EM.crearEntityManager();
        EntityManager em = e.getEntity();
        TypedQuery<Proveedores> queryProducto = em.createNamedQuery("Proveedores.findByIdProveedores", Proveedores.class);
        queryProducto.setParameter("idProveedores", 1);
        Proveedores p = queryProducto.getSingleResult();

        Facturacompra factura = new Facturacompra();
        Date fecha = new Date();
        fecha = Calendar.getInstance().getTime();
        factura.setFecha(fecha);
        factura.setTotal(total);
        factura.setProveedoresidProveedores(p);

        FacturacompraJpaController facturaController = new FacturacompraJpaController(emf);
        facturaController.create(factura);

        this.factura = factura;     
    }
    
    @Override
    public void insertarDatosFactura(Object[] datos)
    {   
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexion");
        
        EM e = EM.crearEntityManager();
        EntityManager em = e.getEntity();
        TypedQuery<Producto> queryProducto = em.createNamedQuery("Producto.findByNombre", Producto.class);
        queryProducto.setParameter("nombre", datos[0]);
        Producto p = queryProducto.getSingleResult();
        
        Detallefacturacompra detalle = new Detallefacturacompra();
        detalle.setCantidad((int) datos[2]);
        detalle.setFacturaCompraidFacturaCompra(factura);
        detalle.setProductoidProducto(p);
        detalle.setSubtotal((float) datos[3]);
        
        DetallefacturacompraJpaController facturaController = new DetallefacturacompraJpaController(emf);
        facturaController.create(detalle);
    }
}

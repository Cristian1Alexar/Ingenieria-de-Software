package com.analisis2.insercion.modelo;

import com.analisis2.clases.modelo.EM;
import com.analisis2.clases.modelo.Marca;
import com.analisis2.clases.modelo.MarcaJpaController;
import com.analisis2.clases.modelo.Producto;
import com.analisis2.clases.modelo.ProductoJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IncersionInicial {
   
    public IncersionInicial()
    {
        
    }
    
    public void insertarDatos()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexion");
        
        Producto p1 = new Producto();
        Producto p2 = new Producto();
        Producto p3 = new Producto();
        Producto p4 = new Producto();
        Producto p5 = new Producto();
        
        Marca m1= new Marca();
        Marca m2= new Marca();
        Marca m3= new Marca();
        
        m1.setNombre("Hershey's");
        m1.setDescripcion("Marca de chocolates.");
        
        m2.setNombre("Disney");
        m2.setDescripcion("Marca de peluches.");
        
        m3.setNombre("Hitex's");
        m3.setDescripcion("Marca de globos.");
        
        p1.setNombre("Chocolate Blanco");
        p1.setMedida("110gr");
        p1.setDescripcion("Chocolate blanco Hershey's de 110gr");
        p1.setExistencia(20);
        p1.setMarcaidMarca(m1);
        p1.setPrecio((float)12);
        
        p2.setNombre("Chocolate Negro");
        p2.setMedida("110gr");
        p2.setDescripcion("Chocolate negro Hershey's de 110gr");
        p2.setExistencia(10);
        p2.setMarcaidMarca(m1);
        p2.setPrecio((float)10);
        
        p3.setNombre("Peluche de Stitch");
        p3.setMedida("20cm");
        p3.setDescripcion("Peluche de Stitch de 20cm");
        p3.setExistencia(5);
        p3.setMarcaidMarca(m2);
        p3.setPrecio((float)150);
        
        p4.setNombre("Peluche de Woody");
        p4.setMedida("30cm");
        p4.setDescripcion("Peluche de Woody de Toy Story. 30cm");
        p4.setExistencia(10);
        p4.setMarcaidMarca(m2);
        p4.setPrecio((float)350);
        
        p5.setNombre("Globos blancos");
        p5.setMedida("30u");
        p5.setDescripcion("30 unidades de globos blancos.");
        p5.setExistencia(10);
        p5.setMarcaidMarca(m3);
        p5.setPrecio((float)5);
        
        MarcaJpaController marcaController = new MarcaJpaController(emf);
        ProductoJpaController productoController = new ProductoJpaController(emf);
        
        try {
            marcaController.create(m1);
            marcaController.create(m2);
            marcaController.create(m3);
            
            productoController.create(p1);
            productoController.create(p2);
            productoController.create(p3);
            productoController.create(p4);
            productoController.create(p5);
        } catch (Exception ex) {
            Logger.getLogger(IncersionInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        TypedQuery<Cafe> query = em.createNamedQuery("Cafe.findAll", Cafe.class);
//        List<Cafe> listaCafes = query.getResultList();
    }
}

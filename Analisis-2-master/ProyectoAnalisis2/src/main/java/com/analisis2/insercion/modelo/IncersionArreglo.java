package com.analisis2.insercion.modelo;

import com.analisis2.clases.modelo.Arreglo;
import com.analisis2.clases.modelo.ArregloHasProducto;
import com.analisis2.clases.modelo.ArregloHasProductoJpaController;
import com.analisis2.clases.modelo.ArregloJpaController;
import com.analisis2.programa.controlador.GrupoDeProductos;
import com.analisis2.programa.controlador.ProductoIndividual;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * @author Juan Diego Arriola
 */
public class IncersionArreglo {
    
    GrupoDeProductos grupo;
    float valor;
    
    public IncersionArreglo(GrupoDeProductos grupo, float valor)
    {
        this.grupo = grupo;
        this.valor = valor;
    }
    
    public void crearArreglo(String nombre, float valor, int existencia)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexion");
        
        Arreglo arreglo = new Arreglo();
        arreglo.setNombre(nombre);
        arreglo.setPrecioDeVenta(valor);
        arreglo.setExistencia(existencia);
        
        ArregloJpaController controladorArreglo = new ArregloJpaController(emf);
        controladorArreglo.create(arreglo);
        
        for (int i = 0; i < grupo.size(); i++) 
        {
            ArregloHasProducto agregar = new ArregloHasProducto();
            ProductoIndividual p = (ProductoIndividual) grupo.hijos.get(i);
            
            agregar.setProductoidProducto(p.getProducto());
            agregar.setArregloidArreglo(arreglo);
            agregar.setCantidad(p.getCantidad());
            
            ArregloHasProductoJpaController controladorAgregar = new ArregloHasProductoJpaController(emf);
            try {
                controladorAgregar.create(agregar);
            } catch (Exception ex) {
                Logger.getLogger(IncersionArreglo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

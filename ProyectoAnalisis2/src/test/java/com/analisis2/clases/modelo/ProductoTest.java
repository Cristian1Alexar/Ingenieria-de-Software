/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.clases.modelo;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author crist
 */
public class ProductoTest {
    
    public ProductoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdProducto method, of class Producto.
     */
    @Test
    public void testGetIdProducto() {
        System.out.println("getIdProducto");
        Producto instance = new Producto();
        Integer expResult = null;
        Integer result = instance.getIdProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdProducto method, of class Producto.
     */
    @Test
    public void testSetIdProducto() {
        System.out.println("setIdProducto");
        Integer idProducto = null;
        Producto instance = new Producto();
        instance.setIdProducto(idProducto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Producto.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Producto instance = new Producto();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Producto.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Producto instance = new Producto();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExistencia method, of class Producto.
     */
    @Test
    public void testGetExistencia() {
        System.out.println("getExistencia");
        Producto instance = new Producto();
        int expResult = 0;
        int result = instance.getExistencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExistencia method, of class Producto.
     */
    @Test
    public void testSetExistencia() {
        System.out.println("setExistencia");
        int existencia = 0;
        Producto instance = new Producto();
        instance.setExistencia(existencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcion method, of class Producto.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Producto instance = new Producto();
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class Producto.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Producto instance = new Producto();
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMedida method, of class Producto.
     */
    @Test
    public void testGetMedida() {
        System.out.println("getMedida");
        Producto instance = new Producto();
        String expResult = "";
        String result = instance.getMedida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMedida method, of class Producto.
     */
    @Test
    public void testSetMedida() {
        System.out.println("setMedida");
        String medida = "";
        Producto instance = new Producto();
        instance.setMedida(medida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecio method, of class Producto.
     */
    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        Producto instance = new Producto();
        Integer expResult = null;
        Integer result = instance.getPrecio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecio method, of class Producto.
     */
    @Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        Integer precio = null;
        Producto instance = new Producto();
        instance.setPrecio(precio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArregloHasProductoCollection method, of class Producto.
     */
    @Test
    public void testGetArregloHasProductoCollection() {
        System.out.println("getArregloHasProductoCollection");
        Producto instance = new Producto();
        Collection<ArregloHasProducto> expResult = null;
        Collection<ArregloHasProducto> result = instance.getArregloHasProductoCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArregloHasProductoCollection method, of class Producto.
     */
    @Test
    public void testSetArregloHasProductoCollection() {
        System.out.println("setArregloHasProductoCollection");
        Collection<ArregloHasProducto> arregloHasProductoCollection = null;
        Producto instance = new Producto();
        instance.setArregloHasProductoCollection(arregloHasProductoCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetallefacturacompraCollection method, of class Producto.
     */
    @Test
    public void testGetDetallefacturacompraCollection() {
        System.out.println("getDetallefacturacompraCollection");
        Producto instance = new Producto();
        Collection<Detallefacturacompra> expResult = null;
        Collection<Detallefacturacompra> result = instance.getDetallefacturacompraCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetallefacturacompraCollection method, of class Producto.
     */
    @Test
    public void testSetDetallefacturacompraCollection() {
        System.out.println("setDetallefacturacompraCollection");
        Collection<Detallefacturacompra> detallefacturacompraCollection = null;
        Producto instance = new Producto();
        instance.setDetallefacturacompraCollection(detallefacturacompraCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarcaidMarca method, of class Producto.
     */
    @Test
    public void testGetMarcaidMarca() {
        System.out.println("getMarcaidMarca");
        Producto instance = new Producto();
        Marca expResult = null;
        Marca result = instance.getMarcaidMarca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMarcaidMarca method, of class Producto.
     */
    @Test
    public void testSetMarcaidMarca() {
        System.out.println("setMarcaidMarca");
        Marca marcaidMarca = null;
        Producto instance = new Producto();
        instance.setMarcaidMarca(marcaidMarca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Producto.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Producto instance = new Producto();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Producto.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Producto instance = new Producto();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Producto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Producto instance = new Producto();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.clases.modelo;

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
public class CuentaTest {
    
    public CuentaTest() {
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
     * Test of getIdCuenta method, of class Cuenta.
     */
    @Test
    public void testGetIdCuenta() {
        System.out.println("getIdCuenta");
        Cuenta instance = new Cuenta();
        Integer expResult = null;
        Integer result = instance.getIdCuenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCuenta method, of class Cuenta.
     */
    @Test
    public void testSetIdCuenta() {
        System.out.println("setIdCuenta");
        Integer idCuenta = null;
        Cuenta instance = new Cuenta();
        instance.setIdCuenta(idCuenta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Cuenta.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Cuenta instance = new Cuenta();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Cuenta.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Cuenta instance = new Cuenta();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonto method, of class Cuenta.
     */
    @Test
    public void testGetMonto() {
        System.out.println("getMonto");
        Cuenta instance = new Cuenta();
        int expResult = 0;
        int result = instance.getMonto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMonto method, of class Cuenta.
     */
    @Test
    public void testSetMonto() {
        System.out.println("setMonto");
        int monto = 0;
        Cuenta instance = new Cuenta();
        instance.setMonto(monto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Cuenta.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Cuenta instance = new Cuenta();
        int expResult = 0;
        int result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
        
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipo method, of class Cuenta.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        int tipo = 0;
        Cuenta instance = new Cuenta();
        instance.setTipo(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Cuenta.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Cuenta instance = new Cuenta();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Cuenta.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Cuenta instance = new Cuenta();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Cuenta.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Cuenta instance = new Cuenta();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

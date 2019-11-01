/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.programa.controlador;

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
public class IngresoTest {
    
    public IngresoTest() {
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
     * Test of getValor method, of class Ingreso.
     */
   
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Ingreso instance = new Ingreso();
        int expResult = 2;
        int result = instance.getTipo();
        assertEquals(expResult, result);
        if (expResult != result)
        {
            fail("La clase no devuelve el parametro esperado.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}

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
public class ActivoTest {
    
    public ActivoTest() {
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
     * Test of getValor method, of class Activo.
     */

    /**
     * Test of getNombre method, of class Activo.
     */
  

    /**
     * Test of setNombre method, of class Activo.
     */



    /**
     * Test of getMonto method, of class Activo.
     */
   

    /**
     * Test of setMonto method, of class Activo.
     */
   

    /**
     * Test of getTipo method, of class Activo.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Activo instance = new Activo();
        int expResult = 1;
        int result = instance.getTipo();
        assertEquals(expResult, result);
        if (expResult != result)
        {
            fail("La clase no devuelve el parametro correcto.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}

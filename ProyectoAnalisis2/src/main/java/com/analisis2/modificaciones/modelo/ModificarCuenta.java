/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.modificaciones.modelo;

import com.analisis2.clases.modelo.Cuenta;
import com.analisis2.clases.modelo.EM;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author crist
 */
public class ModificarCuenta implements Modificar{

    public ModificarCuenta() {
    }

    @Override
    public void modificar(int id, int valor) {
        EM e = EM.crearEntityManager();
        EntityManager em = e.getEntity();
        EntityTransaction et = em.getTransaction(); 
        Cuenta cuenta = em.find(Cuenta.class,id);
        cuenta.setMonto(valor);
        
        et.begin();
        em.merge(cuenta);
        et.commit();
        System.out.println("Edicion Realizada");
        
            
            
       
               
    }   
}

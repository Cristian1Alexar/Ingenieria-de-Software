/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.insercion.modelo;

import com.analisis2.clases.modelo.Cuenta;
import com.analisis2.clases.modelo.CuentaJpaController;
import com.analisis2.programa.controlador.Cuentas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author crist
 */
public class IncersionCuenta implements Insercion {

    public IncersionCuenta() {
    }

    
    @Override
    public void insertar(Cuentas cuentaf) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexion");

        //TypedQuery<Cuenta> queryCuenta = em.createNamedQuery("Cuenta.findByNombre", Cuenta.class);
        //queryCuenta.setParameter("nombre", cuentaf.getNombre());
       // Cuenta c = queryCuenta.getSingleResult();
        Cuenta nuevacuenta = new Cuenta();
        nuevacuenta.setNombre(cuentaf.getNombre());
        nuevacuenta.setMonto((int) cuentaf.getValor());
        nuevacuenta.setTipo((int) cuentaf.getTipo());
        
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\" + cuentaf.getTipo());
       
        CuentaJpaController cuentaController = new CuentaJpaController(emf);
        cuentaController.create(nuevacuenta);   
    }  
}

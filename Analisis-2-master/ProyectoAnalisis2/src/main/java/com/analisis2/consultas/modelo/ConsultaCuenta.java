/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.consultas.modelo;

import com.analisis2.clases.modelo.Cuenta;
import com.analisis2.clases.modelo.EM;
import com.analisis2.clases.modelo.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author crist
 */
public class ConsultaCuenta implements ConsultaDeObjetos{

    public ConsultaCuenta() {
    }

    
    @Override
    public List consultar() {
        EM e = EM.crearEntityManager();
        EntityManager em = e.getEntity();
        TypedQuery<Cuenta> queryProducto = em.createNamedQuery("Cuenta.findAll", Cuenta.class);
        List<Cuenta> listaCuenta = queryProducto.getResultList();
        return listaCuenta;
    }
    
}

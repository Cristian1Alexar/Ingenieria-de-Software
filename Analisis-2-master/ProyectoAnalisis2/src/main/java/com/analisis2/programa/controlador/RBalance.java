/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.programa.controlador;

import java.util.ArrayList;

/**
 *
 * @author crist
 */

public class RBalance implements Reporte{

    private ClasificadorCuenta cuentas; 
    private float capital; 

    public RBalance(ClasificadorCuenta clasificador) {
        this.cuentas = clasificador;
    }
    
    
    
    
    
    
    
    
    @Override
    public float calcularValores() {
      capital = cuentas.getValorActivo() - cuentas.getValorPasivo();
      return  capital;
    }
    
}

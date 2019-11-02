/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.programa.controlador;

import static com.analisis2.clases.tipos.TiposCuenta.ACTIVO;
import static com.analisis2.clases.tipos.TiposCuenta.INGRESO;

/**
 *
 * @author crist
 */
public class Ingreso implements Cuentas {

    private String Nombre; 
    private float monto; 
    private int tipo = INGRESO; 

    public Ingreso() {
    }
    
    
    @Override
    public float getValor() {
        return monto; 
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getTipo() {
        return tipo;
    }
}

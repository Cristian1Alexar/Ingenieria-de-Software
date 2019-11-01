/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.programa.controlador;

import static com.analisis2.clases.tipos.TiposCuenta.ACTIVO;
import static com.analisis2.clases.tipos.TiposCuenta.COSTO;
import static com.analisis2.clases.tipos.TiposCuenta.GASTO;
import static com.analisis2.clases.tipos.TiposCuenta.INGRESO;
import static com.analisis2.clases.tipos.TiposCuenta.PASIVO;
import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class ClasificadorCuenta {
    private float valorActivo; 
    private float valorPasivo; 
    private float valorIngreso; 
    private float valorCosto; 
    private float valorGasto; 
    private ArrayList<Cuentas> cuentasActivo;
    private ArrayList<Cuentas> cuentasPasivo;
    private ArrayList<Cuentas> cuentasIngreso;
    private ArrayList<Cuentas> cuentasCosto;
    private ArrayList<Cuentas> cuentasGasto;

    public ClasificadorCuenta() {
        cuentasActivo = new ArrayList<Cuentas>();
        cuentasPasivo = new ArrayList<Cuentas>(); 
        cuentasIngreso = new ArrayList<Cuentas>();
        cuentasCosto = new ArrayList<Cuentas>();
        cuentasGasto = new ArrayList<Cuentas>();
    }

    public float getValorActivo() {
        for (int i = 0; i < cuentasActivo.size(); i++) {
            valorActivo = valorActivo + cuentasActivo.get(i).getValor(); 
        }
        return valorActivo;
    }
    public float getValorPasivo() {
        for (int i = 0; i < cuentasPasivo.size(); i++) {
            valorPasivo = valorPasivo + cuentasPasivo.get(i).getValor(); 
        }
        return valorPasivo;
    }
    public float getValorIngreso() {
        for (int i = 0; i < cuentasIngreso.size(); i++) {
            valorIngreso = valorIngreso + cuentasIngreso.get(i).getValor(); 
        }
        return valorIngreso;
    }
    public float getValorCosto() {
        for (int i = 0; i < cuentasCosto.size(); i++) {
            valorCosto = valorCosto + cuentasCosto.get(i).getValor(); 
        }
        return valorCosto;
    }
    public float getValorGasto() {
        for (int i = 0; i < cuentasGasto.size(); i++) {
            valorGasto = valorGasto + cuentasGasto.get(i).getValor(); 
        }
        return valorCosto;
    }

    public ArrayList<Cuentas> getCuentasActivo() {
        return cuentasActivo;
    }

    public ArrayList<Cuentas> getCuentasPasivo() {
        return cuentasPasivo;
    }
    public ArrayList<Cuentas> getCuentasIngreso() {
        return cuentasIngreso;
    }
    public ArrayList<Cuentas> getCuentasCosto() {
        return cuentasCosto;
    }
    public ArrayList<Cuentas> getCuentasGasto() {
        return cuentasGasto;
    }
    

    public void clasificarCuenta(Cuentas cuenta) {
        if (cuenta.getTipo() == ACTIVO)
        {
            cuentasActivo.add(cuenta);
        }
        if (cuenta.getTipo() == PASIVO)
        {
            cuentasPasivo.add(cuenta);
        }
        if (cuenta.getTipo() == INGRESO)
        {
            cuentasIngreso.add(cuenta);
        }
        if (cuenta.getTipo() == COSTO)
        {
            cuentasCosto.add(cuenta);
        }
        if (cuenta.getTipo() == GASTO)
        {
            cuentasGasto.add(cuenta);
        }
    }
    
    
}

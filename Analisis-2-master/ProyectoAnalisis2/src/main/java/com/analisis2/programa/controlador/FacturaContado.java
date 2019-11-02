package com.analisis2.programa.controlador;

/*
 * @author Juan Diego Arriola
 */
public class FacturaContado implements IFactura{
    private float total = 0;
    
    @Override
    public float actualizar(int cantidad, float precio)
    {
        float subtotal = cantidad * precio;
        this.total = this.total + subtotal;
        return subtotal;
    }
    
    @Override
    public float getTotal()
    {
        return this.total;
    }
}

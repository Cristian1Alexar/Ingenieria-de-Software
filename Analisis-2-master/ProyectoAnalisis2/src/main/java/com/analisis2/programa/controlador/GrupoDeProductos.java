package com.analisis2.programa.controlador;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Juan Diego Arriola
 */
public class GrupoDeProductos implements CreadorArreglo{
    
    public List<CreadorArreglo> hijos = new ArrayList<>();
    
    public GrupoDeProductos(){}
    
    @Override
    public float getPrecio() {
        float precio = 0;
        for (CreadorArreglo producto : hijos) 
        {
            precio = precio + producto.getPrecio();
        }
        return precio;
    }

    public void agregar(CreadorArreglo g) {
        hijos.add(g);
    }
    
    public int size()
    {
        return hijos.size();
    }

    public void eliminar(CreadorArreglo g) {
        hijos.remove(g);
    }
    
    public int numeroProductos()
    {
        return hijos.size();
    }
}

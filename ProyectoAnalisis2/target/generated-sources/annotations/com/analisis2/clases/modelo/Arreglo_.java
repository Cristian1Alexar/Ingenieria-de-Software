package com.analisis2.clases.modelo;

import com.analisis2.clases.modelo.ArregloHasProducto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-10-28T19:24:09")
@StaticMetamodel(Arreglo.class)
public class Arreglo_ { 

    public static volatile SingularAttribute<Arreglo, Integer> idArreglo;
    public static volatile SingularAttribute<Arreglo, Integer> existencia;
    public static volatile SingularAttribute<Arreglo, Float> precioDeVenta;
    public static volatile CollectionAttribute<Arreglo, ArregloHasProducto> arregloHasProductoCollection;
    public static volatile SingularAttribute<Arreglo, String> nombre;

}
package com.analisis2.clases.modelo;

import com.analisis2.clases.modelo.Facturacompra;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-11-03T22:54:41")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile CollectionAttribute<Proveedores, Facturacompra> facturacompraCollection;
    public static volatile SingularAttribute<Proveedores, Integer> idProveedores;
    public static volatile SingularAttribute<Proveedores, String> nit;
    public static volatile SingularAttribute<Proveedores, String> direccion;
    public static volatile SingularAttribute<Proveedores, String> nombre;

}
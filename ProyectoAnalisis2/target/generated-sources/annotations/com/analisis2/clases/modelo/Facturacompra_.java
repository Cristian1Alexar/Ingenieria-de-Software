package com.analisis2.clases.modelo;

import com.analisis2.clases.modelo.Detallefacturacompra;
import com.analisis2.clases.modelo.Proveedores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-10-28T19:24:09")
@StaticMetamodel(Facturacompra.class)
public class Facturacompra_ { 

    public static volatile SingularAttribute<Facturacompra, Integer> idFacturaCompra;
    public static volatile SingularAttribute<Facturacompra, Date> fecha;
    public static volatile SingularAttribute<Facturacompra, Float> total;
    public static volatile CollectionAttribute<Facturacompra, Detallefacturacompra> detallefacturacompraCollection;
    public static volatile SingularAttribute<Facturacompra, Proveedores> proveedoresidProveedores;

}
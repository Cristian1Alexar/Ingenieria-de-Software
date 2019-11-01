package com.analisis2.clases.modelo;

import com.analisis2.clases.modelo.Facturacompra;
import com.analisis2.clases.modelo.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-10-28T19:24:09")
@StaticMetamodel(Detallefacturacompra.class)
public class Detallefacturacompra_ { 

    public static volatile SingularAttribute<Detallefacturacompra, Integer> idDetalleFacturaCompra;
    public static volatile SingularAttribute<Detallefacturacompra, Producto> productoidProducto;
    public static volatile SingularAttribute<Detallefacturacompra, Float> subtotal;
    public static volatile SingularAttribute<Detallefacturacompra, Facturacompra> facturaCompraidFacturaCompra;
    public static volatile SingularAttribute<Detallefacturacompra, Integer> cantidad;

}
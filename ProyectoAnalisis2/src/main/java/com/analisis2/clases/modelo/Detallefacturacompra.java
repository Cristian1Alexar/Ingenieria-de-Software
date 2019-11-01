/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.clases.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author crist
 */
@Entity
@Table(name = "detallefacturacompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallefacturacompra.findAll", query = "SELECT d FROM Detallefacturacompra d")
    , @NamedQuery(name = "Detallefacturacompra.findByIdDetalleFacturaCompra", query = "SELECT d FROM Detallefacturacompra d WHERE d.idDetalleFacturaCompra = :idDetalleFacturaCompra")
    , @NamedQuery(name = "Detallefacturacompra.findBySubtotal", query = "SELECT d FROM Detallefacturacompra d WHERE d.subtotal = :subtotal")
    , @NamedQuery(name = "Detallefacturacompra.findByCantidad", query = "SELECT d FROM Detallefacturacompra d WHERE d.cantidad = :cantidad")})
public class Detallefacturacompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleFacturaCompra")
    private Integer idDetalleFacturaCompra;
    @Basic(optional = false)
    @Column(name = "Subtotal")
    private float subtotal;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @JoinColumn(name = "FacturaCompra_idFacturaCompra", referencedColumnName = "idFacturaCompra")
    @ManyToOne(optional = false)
    private Facturacompra facturaCompraidFacturaCompra;
    @JoinColumn(name = "Producto_idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto productoidProducto;

    public Detallefacturacompra() {
    }

    public Detallefacturacompra(Integer idDetalleFacturaCompra) {
        this.idDetalleFacturaCompra = idDetalleFacturaCompra;
    }

    public Detallefacturacompra(Integer idDetalleFacturaCompra, float subtotal, int cantidad) {
        this.idDetalleFacturaCompra = idDetalleFacturaCompra;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
    }

    public Integer getIdDetalleFacturaCompra() {
        return idDetalleFacturaCompra;
    }

    public void setIdDetalleFacturaCompra(Integer idDetalleFacturaCompra) {
        this.idDetalleFacturaCompra = idDetalleFacturaCompra;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Facturacompra getFacturaCompraidFacturaCompra() {
        return facturaCompraidFacturaCompra;
    }

    public void setFacturaCompraidFacturaCompra(Facturacompra facturaCompraidFacturaCompra) {
        this.facturaCompraidFacturaCompra = facturaCompraidFacturaCompra;
    }

    public Producto getProductoidProducto() {
        return productoidProducto;
    }

    public void setProductoidProducto(Producto productoidProducto) {
        this.productoidProducto = productoidProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleFacturaCompra != null ? idDetalleFacturaCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallefacturacompra)) {
            return false;
        }
        Detallefacturacompra other = (Detallefacturacompra) object;
        if ((this.idDetalleFacturaCompra == null && other.idDetalleFacturaCompra != null) || (this.idDetalleFacturaCompra != null && !this.idDetalleFacturaCompra.equals(other.idDetalleFacturaCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.analisis2.clases.modelo.Detallefacturacompra[ idDetalleFacturaCompra=" + idDetalleFacturaCompra + " ]";
    }
    
}

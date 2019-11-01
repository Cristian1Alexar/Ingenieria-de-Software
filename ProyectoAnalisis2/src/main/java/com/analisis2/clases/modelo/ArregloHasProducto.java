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
@Table(name = "arreglo_has_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArregloHasProducto.findAll", query = "SELECT a FROM ArregloHasProducto a")
    , @NamedQuery(name = "ArregloHasProducto.findByCantidad", query = "SELECT a FROM ArregloHasProducto a WHERE a.cantidad = :cantidad")
    , @NamedQuery(name = "ArregloHasProducto.findById", query = "SELECT a FROM ArregloHasProducto a WHERE a.id = :id")})
public class ArregloHasProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "Arreglo_idArreglo", referencedColumnName = "idArreglo")
    @ManyToOne(optional = false)
    private Arreglo arregloidArreglo;
    @JoinColumn(name = "Producto_idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto productoidProducto;

    public ArregloHasProducto() {
    }

    public ArregloHasProducto(Integer id) {
        this.id = id;
    }

    public ArregloHasProducto(Integer id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Arreglo getArregloidArreglo() {
        return arregloidArreglo;
    }

    public void setArregloidArreglo(Arreglo arregloidArreglo) {
        this.arregloidArreglo = arregloidArreglo;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArregloHasProducto)) {
            return false;
        }
        ArregloHasProducto other = (ArregloHasProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.analisis2.clases.modelo.ArregloHasProducto[ id=" + id + " ]";
    }
    
}

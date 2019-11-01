/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.clases.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author crist
 */
@Entity
@Table(name = "arreglo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arreglo.findAll", query = "SELECT a FROM Arreglo a")
    , @NamedQuery(name = "Arreglo.findByIdArreglo", query = "SELECT a FROM Arreglo a WHERE a.idArreglo = :idArreglo")
    , @NamedQuery(name = "Arreglo.findByNombre", query = "SELECT a FROM Arreglo a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Arreglo.findByPrecioDeVenta", query = "SELECT a FROM Arreglo a WHERE a.precioDeVenta = :precioDeVenta")
    , @NamedQuery(name = "Arreglo.findByExistencia", query = "SELECT a FROM Arreglo a WHERE a.existencia = :existencia")})
public class Arreglo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idArreglo")
    private Integer idArreglo;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "PrecioDeVenta")
    private float precioDeVenta;
    @Basic(optional = false)
    @Column(name = "Existencia")
    private int existencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arregloidArreglo")
    private Collection<ArregloHasProducto> arregloHasProductoCollection;

    public Arreglo() {
    }

    public Arreglo(Integer idArreglo) {
        this.idArreglo = idArreglo;
    }

    public Arreglo(Integer idArreglo, String nombre, float precioDeVenta, int existencia) {
        this.idArreglo = idArreglo;
        this.nombre = nombre;
        this.precioDeVenta = precioDeVenta;
        this.existencia = existencia;
    }

    public Integer getIdArreglo() {
        return idArreglo;
    }

    public void setIdArreglo(Integer idArreglo) {
        this.idArreglo = idArreglo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(float precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    @XmlTransient
    public Collection<ArregloHasProducto> getArregloHasProductoCollection() {
        return arregloHasProductoCollection;
    }

    public void setArregloHasProductoCollection(Collection<ArregloHasProducto> arregloHasProductoCollection) {
        this.arregloHasProductoCollection = arregloHasProductoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArreglo != null ? idArreglo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arreglo)) {
            return false;
        }
        Arreglo other = (Arreglo) object;
        if ((this.idArreglo == null && other.idArreglo != null) || (this.idArreglo != null && !this.idArreglo.equals(other.idArreglo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.analisis2.clases.modelo.Arreglo[ idArreglo=" + idArreglo + " ]";
    }
    
}

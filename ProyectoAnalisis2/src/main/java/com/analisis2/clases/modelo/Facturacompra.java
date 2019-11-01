/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.clases.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author crist
 */
@Entity
@Table(name = "facturacompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturacompra.findAll", query = "SELECT f FROM Facturacompra f")
    , @NamedQuery(name = "Facturacompra.findByIdFacturaCompra", query = "SELECT f FROM Facturacompra f WHERE f.idFacturaCompra = :idFacturaCompra")
    , @NamedQuery(name = "Facturacompra.findByTotal", query = "SELECT f FROM Facturacompra f WHERE f.total = :total")
    , @NamedQuery(name = "Facturacompra.findByFecha", query = "SELECT f FROM Facturacompra f WHERE f.fecha = :fecha")})
public class Facturacompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFacturaCompra")
    private Integer idFacturaCompra;
    @Basic(optional = false)
    @Column(name = "Total")
    private float total;
    @Basic(optional = false)
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "Proveedores_idProveedores", referencedColumnName = "idProveedores")
    @ManyToOne(optional = false)
    private Proveedores proveedoresidProveedores;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaCompraidFacturaCompra")
    private Collection<Detallefacturacompra> detallefacturacompraCollection;

    public Facturacompra() {
    }

    public Facturacompra(Integer idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public Facturacompra(Integer idFacturaCompra, float total, Date fecha) {
        this.idFacturaCompra = idFacturaCompra;
        this.total = total;
        this.fecha = fecha;
    }

    public Integer getIdFacturaCompra() {
        return idFacturaCompra;
    }

    public void setIdFacturaCompra(Integer idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Proveedores getProveedoresidProveedores() {
        return proveedoresidProveedores;
    }

    public void setProveedoresidProveedores(Proveedores proveedoresidProveedores) {
        this.proveedoresidProveedores = proveedoresidProveedores;
    }

    @XmlTransient
    public Collection<Detallefacturacompra> getDetallefacturacompraCollection() {
        return detallefacturacompraCollection;
    }

    public void setDetallefacturacompraCollection(Collection<Detallefacturacompra> detallefacturacompraCollection) {
        this.detallefacturacompraCollection = detallefacturacompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturaCompra != null ? idFacturaCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturacompra)) {
            return false;
        }
        Facturacompra other = (Facturacompra) object;
        if ((this.idFacturaCompra == null && other.idFacturaCompra != null) || (this.idFacturaCompra != null && !this.idFacturaCompra.equals(other.idFacturaCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.analisis2.clases.modelo.Facturacompra[ idFacturaCompra=" + idFacturaCompra + " ]";
    }
    
}

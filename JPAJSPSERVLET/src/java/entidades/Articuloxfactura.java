/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Campus FP
 */
@Entity
@Table(name = "articuloxfactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articuloxfactura.findAll", query = "SELECT a FROM Articuloxfactura a")
    , @NamedQuery(name = "Articuloxfactura.findByIdFactura", query = "SELECT a FROM Articuloxfactura a WHERE a.articuloxfacturaPK.idFactura = :idFactura")
    , @NamedQuery(name = "Articuloxfactura.findByIdArticulo", query = "SELECT a FROM Articuloxfactura a WHERE a.articuloxfacturaPK.idArticulo = :idArticulo")
    , @NamedQuery(name = "Articuloxfactura.findByCantidad", query = "SELECT a FROM Articuloxfactura a WHERE a.cantidad = :cantidad")})
public class Articuloxfactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArticuloxfacturaPK articuloxfacturaPK;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @JoinColumn(name = "IdFactura", referencedColumnName = "IdFactura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Factura factura;
    @JoinColumn(name = "IdArticulo", referencedColumnName = "IdArticulo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Articulo articulo;

    public Articuloxfactura() {
    }

    public Articuloxfactura(ArticuloxfacturaPK articuloxfacturaPK) {
        this.articuloxfacturaPK = articuloxfacturaPK;
    }

    public Articuloxfactura(ArticuloxfacturaPK articuloxfacturaPK, int cantidad) {
        this.articuloxfacturaPK = articuloxfacturaPK;
        this.cantidad = cantidad;
    }

    public Articuloxfactura(String idFactura, String idArticulo) {
        this.articuloxfacturaPK = new ArticuloxfacturaPK(idFactura, idArticulo);
    }

    public ArticuloxfacturaPK getArticuloxfacturaPK() {
        return articuloxfacturaPK;
    }

    public void setArticuloxfacturaPK(ArticuloxfacturaPK articuloxfacturaPK) {
        this.articuloxfacturaPK = articuloxfacturaPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articuloxfacturaPK != null ? articuloxfacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articuloxfactura)) {
            return false;
        }
        Articuloxfactura other = (Articuloxfactura) object;
        if ((this.articuloxfacturaPK == null && other.articuloxfacturaPK != null) || (this.articuloxfacturaPK != null && !this.articuloxfacturaPK.equals(other.articuloxfacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Articuloxfactura[ articuloxfacturaPK=" + articuloxfacturaPK + " ]";
    }
    
}

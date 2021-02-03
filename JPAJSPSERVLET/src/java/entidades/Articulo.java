/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Campus FP
 */
@Entity
@Table(name = "articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a")
    , @NamedQuery(name = "Articulo.findByIdArticulo", query = "SELECT a FROM Articulo a WHERE a.idArticulo = :idArticulo")
    , @NamedQuery(name = "Articulo.findByPrecioUnitario", query = "SELECT a FROM Articulo a WHERE a.precioUnitario = :precioUnitario")
    , @NamedQuery(name = "Articulo.findByDescripcion", query = "SELECT a FROM Articulo a WHERE a.descripcion = :descripcion")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdArticulo")
    private String idArticulo;
    @Basic(optional = false)
    @Column(name = "PrecioUnitario")
    private double precioUnitario;
    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articulo")
    private List<Articuloxfactura> articuloxfacturaList;

    public Articulo() {
    }

    public Articulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Articulo(String idArticulo, double precioUnitario, String descripcion) {
        this.idArticulo = idArticulo;
        this.precioUnitario = precioUnitario;
        this.descripcion = descripcion;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Articuloxfactura> getArticuloxfacturaList() {
        return articuloxfacturaList;
    }

    public void setArticuloxfacturaList(List<Articuloxfactura> articuloxfacturaList) {
        this.articuloxfacturaList = articuloxfacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }
    
    
    /*@Override
    public String toString1() {
        return "entidades.Articulo[ idArticulo=" + idArticulo + " ]";
    }*/

    @Override
    public String toString() {
        return "Articulo{" + "idArticulo=" + idArticulo + ", precioUnitario=" + precioUnitario + ", descripcion=" + descripcion + '}';
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Campus FP
 */
@Embeddable
public class ArticuloxfacturaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "IdFactura")
    private String idFactura;
    @Basic(optional = false)
    @Column(name = "IdArticulo")
    private String idArticulo;

    public ArticuloxfacturaPK() {
    }

    public ArticuloxfacturaPK(String idFactura, String idArticulo) {
        this.idFactura = idFactura;
        this.idArticulo = idArticulo;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticuloxfacturaPK)) {
            return false;
        }
        ArticuloxfacturaPK other = (ArticuloxfacturaPK) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ArticuloxfacturaPK[ idFactura=" + idFactura + ", idArticulo=" + idArticulo + " ]";
    }
    
}

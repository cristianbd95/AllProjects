
package psw;

import java.util.Date;


public class Transaccion {
    int referencia;
    String fechaAlta;
    String tipo;
    String operacion;
    String provincia;
    int superficie;
    int precioVenta;
    String fechaVenta;
    String vendedor;

    public Transaccion() {
    }

    public Transaccion(int referencia, String fechaAlta, String tipo, String operacion, String provincia, int superficie, int precioVenta, String fechaVenta, String vendedor) {
        this.referencia = referencia;
        this.fechaAlta = fechaAlta;
        this.tipo = tipo;
        this.operacion = operacion;
        this.provincia = provincia;
        this.superficie = superficie;
        this.precioVenta = precioVenta;
        this.fechaVenta = fechaVenta;
        this.vendedor = vendedor;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "referencia=" + referencia + ", fechaAlta=" + fechaAlta + ", tipo=" + tipo + ", operacion=" + operacion + ", provincia=" + provincia + ", superficie=" + superficie + ", precioVenta=" + precioVenta + ", fechaVenta=" + fechaVenta + ", vendedor=" + vendedor + '}';
    }

    
    
}

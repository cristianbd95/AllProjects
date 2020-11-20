package hilo6;

public class Cliente {

    private Cuenta cuenta;
    private int cantidad;
    private int numeroCliente;
    private String texto;

    public Cliente(Cuenta cuenta, int cantidad, int numeroCliente, String texto) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
        this.numeroCliente = numeroCliente;
        this.texto = texto;
    }

    public void hacerMovimiento(Cuenta cuenta, int cantidad) {
        cuenta.hacerMovimiento(cantidad);
    }

    public int getNumeroCliente() {
        return this.numeroCliente;
    }

    public int getCantidad() {
        return this.cantidad;
    }
    
    public Cuenta getCuenta() {
        return this.cuenta;
    }
    
    public String getTexto() {
        return this.texto;
    }
}

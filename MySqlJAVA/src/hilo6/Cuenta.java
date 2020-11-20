package hilo6;

public class Cuenta {

    private int saldo;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    public synchronized void hacerMovimiento(int cantidad) {
        this.saldo = this.saldo + cantidad;
    }

    public int getSaldo() {
        return this.saldo;
    }
}

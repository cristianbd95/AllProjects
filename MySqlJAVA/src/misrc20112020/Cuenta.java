
package misrc20112020;

public class Cuenta {
    private int saldo;
    private int saldoInicial;

    public Cuenta() {
    }

    public Cuenta(int saldo) {
        this.saldoInicial = saldo;
        this.saldo = saldo;
    }
    
    public synchronized void hacerMovimiento(int cantidad){
        this.saldo = this.saldo +cantidad;
    }
    
    public boolean esSimulacionCorrecta(){
        if(this.saldo==this.saldoInicial){
            return true;
        }
        return false;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(int saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "saldo=" + saldo + ", saldoInicial=" + saldoInicial + '}';
    }
    
    
    
}

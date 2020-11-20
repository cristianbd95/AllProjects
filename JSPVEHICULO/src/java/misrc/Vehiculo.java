
package misrc;

import java.io.Serializable;

public class Vehiculo implements Serializable{
    String matricula;
    String marca;
    Double deposito;
    String modelo;

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String marca, Double deposito, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.deposito = deposito;
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getDeposito() {
        return deposito;
    }

    public void setDeposito(Double deposito) {
        this.deposito = deposito;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", marca=" + marca + ", deposito=" + deposito + ", modelo=" + modelo + '}';
    }
    
    
    
}

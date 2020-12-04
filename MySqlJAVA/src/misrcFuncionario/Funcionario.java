
package misrcFuncionario;

public class Funcionario {
    private double salario;

    public Funcionario() {
    }

    public Funcionario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "salario=" + salario + '}';
    }
    
    
}

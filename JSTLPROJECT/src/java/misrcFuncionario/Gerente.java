
package misrcFuncionario;



public class Gerente extends Funcionario implements Autorizacion{
    
    public int clave;

    @Override
    public double Salario() {
        return 5000;
    }
    
    public int getClave(int claveBD){
        return claveBD;
    }

    @Override
    public boolean autorizado(int clave, int claveBD) {
        if(getClave(claveBD) != clave){
            return false;
        }
        return true;
    }

  
    
}

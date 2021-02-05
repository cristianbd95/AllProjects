
package misrcFuncionario;

public class Controlador {
    
    public boolean login(Autorizacion a, int clave, int claveBD){
        boolean bandera;
        boolean ok = a.autorizado(clave, claveBD);
        if(ok == true){
            bandera = true;
        }else{
            bandera = false;
        }
        return bandera;
    }
    
    public void informacion(Funcionario a){
        System.out.println("Sueldo = " + a.Salario());
    }
    
    
}

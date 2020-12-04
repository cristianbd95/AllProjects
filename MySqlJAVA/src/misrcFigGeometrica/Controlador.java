
package misrcFigGeometrica;

public class Controlador {
  
    public void gestorFigurasGeometricasCI(){
        System.out.print("Ingrese radio = ");
        double radio = Entrada.readDou();
        
        Circulo ci = new Circulo(radio);
        
        
        FiguraGeometrica2D figura2d = ci;
        System.out.println("Area " + figura2d.area());
        System.out.println("Dimension " + figura2d.dimension());
        System.out.println("Soy " + figura2d.soy());
    }
    
    public void gestorFigurasGeometricasCO(){
        System.out.print("Ingrese radio = ");
        double radio = Entrada.readDou();
        System.out.print("Ingrese altura = ");
        double altura = Entrada.readDou();
        
        Cono co = new Cono(radio, altura);
        
        
        FiguraGeometrica3D figura3d = co;
        System.out.println("Area " + figura3d.volumen());
        System.out.println("Dimension " + figura3d.dimension());
        System.out.println("Soy " + figura3d.soy());
    }
    
}

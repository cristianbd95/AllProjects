
package misrcPolimorfismo;


public class Main {

    
    public static void main(String[] args) {
        
        FiguraGeometrica2D figura2d; //creo una variable de Figura geometrica
        
        figura2d = new Triangulo(5,6); //5 y 6 son la base y la altura, las variables que tiene
        
        System.out.println("Area        = " + figura2d.area());
        System.out.println("Perimetro   = " + figura2d.perimetro());
        System.out.println("Soy         = " + figura2d.soy());
        System.out.println("base = " + ((Triangulo)figura2d).getBase()); //porque base esta en triangulo, para llamar al metodo de Triangulo hay que hacer esto,
                                                                         // si no estaria llamando al metodo FiguraGeometrica2D, y no podria llamar a la base
        System.out.println();
        
        figura2d = new Circulo(8);
        System.out.println("Area        = " + figura2d.area());
        System.out.println("Perimetro   = " + figura2d.perimetro());
        System.out.println("Soy         = " + figura2d.soy());
        
        System.out.println("base = " + ((Circulo)figura2d).getRadio());
    }
    
}


package misrcPolimorfismo;

public abstract class FiguraGeometrica2D {
    
    public abstract double area();
    public abstract double perimetro();
    public abstract String soy();
    
    public String dimension(){ //esto si lo puede responder la clase abstracta, los demás metodos no
        return "2D";
    };
    
}

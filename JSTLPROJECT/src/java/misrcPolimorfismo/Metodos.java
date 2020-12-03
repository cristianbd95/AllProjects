
package misrcPolimorfismo;

public class Metodos {
        public void imprimir(FiguraGeometrica2D figura2d) {

        System.out.println("Area        = " + figura2d.area());
        System.out.println("Perimetro   = " + figura2d.perimetro());
        System.out.println("Soy         = " + figura2d.soy());
        if (figura2d instanceof Triangulo) {
            System.out.println("base = " + ((Triangulo) figura2d).getBase());
            System.out.println();                                              //porque base esta en triangulo, para llamar al metodo de Triangulo hay que hacer esto,
        } else {                                                             // si no estaria llamando al metodo FiguraGeometrica2D, y no podria llamar a la base
            System.out.println("base = " + ((Circulo) figura2d).getRadio());
            System.out.println();
        }
    }
}

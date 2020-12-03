package misrcPolimorfismo;

public class Main1 {

    static Main1 m = new Main1();  //el metodo al ser void no puedo llamarlo si no creo una instancia de Main.

    public static void main(String[] args) {

        FiguraGeometrica2D figura2d; //creo una variable de Figura geometrica

        figura2d = new Triangulo(5, 6); //5 y 6 son la base y la altura, las variables que tiene
        m.imprimir(figura2d);
        figura2d = new Circulo(8);
        m.imprimir(figura2d);

    }

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


package misrcFigGeometrica;

public class Cono extends FiguraGeometrica3D{
    
    private double altura;
    private double radio;

    public Cono() {
    }

    public Cono(double altura, double radio) {
        this.altura = altura;
        this.radio = radio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Cono{" + "altura=" + altura + ", radio=" + radio + '}';
    }

    @Override
    public double volumen() {
        return (Math.PI * Math.pow(this.radio,2) * this.altura) / 3;
    }

    @Override
    public String soy() {
        return "Cono";
    }
    
    
    
    
}


package misrcMenu;


public class Medico {
    
    int numeroConsulta;
    String fecha;
    String nombre;
    String deinpr;
    String procedencia;

    public Medico() {
    }

    public Medico(int numeroConsulta, String fecha, String nombre, String deinpr, String procedencia) {
        this.numeroConsulta = numeroConsulta;
        this.fecha = fecha;
        this.nombre = nombre;
        this.deinpr = deinpr;
        this.procedencia = procedencia;
    }

    public int getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroConsulta(int numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeinpr() {
        return deinpr;
    }

    public void setDeinpr(String deinpr) {
        this.deinpr = deinpr;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    @Override
    public String toString() {
        return "Medico{" + "numeroConsulta=" + numeroConsulta + ", fecha=" + fecha + ", nombre=" + nombre + ", deinpr=" + deinpr + ", procedencia=" + procedencia + '}';
    }
    
    
    
}


package misrcPaginacion;

public class Medico {
    int numeroConsulta;
    String fecha;
    String nombreMedico;
    String deinpr;
    String procedencia;

    public Medico() {
    }

    public Medico(int numeroConsulta, String fecha, String nombreMedico, String deinpr, String procedencia) {
        this.numeroConsulta = numeroConsulta;
        this.fecha = fecha;
        this.nombreMedico = nombreMedico;
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

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
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
        return "Medico{" + "numeroConsulta=" + numeroConsulta + ", fecha=" + fecha + ", nombreMedico=" + nombreMedico + ", deinpr=" + deinpr + ", procedencia=" + procedencia + '}';
    }
    
    
}

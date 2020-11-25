
package hilos25112020;

import java.sql.Date;

public class Consulta {
    String numeroConsulta;
    Date fecha;
    String nombreMedico;
    String deinpr;
    String procedencia;

    public Consulta() {
    }

    public Consulta(String numeroConsulta, Date fecha, String nombreMedico, String deinpr, String procedencia) {
        this.numeroConsulta = numeroConsulta;
        this.fecha = fecha;
        this.nombreMedico = nombreMedico;
        this.deinpr = deinpr;
        this.procedencia = procedencia;
    }

    public String getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroConsulta(String numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
        return "Consulta{" + "numeroConsulta=" + numeroConsulta + ", fecha=" + fecha + ", nombreMedico=" + nombreMedico + ", deinpr=" + deinpr + ", procedencia=" + procedencia + '}';
    }
    
    
}

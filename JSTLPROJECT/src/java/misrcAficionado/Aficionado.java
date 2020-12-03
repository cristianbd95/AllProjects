package misrcAficionado;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Aficionado {
    int idaficionado;
    String nombre;
    Date fechanacimiento;
    String ciudad;
    String estadocivil;
    List<String> aficionado_al = new ArrayList<String>();

    public Aficionado() {
    }

    public Aficionado(int idaficionado, String nombre, Date fechanacimiento, String ciudad, String estadocivil, List<String> aficionado_al) {
        this.idaficionado = idaficionado;
        this.nombre = nombre;
        this.fechanacimiento = fechanacimiento;
        this.ciudad = ciudad;
        this.estadocivil = estadocivil;
        this.aficionado_al = aficionado_al;
    }

    public int getIdaficionado() {
        return idaficionado;
    }

    public void setIdaficionado(int idaficionado) {
        this.idaficionado = idaficionado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public List<String> getAficionado_al() {
        return aficionado_al;
    }

    public void setAficionado_al(List<String> aficionado_al) {
        this.aficionado_al = aficionado_al;
    }

    @Override
    public String toString() {
        return "Aficionado{" + "idaficionado=" + idaficionado + ", nombre=" + nombre + ", fechanacimiento=" + fechanacimiento + ", ciudad=" + ciudad + ", estadocivil=" + estadocivil + ", aficionado_al=" + aficionado_al + '}';
    }
    
    
    
}

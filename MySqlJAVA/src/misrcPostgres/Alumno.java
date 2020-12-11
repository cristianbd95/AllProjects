
package misrcPostgres;


public class Alumno {
    String id;
    String nombresApellidos;
    String carrera;
    String direccion;
    String email;
    int edad;
    int telefono;

    public Alumno() {
    }

    public Alumno(String id, String nombresApellidos, String carrera, String direccion, String email, int edad, int telefono) {
        this.id = id;
        this.nombresApellidos = nombresApellidos;
        this.carrera = carrera;
        this.direccion = direccion;
        this.email = email;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombresApellidos=" + nombresApellidos + ", carrera=" + carrera + ", direccion=" + direccion + ", email=" + email + ", edad=" + edad + ", telefono=" + telefono + '}';
    }
    
    
    
    

}

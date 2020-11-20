
package misrc13112020;

import java.util.List;

public interface Operaciones {
    
    List<Alumno> obtenerTodosLosAlumnos();
    
    Alumno buscarAlumnoPorId(int id);

    List<Alumno> buscarAlumnoPorApellido(String apellido);

    Alumno obtenerUltimoAlumno();
    
    int crearAlumno(Alumno alumno);
    
    int actualizarAlumno(int id, Alumno alumno);

    int borrarAlumno(int id);
    
    boolean existeTablaAlumno();
    
    boolean borrarTablaAlumno();

    List<String> obtenerTodasTablasBaseDatos();
    
    List<String> obtenerTodasBaseDatos();
    
    List<String> obtenerTodasColumnasTablaAlumno();

    List<String> obtenerTodasTablasDadoBaseDatos(String database);

    List<String> obtenerTodasColumnasDadoTabla(String tabla);

    public String tablaMysqlToJson(String database, String table);
    
    public String tablaMysqlToXml(String database, String table);
    
    public String tablaMysqlToJsonMedico(String database, String table);

}

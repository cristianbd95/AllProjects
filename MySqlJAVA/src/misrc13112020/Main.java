package misrc13112020;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Conexion c = new Conexion(true);
        Connection conexion = c.getConexion();
        OperacionesCrud oc = new OperacionesCrud(conexion);
        System.out.println("========OBTENER TODOS LOS ALUMNOS==========");
        if (conexion != null) {
            List<Alumno> alumnos_al = oc.obtenerTodosLosAlumnos();
            if(alumnos_al !=null){
                for(int i = 0; i<alumnos_al.size();i++){
                    Alumno alumno = alumnos_al.get(i);
                    System.out.println(alumno);
                }
            }else{
                System.out.println("Error Lectura Alumno");
            }
            
            
            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        System.out.println("========BUSCAR ALUMNO POR APELLIDO==========");
        if (conexion != null) {
            List<Alumno> alumnos_al = oc.buscarAlumnoPorApellido("Perez");
            if(alumnos_al !=null){
                for(int i = 0; i<alumnos_al.size();i++){
                    Alumno alumno = alumnos_al.get(i);
                    System.out.println(alumno);
                }
            }else{
                System.out.println("Error Lectura Alumno");
            }
            
            
            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        System.out.println("==========BUSCAR ALUMNO POR ID=======");
        if (conexion != null) {
            
            Alumno alumno = new Alumno();
            alumno = oc.buscarAlumnoPorId(4);
            System.out.println(alumno);
            
            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        System.out.println("=======OBTENER ULTIMO ALUMNO===========");
        
        if (conexion != null) {
            
            Alumno alumno = new Alumno();
            alumno = oc.obtenerUltimoAlumno();
            System.out.println(alumno);
            
            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        System.out.println("=====CREAR ALUMNO=========");
        if (conexion != null) {
            Alumno alumno = new Alumno(8,"pedro","martinez","daw",new Date(2020-10-15));
            oc.crearAlumno(alumno);

            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        
        System.out.println("======ACTUALIZAR ALUMNO=========");
        if (conexion != null) {
            Alumno alumno = new Alumno(8,"pepe","rodriguez","dam",new Date(2020-10-15));
            oc.actualizarAlumno(8,alumno);

            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        
        System.out.println("=======BORRAR ALUMNO========");
        if (conexion != null) {
            oc.borrarAlumno(23);

            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        
        System.out.println("=======COMPROBAR SI EXISTE TABLA ALUMNO=========");
        if (conexion != null) {
            oc.existeTablaAlumno();

            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        System.out.println("=========BORRAR ALUMNO========");
        if (conexion != null) {
            //oc.borrarTablaAlumno();

            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        
        System.out.println("===TODAS LAS TABLAS BASE DATOS========");
        if (conexion != null) {
            List<String> tablas_al = oc.obtenerTodasTablasBaseDatos();
            if(tablas_al !=null){
                for(int i = 0; i<tablas_al.size();i++){
                    String tabla = tablas_al.get(i);
                    System.out.println(tabla);
                }
            }else{
                System.out.println("Error Lectura Alumno");
            }
            
            
            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        
        System.out.println("=======TODAS LAS BD==========");
        if (conexion != null) {
            List<String> bd_al = oc.obtenerTodasBaseDatos();
            if(bd_al !=null){
                for(int i=0; i<bd_al.size(); i++){
                    String bd = bd_al.get(i);
                    System.out.println(bd);
                }
                
            }else{
                System.out.println("Error Lectura Alumno");
            }
            
            
            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        
        System.out.println("======TODAS LAS COLUMNAS DE TABLA ALUMNO========");
        if (conexion != null) {
            List<String> col_al = oc.obtenerTodasColumnasTablaAlumno();
            if(col_al !=null){
                for(int i=0; i<col_al.size(); i++){
                    String col = col_al.get(i);
                    System.out.println(col);
                }
                
            }else{
                System.out.println("Error Lectura Alumno");
            }
            
            
            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        
        System.out.println("=======TODAS LAS TABLAS DADA BD========");
        if (conexion != null) {
            List<String> col_al = oc.obtenerTodasTablasDadoBaseDatos("BD0001");
            if(col_al !=null){
                for(int i=0; i<col_al.size(); i++){
                    String col = col_al.get(i);
                    System.out.println(col);
                }
                
            }else{
                System.out.println("Error Lectura Alumno");
            }
            
            
            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        
        System.out.println("=====TODAS LAS COLUMNAS=======");
        if (conexion != null) {
            List<String> col_al = oc.obtenerTodasColumnasDadoTabla("alumno");
            if(col_al !=null){
                for(int i=0; i<col_al.size(); i++){
                    String col = col_al.get(i);
                    System.out.println(col);
                }
                
            }else{
                System.out.println("Error Lectura Alumno");
            }
            
            
            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        
        System.out.println("========CONVERTIR A JSON========");
        if (conexion != null) {
            oc.tablaMysqlToJson("BD0001", "alumno");

            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        
        System.out.println("=======CONVERTIR A XML=======");
        if (conexion != null) {
            oc.tablaMysqlToXml("BD0001", "alumno");

            System.out.println("CONEXION CORRECTA");
        } else {
            System.out.println("ERROR CONEXION");
        }
        
    }
    
}
    
    
    
    



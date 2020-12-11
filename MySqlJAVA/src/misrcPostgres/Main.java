package misrcPostgres;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Conexion c = null;
        Connection conexion = null;
        OperacionesCrud ocrud = new OperacionesCrud();
        
        String database = "C:\\universidad\\mydatabase.universidad";

        

        System.out.println("Ingrese nombre del gestor de BBDD");
        String gestorbd = Entrada.readStr();

        switch (gestorbd) {
            case "Mysql":
                c = new ConexionMysql(true);
                break;
            case "Postgresql":
                c = new ConexionPostgresql(true);
                break;
            case "Sqlite3":
                c = new ConexionSqlite(database);
                break;
        }
        c.setConexion(true);
        conexion = c.getConexion();

        if (conexion != null) {
            if (ocrud.existeTabla(conexion) == false) {
                if (ocrud.crearTabla(conexion)) {
                    System.out.println("OK TABLA CREADA");
                } else {
                    System.out.println("Error CREAR TABLA");
                }

            } else {
                System.out.println("Error la tabla existe");
            }

        } else {
            System.out.println("ERROR DE CONEXION");
        }

        if (conexion != null) {
            List<Alumno> alumno_al = ocrud.mostrarAlumno(conexion);
            if (alumno_al != null) {
                for (int i = 0; i < alumno_al.size(); i++) {
                    Alumno alumno = alumno_al.get(i);
                    System.out.println(alumno);
                }
                System.out.println("LECTURA CORRECTA");
            } else {
                System.out.println("ERROR LECTURA");
            }

        } else {
            System.out.println("ERROR DE CONEXION");
        }

        /*if (conexion != null) {
            Alumno alumno = new Alumno("2", "Pepon Nieto", "Filosofía", "calle crud", "pepon@gmail.com", 28, 601113333);
            if (ocrud.crearAlumno(alumno, conexion)) {
                System.out.println("ALUMNO CREADO CORRECTAMENTE");
            }
        } else {
            System.out.println("ERROR DE CONEXION");
        }*/
        
        if (conexion != null) {
            Alumno alumno = new Alumno("2", "Pepon Fernandez", "Filosofía", "calle crud", "pepon@gmail.com", 28, 601113333);
            if (ocrud.actualizarAlumno(2 ,alumno, conexion)) {
                System.out.println("ALUMNO ACTUALZIADO CORRECTAMENTE");
            }else{
                System.out.println("ERROR UPDATE");
            }
        } else {
            System.out.println("ERROR DE CONEXION");
        }
        
        /*if (conexion != null) {
            if (ocrud.borrarAlumno(2, conexion)) {
                System.out.println("ALUMNO ELIMINADO CORRECTAMENTE");
            }else{
                System.out.println("ERROR DELETE");
            }
        } else {
            System.out.println("ERROR DE CONEXION");
        }*/
        
    }

}


package bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;

public class Main {
    
    private static MongoClient cliente = new MongoClient("localhost", 27017);
    private static MongoDatabase conexion = cliente.getDatabase("universidad");
    private static MongoCollection coleccion = conexion.getCollection("Alumno");
    
    public static void main(String[] args) {
        //eliminarTodosDocumentosColeccion();
        //insertarUnDocumento();
        actualizarUnDocumento();
        mostrarTodosDocumentos1();
        //insertarMuchosDocumentos();
        //buscarUnDocumento();
        
           
        
    }
    
    public static void insertarUnDocumento(){
        Alumno alumno = new Alumno(1, "luis", 1.87);
        Document documento = new Document("idAlumno", alumno.getIdAlumno())
                .append("nombre", alumno.getNombre())
                .append("estatura", alumno.getEstatura())
                .append("edad", 20);
        coleccion.insertOne(documento);
    }
    
    public static void mostrarTodosDocumentos1(){
        FindIterable<Document> iterable = coleccion.find();
        for (Document document : iterable){
            //int idAlumno = document.getInteger("idAlumno");
            //String nombre = document.getString("nombre");
            //double estatura = document.getDouble("estatura");
            //int edad = document.getInteger("edad");
            System.out.println(document);
            //System.out.println(idAlumno + "\t" + nombre + "\t" + estatura);
        }
    }
    public static void eliminarTodosDocumentosColeccion(){
        MongoCollection<Document> coleccion = conexion.getCollection("Alumno");
        coleccion.drop();
    }
    
    public static void insertarMuchosDocumentos(){
        MongoCollection<Document> coleccion = conexion.getCollection("Alumno");
        ArrayList<String> hobbies1_al = new ArrayList<String>();
        
        hobbies1_al.add("musica");
        hobbies1_al.add("cine");
        
        Document documento1 = new Document("idAlumno", 1).append("nombre", "Luis")
                .append("hobbies_al", hobbies1_al)
                .append("localidad", new Document("ciudad","Madrid"))
                .append("zip", 11111);
        
        ArrayList<String> hobbies2_al = new ArrayList<String>();
        
        hobbies2_al.add("bailar");
        hobbies2_al.add("caminar");
        
        Document documento2 = new Document("idAlumno", 2)
                .append("nombre", "Carlos")
                .append("hobbies_al", hobbies2_al)
                .append("localidad", new Document("ciudad","Madrid"))
                .append("zip",22222);
        
        coleccion.insertOne(documento1);
        coleccion.insertOne(documento2);
        
    }
    
    public static void buscarUnDocumento(){
        String clave = "nombre";
        String valor = "Luis";
        MongoCollection<Document> coleccion = conexion.getCollection("Alumno");
        Document buscarDocumento = new Document(clave, valor);
        FindIterable<Document> iterable = coleccion.find(buscarDocumento);
        String resultadoDocumento = iterable.first().toJson();
        System.out.println(resultadoDocumento);
    }
    
    public static void actualizarUnDocumento(){
        String clave = "nombre", valor = "Luis";
        String nuevoNombre = "Jacinto";
        MongoCollection<Document> coleccion = conexion.getCollection("Alumno");
        Document buscarDocumento = new Document(clave, valor);
        Document actualizarDocumento = new Document("$set", new Document("nombre", nuevoNombre));
        coleccion.findOneAndUpdate(buscarDocumento, actualizarDocumento);
    }
    
}

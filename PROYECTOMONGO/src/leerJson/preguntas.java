package leerJson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class preguntas {

    private static MongoClient cliente = new MongoClient("localhost", 27017);
    private static MongoDatabase conexion = cliente.getDatabase("asignaturadb");
    private static MongoCollection coleccion = conexion.getCollection("pregunta");

    private static String nombreArchivo = "pregunta.txt";
    private static String rutaArchivo = "src/leerJson/";

    public static void main(String[] args) {
        //mostrarTodoContenidoArhivoTextoPregunta();
        //mostrarListaPreguntas();
        //insertarDocumentosColeccionPregunta();
        //mostrarTodosDocumentosColeccionPreguntas();
        recuperarOpcionesListaPreguntas();
    }

    public static List<Pregunta> retornarListaPreguntas() {
        File f1 = new File(rutaArchivo + nombreArchivo);
        String rutaAbsolutaArchivo = f1.getAbsolutePath();
        System.out.println("Ruta del archivo : " + rutaAbsolutaArchivo);

        String registro;

        int idPregunta;
        String enunciado;
        char respuesta;
        String[] parte;
        List<Pregunta> preguntas_al = new ArrayList<Pregunta>();

        File f;
        FileReader fr = null;
        BufferedReader br;

        try {
            f = new File(rutaAbsolutaArchivo);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while ((registro = br.readLine()) != null) {
                List<String> opciones_al = new ArrayList<String>();
                parte = registro.split("\\.");
                idPregunta = Integer.parseInt(parte[0].trim());
                enunciado = parte[1].trim();
                List<String> opcionesrespuesta_al = new ArrayList<String>();
                while (!(registro = br.readLine()).equals("<<FIN>>")) {
                    opcionesrespuesta_al.add(registro);
                }
                int i;
                for (i = 0; i < opcionesrespuesta_al.size() - 1; i++) {
                    opciones_al.add(opcionesrespuesta_al.get(i));
                }
                respuesta = opcionesrespuesta_al.get(i).charAt(0);
                Pregunta pregunta = new Pregunta(idPregunta, enunciado, opciones_al, respuesta);
                preguntas_al.add(pregunta);
            }
            return preguntas_al;
        } catch (IOException e) {
            return null;
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e) {
                return null;
            }
        }
    }

    public static void insertarDocumentosColeccionPregunta() {
        List<Pregunta> preguntas_al = retornarListaPreguntas();
        for (int i = 0; i < preguntas_al.size(); i++) {
            Pregunta pregunta = preguntas_al.get(i);
            Document documento = new Document("idPregunta", pregunta.getIdPregunta())
                    .append("enunciado", pregunta.getEnunciado())
                    .append("opciones_al", pregunta.getOpciones())
                    .append("respuesta", pregunta.getRespuesta());
            coleccion.insertOne(documento);
        }

    }

    public static void mostrarListaPreguntas() {
        List<Pregunta> preguntas_al = retornarListaPreguntas();
        if (preguntas_al != null) {
            for (int i = 0; i < preguntas_al.size(); i++) {
                System.out.println(preguntas_al.get(i));
            }
        }
    }

    public static void mostrarTodosDocumentosColeccionPreguntas() {
        MongoCursor<Document> cursor = coleccion.find().iterator();
        ArrayList valores1_al;
        ArrayList valores2_al;
        while (cursor.hasNext()) {
            Document otro = cursor.next();
            System.out.println(otro.toJson());
        }
    }

    public static void pause() {
        try {
            System.out.print("\nPresiona una tecla para continuar...");
            System.in.read();
        } catch (IOException e) {
        }
    }

    public static void recuperarOpcionesListaPreguntas() {
        MongoCursor<Document> cursor = coleccion.find().iterator();
        ArrayList valores1_al;
        ArrayList valores2_al;
        while (cursor.hasNext()) {
            Document otro = cursor.next();
            valores1_al = new ArrayList<>(otro.values());
           // System.out.println(otro.toJson());
            List lista = (List) valores1_al.get(3);
            System.out.println("tamaño" + lista.size());
            valores2_al = new ArrayList<>(lista);
            for (int i = 0; i < valores2_al.size(); i++) {
                System.out.println(valores2_al.get(i));
                pause();
            }
        }
    }
}


package leerJson;

import java.util.List;


public class Pregunta {
    private int idPregunta;
    private String enunciado;
    private List<String> opciones;
    private char respuesta;

    public Pregunta() {
    }

    public Pregunta(int idPregunta, String enunciado, List<String> opciones, char respuesta) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuesta = respuesta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public char getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(char respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "idPregunta=" + idPregunta + ", enunciado=" + enunciado + ", opciones=" + opciones + ", respuesta=" + respuesta + '}';
    }

   
   
    
    
}

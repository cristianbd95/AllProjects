/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerJson;

import java.util.List;

/**
 *
 * @author Campus FP
 */
public class PreguntaString {
    private int idPregunta;
    private String enunciado;
    private List<String> opciones;
    private String respuesta;

    public PreguntaString() {
    }

    public PreguntaString(int idPregunta, String enunciado, List<String> opciones, String respuesta) {
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

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "PreguntaString{" + "idPregunta=" + idPregunta + ", enunciado=" + enunciado + ", opciones=" + opciones + ", respuesta=" + respuesta + '}';
    }
    
    
}

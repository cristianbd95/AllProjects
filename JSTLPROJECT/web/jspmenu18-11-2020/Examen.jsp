<%-- 
    Document   : Examen
    Created on : 11-dic-2020, 9:48:59
    Author     : Campus FP
--%>

<%@page import="srcjstl.Medicos"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="misrcMenu.Medico"%>
<%@page import="misrcMenu.OperacionesCrud"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="misrcMenu.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Conexion c = new Conexion(true);
    Connection conexion = c.getConexion();
    OperacionesCrud oc = new OperacionesCrud(conexion);

    List<Medico> medicos_al = oc.obtenerTodosLosMedicos();
    Set<String> cadenas_hs = new HashSet(); // hashset medicos
    Set<String> years_hs = new HashSet();// hashset años
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    String[] parte;

    Date fechaDate = null;
    Calendar calendar = Calendar.getInstance();
    List<Date> years_al = new ArrayList<Date>();

    for (int i = 0; i < medicos_al.size(); i++) {
        Medico medico = (Medico) medicos_al.get(i);
        //fechaDate = formato.parse(medico.getFecha().trim());
        cadenas_hs.add(medico.getNombre());
        parte = medico.getFecha().split("-");
        years_hs.add(parte[0].trim());
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Examen.jsp" method="post">
            <select name="cboMedicos"> 
                <option value="no">SELECCIONE UN MEDICO </option>
                <%            List<String> cadenas_al = new ArrayList<String>(cadenas_hs);

                    //for (String cadena : cadenas_hs) {
                    //cadenas_al.add(cadena);
                    //}
                    Collections.sort(cadenas_al);
                    for (int i = 0; i < cadenas_al.size(); i++) {

                %>

                <option value="<%= i%>"> <%= cadenas_al.get(i)%> </option>

                <%
                    }
                %> 
            </select>
            <select name="cboAno">
                <option value="no">SELECCIONE UN AÑO </option>

                <%
                    List<String> fechaYear_al = new ArrayList<String>(years_hs);
                    for (int i = 0; i < fechaYear_al.size(); i++) {
                %>

                <option value="<%=fechaYear_al.get(i)%>"> <%= fechaYear_al.get(i)%> </option>

                <%
                    }
                %>
            </select>
            <select name="cboMes">
                <option value="no">SELECCIONE UN MES </option>
                <option value="01">ENERO</option>
                <option value="02">FEBRERO</option>
                <option value="03">MARZO</option>
                <option value="04">ABRIL</option>
                <option value="05">MAYO</option>
                <option value="06">JUNIO</option>
                <option value="07">JULIO</option>
                <option value="08">AGOSTO</option>
                <option value="09">SEPTIEMBRE</option>
                <option value="10">OCTUBRE</option>
                <option value="11">NOVIEMBRE</option>
                <option value="12">DICIEMBRE</option>

            </select>
            <input type="submit" name="btoEnviar" value="Enviar">
            <input type="submit" name="btoLimpiar" value="Limpiar">
        </form>

        <%

            if (request.getParameter("btoEnviar") != null) {
                String recuperarAno = request.getParameter("cboAno");
                String indiceMedicos = request.getParameter("cboMedicos");
                String recuperarMeses = request.getParameter("cboMes");
                int[] meses = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                String[] partes;

                /*if (recuperarAno.equals("no") || indiceMedicos.equals("no") || recuperarMeses.equals("no")) {
                    out.println("DEBE SELECCIONAR COMBOBOX");
                }*/
                int contC = 0;
                int contI = 0;
                int contL = 0;
                int total = 0;
                List<String> medicosCont_al = new ArrayList<String>();
                List<Medicos> medicosX_al = new ArrayList<Medicos>();

                for (int j = 0; j < 1; j++) {

                    for (int i = 0; i < medicos_al.size(); i++) {
                        Medico medico = (Medico) medicos_al.get(i);
                        partes = medico.getFecha().split("-");
                        if (cadenas_al.get(j).equals(medico.getNombre()) && medico.getDeinpr().equals("CESAREA") && recuperarMeses.equals(partes[1]) && recuperarAno.equals(partes[0])) {
                            contC = contC + 1;

                        }
                        if (cadenas_al.get(j).equals(medico.getNombre()) && medico.getDeinpr().equals("INDUCCION") && recuperarMeses.equals(partes[1]) && recuperarAno.equals(partes[0])) {
                            contI = contI + 1;
                        }
                        if (cadenas_al.get(j).equals(medico.getNombre()) && medico.getDeinpr().equals("LEGRADO") && recuperarMeses.equals(partes[1]) && recuperarAno.equals(partes[0])) {
                            contL = contL + 1;

                        }

                    }
                    if (recuperarAno.equals("no") || indiceMedicos.equals("no") || recuperarMeses.equals("no")) {
                        out.println("SELECCIONE COMBOBOX");
                    } else {
                        if (request.getParameter("btoEnviar") != null) {
                            total = contL + contC + contI; // TOTAL OPERACIONES
                            out.println("<table border='1'>");
                            out.println("<tr>");
                            out.println("<th>INDUCCIONES</th>");
                            out.println("<th> CESAREA</th>");
                            out.println("<th> LEGRADO</th>");
                            out.println("<th> TOTAL</th>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<td>" + contC + "</td>");
                            out.println("<td>" + contL + "</td>");
                            out.println("<td>" + contI + "</td>");
                            out.println("<td>" + total + "</td>");
                            out.println("</tr>");
                            out.println("</table>");

                        }

                    }
                }

            }


        %>
    </body>
</html>

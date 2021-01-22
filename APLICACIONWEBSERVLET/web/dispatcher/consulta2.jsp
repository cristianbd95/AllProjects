<%-- 
    Document   : cliente
    Created on : 22-ene-2021, 10:34:21
    Author     : Campus FP
--%>

<%@page import="factoria2.Consulta2"%>
<%@page import="java.util.ArrayList"%>
<%@page import="factoria2.Consulta1"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <br><center>
        <p>Estas logeado como <strong style="color:red">${logeado}</strong></p> <br><br>

        Listar cada uno de  los vendedores y la ciudad y region en donde trabajan.<br>
        <form action="http://localhost:8080/SERVLET/Consultas" method="post"><br>
            <input type="submit" name="btoEnviar" value="Enviar consulta">
        </form>
    </center>
    <br><br><br>
    <%
        HttpSession misession = request.getSession(true);
        String logeado = (String) misession.getAttribute("logeado");
        if (request.getParameter("btoEnviar") != null) {
            List<Consulta2> consultas_al = (ArrayList<Consulta2>) request.getAttribute("EnvioDatos");
            if (consultas_al != null) {
                out.println("<center><table style='border: 2px solid black'>");
                out.println("<tr>");
                out.println("<th>ID PEDIDO </th>");
                out.println("<th>IMPORTE </th>");
                out.println("<th>NOMBRE </th>");
                out.println("<th>EMPRESA </th>");
                out.println("</tr>");
                for (int i = 0; i < consultas_al.size(); i++) {
                    Consulta2 consulta = consultas_al.get(i);
                    out.println("<tr>");
                    out.println("<td>" + consulta.getIdPedido() + "</td>");
                    out.println("<td>" + consulta.getImporte() + "</td>");
                    out.println("<td>" + consulta.getNombre() + "</td>");
                    out.println("<td>" + consulta.getEmpresa() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table></center>");
            } else {
                out.println("ARRAY NULL");
            }
        }
    %>
</body>
</html>
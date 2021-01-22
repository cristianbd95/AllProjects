<%-- 
    Document   : producto
    Created on : 22-ene-2021, 10:34:10
    Author     : Campus FP
--%>

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
            <input type="submit" name="btoEnviar" value="Enviar">
        </form>
    </center>
    <br><br><br>
    <%
        HttpSession misession = request.getSession(true);
        String logeado = (String) misession.getAttribute("logeado");
        if (request.getParameter("btoEnviar") != null) {
            List<Consulta1> consultas_al = (ArrayList<Consulta1>) request.getAttribute("EnvioDatos");
            if (consultas_al != null) {
                out.println("<center><table style='border: 2px solid black'>");
                out.println("<tr>");
                out.println("<th>ID VENDEDOR </th>");
                out.println("<th>CIUDAD </th>");
                out.println("<th>VENDEDOR </th>");
                out.println("<th>REGION </th>");
                out.println("</tr>");
                for (int i = 0; i < consultas_al.size(); i++) {
                    Consulta1 consulta = consultas_al.get(i);
                    out.println("<tr>");
                    out.println("<td>" + consulta.getIdVendedor() + "</td>");
                    out.println("<td>" + consulta.getVendedor() + "</td>");
                    out.println("<td>" + consulta.getCiudad() + "</td>");
                    out.println("<td>" + consulta.getRegion() + "</td>");
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

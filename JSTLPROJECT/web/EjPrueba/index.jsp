
<%@page import="java.util.List"%>
<%@page import="ejprueba.OperacionesCrud"%>
<%@page import="java.sql.Connection"%>
<%@page import="misrcAficionado.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Conexion c = new Conexion(true);
    Connection conexion = c.getConexion();
    OperacionesCrud oc = new OperacionesCrud();

    List<String> bd_al = oc.obtenerTodasBaseDatos(conexion);
    

    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="index.jsp" method="post">
            <select id="databases">
                <%  
                    for(int i=0; i<bd_al.size();i++){
                        String tabla = bd_al.get(i);
                    
                        out.println(tabla);
                %>
                <option id="<%=i%>" value="<%=bd_al.get(i) %>"><%=bd_al.get(i) %> </option>
                <% }
                %>
            </select>
            <input type="submit" value="ENVIAR">
        </form>
        
        
    </body>
</html>

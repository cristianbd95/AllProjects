
<%@page import="misrcPolimorfismo.Metodos"%>
<%@page import="misrcPolimorfismo.FiguraGeometrica2D"%>
<%@page import="misrcPolimorfismo.Triangulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    FiguraGeometrica2D figura2d;
    Metodos m = new Metodos();
    
    String base = request.getParameter("base");
    String altura = request.getParameter("altura");
    out.println(base + " / " +  altura);
    
    figura2d = new Triangulo(Double.parseDouble(base.trim()), Double.parseDouble(altura.trim()));
    m.imprimir(figura2d);
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


    </body>
</html>


<%@page import="misrcPolimorfismo.Metodos"%>
<%@page import="misrcPolimorfismo.FiguraGeometrica2D"%>
<%@page import="misrcPolimorfismo.Circulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    FiguraGeometrica2D figura2d;
    Metodos m = new Metodos();

    String radio = request.getParameter("radio");
    figura2d = new Circulo(Double.parseDouble(radio));
    out.println(radio);
    m.imprimir(figura2d);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <FORM ACTION=circulo.jsp METHOD=post>
            <input type="text" name="radio" placeholder="radio">
            <input type="submit" name="bEnviar" value="Enviar D">
        </FORM>
    </body>
</html>

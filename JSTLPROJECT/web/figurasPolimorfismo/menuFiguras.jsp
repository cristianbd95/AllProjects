
<%@page import="misrcPolimorfismo.Metodos"%>
<%@page import="misrcPolimorfismo.Circulo"%>
<%@page import="misrcPolimorfismo.Triangulo"%>
<%@page import="misrcPolimorfismo.FiguraGeometrica2D"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  
    
    String figura = request.getParameter("figura");

    
    if(request.getParameter("btoEnviar") != null && figura.equals("1")){
        
        if(figura.equals("1")){
            %>
            <FORM ACTION=triangulo.jsp METHOD=post>
            <input type="text" name="base" placeholder="introduzca base">
            <input type="text" name="altura" placeholder="introduzca altura">
            <input type="submit" name="enviaTriangulo" value="Enviar Datos">
            </FORM>
            <%

        }
        if(figura.equals("2")){
            %>
            <FORM ACTION=circulo.jsp METHOD=post>
            <input type="text" name="radio" placeholder="radio">
            <input type="submit" name="enviaCirculo" value="Enviar Datos">
            </FORM>
            <%
        }
    
    }

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <TABLE ALIGN=center BORDER=0 WIDTH='100%' HEIGHT='100%'>
            <TR ALIGN=center><TD ALIGN=center>
                    <FORM ACTION=menuFiguras.jsp METHOD=post>
                        <TABLE BORDER=0 ALIGN=center BGCOLOR=#bbbbbb CELLPADDING=5 CELLSPACING=0>
                            <TR><TD COLSPAN=3><CENTER><H2>ELIGE FIGURA</H2></CENTER></TD></TR>
                            <TR><TD COLSPAN=3><CENTER><input type="checkbox" name="figura" value="1">Triangulo</CENTER></TD></TR>
                            <TR><TD COLSPAN=3><CENTER><input type="checkbox" name="figura" value="2">Circulo</CENTER></TD></TR>
                            <TR><TD ALIGN=center><INPUT TYPE="SUBMIT" NAME="btoEnviar" VALUE="Enviar"></TD>
                        </TABLE>
                    </FORM>
            </TR>
        </TABLE>



    </body>
</html>

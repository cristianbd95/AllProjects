<%-- 
    Document   : leercsv
    Created on : 26-feb-2021, 11:03:54
    Author     : Campus FP
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    if (request.getParameter("enviar") != null) {
        try {
            csw.Calculadora_Service service = new csw.Calculadora_Service();
            csw.Calculadora port = service.getCalculadoraPort();
            // TODO process result here
            List<csw.Transaccion> result_al = port.operation();
            if (result_al != null) {
                for (int i = 0; i < result_al.size(); i++) {
                    csw.Transaccion transaccion = result_al.get(i);
                    out.println(transaccion.getVendedor()+"<br>");
                }
            } else {
                out.println("Nulo");
            }
        } catch (Exception ex) {
            out.println("ERROR");
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
        <form action="leercsv.jsp" method="post">
            <input type="submit" value="enviar" name="enviar">
        </form>
    </body>
</html>



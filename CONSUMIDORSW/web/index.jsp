<%-- 
    Document   : index
    Created on : 26-feb-2021, 9:58:33
    Author     : Campus FP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String n1 = "";
    String n2 = "";
    String r = "";
    String m = "";

    if (request.getParameter("btoEnviar") != null) {
        out.println("llego");
        try {
            csw.Calculadora_Service service = new csw.Calculadora_Service();
            csw.Calculadora port = service.getCalculadoraPort();
            n1 = request.getParameter("txtN1");
            n2 = request.getParameter("txtN2");
            int operacion = Integer.parseInt(request.getParameter("cboOperacion"));
            out.println(operacion);
            double resultado = port.calculadora(Double.parseDouble(n1), Double.parseDouble(n2), operacion);
            r = String.valueOf(resultado);
            m="correcto";
        } catch (Exception e) {
            m = "Datos incorrectos";
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
        <h1>CALCULADORA</h1>
        <form action="index.jsp" method="POST">
            numero1?        <input type="text" name="txtN1" value="<%=n1%>" size="5" />
            numero2?        <input type="text" name="txtN2" value="<%=n2%>" size="5" />
            Resultado =     <input type="text" name="txtR" value="<%=r%>" size="5" readonly="readonly" />
            Mensaje =       <input type="text" name="txtM" value="<%=m%>" size="15" />
            Operación?      <select name="cboOperacion">
                <option value="1">suma</option>
                <option value="2">resta</option>
                <option value="3">multiplicacion</option>
                <option value="4">division</option>
            </select>
            <input type="submit" value="Enviar" name="btoEnviar" />
            <input type="reset" value="Nuevo" name="btoReset" />
        </form>
    </body>
</html>

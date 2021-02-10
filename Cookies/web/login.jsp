<%-- 
    Document   : login
    Created on : 05-feb-2021, 10:07:07
    Author     : Campus FP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="http://localhost:8080/Cookies/ServletCookies" method="post">
    <%
        String valor = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("plogin")) {
                    valor = c.getValue();
                } else {
                    valor = "no encontrado";
                }
            }
        } else {
            out.println("COOKIE NO CARGADA");
        }

    %>

    Login:<input type="text" name="txtLogin" size="10" value="<%= valor%>" />
    Password:<input type="text" name="txtPassword" size="10" value="" />
    <input type="checkbox" checked="checked" name="chkRecordar">Recordar mis datos</input>
    <input type="submit" name="btoEnviar" value="Iniciar">
</form>


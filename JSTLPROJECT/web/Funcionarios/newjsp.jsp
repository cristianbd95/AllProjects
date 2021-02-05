

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="newjsp.jsp">
            <input type="text" name="txtUsuario" placeholder="Introduce Usuario">
            <input type="password" name="pwdPassword" placeholder="Introduce Contraseña">
            <input type="submit" name="btoEnviar" value="Enviar">
        </form>
    </body>
</html>
<%
    if (request.getParameter("btoEnviar") != null) {
        String sUsuario = request.getParameter("txtUsuario");
        String sPassword = request.getParameter("pwdPassword");

        session.setAttribute("usuario_s", sUsuario);
        session.setAttribute("password_s", sPassword);
        String redirectURL = "comprobar.jsp";
        response.sendRedirect(redirectURL);
    }
%>
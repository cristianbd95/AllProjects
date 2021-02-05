<%-- 
    Document   : insertar
    Created on : 13-dic-2020, 16:41:36
    Author     : kk
--%>

<%@page import="java.util.List"%>
<%@page import="misrcFuncionario.OperacionesCrud"%>
<%@page import="java.sql.Connection"%>
<%@page import="misrcFuncionario.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Conexion c = new Conexion(true);
    Connection conexion = c.getConexion();
    OperacionesCrud oc = new OperacionesCrud();

    if (request.getParameter("btoEnviar") != null) {
        String sId = request.getParameter("txtId");
        String sNombre = request.getParameter("funcionarios");
        String sPassword = request.getParameter("numPassword");
        if(oc.crearUsuario(sId, sNombre, Integer.parseInt(sPassword), conexion)){
            out.println("USUARIO CREADO CORRECTAMENTE");
        }else{
            out.println("ERROR CREAR USUARI");
        }
    }

    if (request.getParameter("btoMostrar") != null) {
        List<String> funcionarios_al = oc.mostrarFuncionarios(conexion);
        int cont1 = 0;
        int cont2 = 3;
%>  <center><fieldset style="width: 200px"><%
        if (funcionarios_al != null) {
            out.println("<center><table border='1' style='margin-top: 50px'>");
                out.println("<tr>");
                out.println("<th>ID</th>");
                out.println("<th>USUARIO</th>");
                out.println("<th>CONTRASEÑA</th>");
                out.println("</tr>");
            for (int i = 0; i < funcionarios_al.size() / 3; i++) {
                out.println("<tr>");
                for (int j = cont1; j < cont2; j++) {
                    cont1=cont1+1;
                    String funcionario = funcionarios_al.get(j);
                    out.println("<td>" + funcionario + "</td>");
                }
                out.println("</tr>");
                cont2 = cont2+3;
            }
            out.println("</table></center>");
            %>
            <form action="comprobar.jsp" method="post">
                <br>
                <input type="submit" value="VOLVER">
            </form>
            <form action="newjsp.jsp" method="post">
                <input type="submit" value="DESCONECTARSE">
            </form>
    </fieldset></center>
            <%
        } else {
            out.println("LECTURA ERRONEA");
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

    </body>
</html>

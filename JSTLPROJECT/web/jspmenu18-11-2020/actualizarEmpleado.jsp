<%-- 
    Document   : actualizarEmpleado
    Created on : 19-nov-2020, 18:47:37
    Author     : kk
--%>

<%@page import="java.util.List"%>
<%@page import="misrcMenu.Empleado"%>
<%@page import="misrcMenu.OperacionesCrud"%>
<%@page import="java.sql.Connection"%>
<%@page import="misrcMenu.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<table border="1">
    <tr>
        <td>id</td>
        <td>nombre</td>
        <td>salario</td>
    </tr>
    <%
        if (request.getParameter("bto_actualizar") != null) {
            Conexion c = new Conexion(true);
            Connection conexion = c.getConexion();

            OperacionesCrud oc = new OperacionesCrud(conexion);
            String sId = request.getParameter("numId");
            String sNombre = request.getParameter("txtNombre");
            String sSalario = request.getParameter("txtSalario");

            if (conexion != null) {
                Empleado empleado = new Empleado(Integer.parseInt(sId.trim()), sNombre.trim(), Float.parseFloat(sSalario.trim()));
                if (oc.actualizarEmpleado(empleado)) {
                    out.println("ACTUALIZAR OK");
                } else {
                    out.println("ERROR AL REGISTRAR");
                }

            } else {
                out.println("Error conexion con BBDD");
            }

        }
        
            Conexion c = new Conexion(true);
            Connection conexion = c.getConexion();

            OperacionesCrud oc = new OperacionesCrud(conexion);

            if (conexion != null) {
                List<Empleado> empleados_al = oc.mostrarEmpleado();
                for (int i = 0; i < empleados_al.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + empleados_al.get(i).getId() + "</td>");
                    out.println("<td>" + empleados_al.get(i).getNombre() + "</td>");
                    out.println("<td>" + empleados_al.get(i).getSalario() + "</td>");
                    out.println("</tr>");
                }

            } else {
                out.println("Error conexion con BBDD");
            }

      
    %>
</table>
</body>
</html>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <CENTER>
        <TABLE ALIGN=center BORDER=0 WIDTH='100%' HEIGHT='100%'>
            <TR ALIGN=center><TD ALIGN=center>
                    <FORM ACTION=actualizarEmpleado.jsp METHOD=post>
                        <TABLE BORDER=0 ALIGN=center BGCOLOR=#bbbbbb CELLPADDING=5 CELLSPACING=0>
                            <TR><TD COLSPAN=3><CENTER><H2>ACTUALIZAR EMPLEADO</H2></CENTER></TD></TR>
                            <TR><TD ALIGN=center><INPUT TYPE="text" NAME="numId" placeholder="Inserte ID"></TD>
                            <TR><TD ALIGN=center><INPUT TYPE="text" NAME="txtNombre" placeholder="Inserte Nombre"></TD>
                            <TR><TD ALIGN=center><INPUT TYPE="text" NAME="txtSalario" placeholder="Inserte Salario"></TD>
                            <TR><TD ALIGN=center><INPUT TYPE=SUBMIT NAME=bto_actualizar VALUE=Actualizar></TD>
                            <TR><TD ALIGN=center><INPUT TYPE=SUBMIT NAME=bto_mostrar VALUE=Mostrar></TD>

                                <TD ALIGN=center><INPUT TYPE=button NAME=bto_atras VALUE=Back onclick = "location = 'menu.jsp'"/></TD></TR> 
                        </TABLE>
                    </FORM>
            </TR>
        </TABLE>
    </CENTER>
</body>
</html>

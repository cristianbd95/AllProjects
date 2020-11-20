
<%@page import="java.util.List"%>
<%@page import="misrcMenu.Empleado"%>
<%@page import="misrcMenu.OperacionesCrud"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="misrcMenu.Conexion"%>

<table border="1">
    <tr>
        <td>ID</td>
        <td>NOMBRE</td>
        <td>SALARIO</td>
    </tr>

    <%
        if (request.getParameter("bto_buscar") != null) {
            Conexion c = new Conexion(true);
            Connection conexion = c.getConexion();
            OperacionesCrud oc = new OperacionesCrud(conexion);
            String sId = request.getParameter("numId");

            if (conexion != null) {
                List<Empleado> empleados_al = oc.buscarEmpleado(Integer.parseInt(sId));
                for(int i = 0; i<empleados_al.size();i++){
                    out.println("<tr>");
                    out.println("<td>"+ empleados_al.get(i).getId() + "</td>");
                    out.println("<td>"+ empleados_al.get(i).getNombre() +"</td>");
                    out.println("<td>"+ empleados_al.get(i).getSalario() +"</td>");
                    out.println("</tr>");
                }
            } else {
                out.println("ERROR CONEXION A LA BBDD");
            }

        }

    %>

</table>

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
                    <FORM ACTION=buscarEmpleado.jsp METHOD=post>
                        <TABLE BORDER=0 ALIGN=center BGCOLOR=#bbbbbb CELLPADDING=5 CELLSPACING=0>
                            <TR><TD COLSPAN=3><CENTER><H2>BUSCAR EMPLEADO</H2></CENTER></TD></TR>
                            <TR><TD ALIGN="center"><INPUT TYPE="text" NAME="numId" placeholder="Introduzca ID"></TD>
                            <TR><TD ALIGN="center"><INPUT TYPE="SUBMIT" NAME="bto_buscar" VALUE="Buscar Empleado"></TD>

                                <TD ALIGN=center><INPUT TYPE=button NAME=bto_atras VALUE=Back onclick = "location = 'menu.jsp'"/></TD></TR> 
                        </TABLE>
                    </FORM>
            </TR>
        </TABLE>
    </CENTER>
</body>
</html>

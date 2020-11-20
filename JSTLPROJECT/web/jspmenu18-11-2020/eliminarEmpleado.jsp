

<%@page import="misrcMenu.OperacionesCrud"%>
<%@page import="java.sql.Connection"%>
<%@page import="misrcMenu.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if(request.getParameter("bto_eliminar") != null){
        Conexion c = new Conexion(true);
        Connection conexion = c.getConexion();
        OperacionesCrud oc = new OperacionesCrud(conexion);
        String sId = request.getParameter("numId");
        
        
        if(conexion != null){
            oc.eliminarEmpleado(Integer.parseInt(sId));
            out.println("OK");
        }else{
            out.println("Error Conexion BBDD");
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
    <CENTER>
        <TABLE ALIGN=center BORDER=0 WIDTH='100%' HEIGHT='100%'>
            <TR ALIGN=center><TD ALIGN=center>
                    <FORM ACTION=eliminarEmpleado.jsp METHOD=post>
                        <TABLE BORDER=0 ALIGN=center BGCOLOR=#bbbbbb CELLPADDING=5 CELLSPACING=0>
                            <TR><TD COLSPAN=3><CENTER><H2>BUSCAR EMPLEADO</H2></CENTER></TD></TR>
                            <TR><TD ALIGN="center"><INPUT TYPE="text" NAME="numId" placeholder="Introduzca ID"></TD>
                            <TR><TD ALIGN="center"><INPUT TYPE="SUBMIT" NAME="bto_eliminar" VALUE="Eliminar Empleado"></TD>

                                <TD ALIGN=center><INPUT TYPE=button NAME=bto_atras VALUE=Back onclick = "location = 'menu.jsp'"/></TD></TR> 
                        </TABLE>
                    </FORM>
            </TR>
        </TABLE>
    </CENTER>
</body>
</html>

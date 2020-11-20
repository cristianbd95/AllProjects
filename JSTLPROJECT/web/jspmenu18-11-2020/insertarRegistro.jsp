<%-- 
    Document   : insertarRegistro
    Created on : 18-nov-2020, 10:29:30
    Author     : Campus FP
--%>

<%@page import="misrcMenu.Empleado"%>
<%@page import="misrcMenu.OperacionesCrud"%>
<%@page import="java.sql.Connection"%>
<%@page import="misrcMenu.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%
    if (request.getParameter("bto_insertar") != null) {
        Conexion c = new Conexion(true);
        Connection conexion = c.getConexion();
        
        OperacionesCrud oc = new OperacionesCrud(conexion);
        String sId = request.getParameter("numId");
        String sNombre = request.getParameter("txtNombre");
        String sSalario = request.getParameter("txtSalario");
        
        
        if(conexion != null){
            Empleado empleado = new Empleado(Integer.parseInt(sId.trim()),sNombre.trim(),Float.parseFloat(sSalario.trim()));
            if(oc.insertarEmpleado(empleado)){
                out.println("INSERT OK");
            }else{
                out.println("ERROR AL REGISTRAR");
            }
            
        }else{
            out.println("Error conexion con BBDD");
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
                    <FORM ACTION=insertarRegistro.jsp METHOD=post>
                        <TABLE BORDER=0 ALIGN=center BGCOLOR=#bbbbbb CELLPADDING=5 CELLSPACING=0>
                            <TR><TD COLSPAN=3><CENTER><H2>INSERTAR EMPLEADO</H2></CENTER></TD></TR>
                            <TR><TD ALIGN=center><INPUT TYPE="text" NAME="numId"></TD>
                            <TR><TD ALIGN=center><INPUT TYPE="text" NAME="txtNombre"></TD>
                            <TR><TD ALIGN=center><INPUT TYPE="text" NAME="txtSalario"></TD>
                            <TR><TD ALIGN=center><INPUT TYPE=SUBMIT NAME=bto_insertar VALUE=Registrar></TD>
                             
                            <TD ALIGN=center><INPUT TYPE=button NAME=bto_atras VALUE=Back onclick = "location = 'menu.jsp'"/></TD></TR> 
                        </TABLE>
                    </FORM>
            </TR>
        </TABLE>
    </CENTER>
</body>
</html>

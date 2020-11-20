

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <HTML>
        <HEAD> 
            <TITLE>Menu</TITLE>
            <STYLE>
                A {text-decoration: none;}
                A:hover {text-decoration: underline;}
            </STYLE>
        </HEAD>
        <BODY>

        <CENTER>
            <TABLE ALIGN=center BORDER=0 WIDTH='100%' HEIGHT='100%'>
                <TR ALIGN=center><TD ALIGN=center>

                <TABLE BORDER=1 ALIGN=center BGCOLOR=#bbbbbb CELLPADDING=2 CELLSPACING=0>
                <TR><TD COLSPAN=1><CENTER><H2>MENU</H2></CENTER></TD></TR>

                <TR><TD ALIGN=left><PRE><A HREF="crearTabla.jsp">(1) CREAR TABLA               </A><BR></PRE></TD></TR>
                <TR><TD ALIGN=left><PRE><A HREF="insertarRegistro.jsp">(2) REGISTRAR             </A><BR></PRE></TD></TR>
                <TR><TD ALIGN=left><PRE><A HREF="mostrarEmpleado.jsp">(3) MOSTRAR                 </A><BR></PRE></TD></TR>
                <TR><TD ALIGN=left><PRE><A HREF="buscarEmpleado.jsp">(4) BUSCAR                   </A><BR></PRE></TD></TR> 
                <TR><TD ALIGN=left><PRE><A HREF="eliminarEmpleado.jsp">(5) ELIMINAR               </A><BR></PRE></TD></TR> 
                <TR><TD ALIGN=left><PRE><A HREF="actualizarEmpleado.jsp">(6) ACTUALIZAR           </A><BR></PRE></TD></TR>      
                <TR><TD ALIGN=left><PRE><A HREF="javascript:close()">(7) SALIR               </A><BR></PRE></TD></TR>  

              </TABLE>

              </TR>
            </TABLE>
        </CENTER>

        
        
        
        
    </body>
</html>


<%@page import="java.io.File"%>
<%@page import="misrcPaginacion.Medico"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="misrcPaginacion.OpCrud"%>
<%@page import="java.sql.Connection"%>
<%@page import="misrcPaginacion.ConexionSqlite"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String basedatos = getServletContext().getRealPath("/")+"Paginacion/data/salud.db";
    
    ConexionSqlite c = new ConexionSqlite(basedatos);
    c.setConexion(true);
    Connection conexion = c.getConexion();
    OpCrud oc = new OpCrud();

    if(conexion != null){
    int idPag = Integer.parseInt(request.getParameter("page"));
    int totalConsultas = oc.totalConsultas(conexion);
    int consultasXpag = 100;
    int numeroPaginas = (int) Math.ceil(totalConsultas / (double) consultasXpag);
    if (idPag == 1) {

    } else {
        out.println("<center> <h2>PÁGINA : " + idPag + "</h2><br><br>");
        idPag = idPag - 1;
        idPag = idPag * consultasXpag - 1;
    }
    
    List<Medico> medicos_al = oc.mostrarConsultas(conexion, idPag, consultasXpag);

    
    out.println("<center><table border='1'>");
    out.println("<tr>");
    out.println("<th> ID </th>");
    out.println("<th> FECHA</th>");
    out.println("<th> NOMBRE</th>");
    out.println("<th> DEINPR</th>");
    out.println("<th> PROCEDENCIA</th>");
    out.println("</tr>");
    
    for (int i = 0; i < medicos_al.size(); i++) {
        Medico medico = medicos_al.get(i);
        out.println("<tr>");
        out.println("<th>" + medico.getNumeroConsulta() + "</th>");
        out.println("<th>" + medico.getFecha() + "</th>");
        out.println("<th>" + medico.getNombreMedico()+ "</th>");
        out.println("<th>" + medico.getDeinpr() + "</th>");
        out.println("<th>" + medico.getProcedencia() + "</th>");
        out.println("</tr>");
    }   
        out.println("</table></center>");
        
    for(int i=0; i<numeroPaginas; i++){
%> 
    <a href="vista.jsp?page=<%=i%>"><%=i%></a>
<%
    }
}else{
    out.println("Error conexion");
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

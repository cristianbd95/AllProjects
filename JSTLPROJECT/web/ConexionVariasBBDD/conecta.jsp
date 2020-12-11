
<%@page import="misrcConexionBBDD.Alumno"%>
<%@page import="java.util.List"%>
<%@page import="misrcConexionBBDD.ConexionSqlite"%>
<%@page import="misrcConexionBBDD.ConexionPostgresql"%>
<%@page import="misrcConexionBBDD.ConexionMysql"%>
<%@page import="misrcConexionBBDD.OperacionesCrud"%>
<%@page import="java.sql.Connection"%>
<%@page import="misrcConexionBBDD.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String sRadioButton = request.getParameter("bbdd");
    

    Conexion c = null;
    Connection conexion = null;

    OperacionesCrud oc = new OperacionesCrud();

    String database = "C:\\universidad\\mydatabase.universidad";
    out.println(sRadioButton);
    
    switch ("Mysql") {
        case "Mysql":
            c = new ConexionMysql(true);
            break;
        case "Postgresql":
            c = new ConexionPostgresql(true);
            break;
        case "Sqlite3":
            c = new ConexionSqlite(database);
            break;
    }
    c.setConexion(true);
    conexion = c.getConexion();
    
    if(request.getParameter("btoMostrar") != null){
        session.setAttribute("radioButton_s", sRadioButton);
        out.println(sRadioButton);
        if (conexion != null) {
            if (oc.mostrarAlumno(conexion) != null) {
                out.println("<table border='1'>");
                out.println("<tr>");
                List<Alumno> alumnos_al = oc.mostrarAlumno(conexion);
                for (int i = 0; i < alumnos_al.size(); i++) {
                    Alumno alumno = alumnos_al.get(i);

                    out.println("<th>ID</th>");
                    out.println("<th>NOMBRE Y APELLIDOS</th>");
                    out.println("<th>CARRERA</th>");
                    out.println("<th>DIRECCIÓN</th>");
                    out.println("<th>EMAIL</th>");
                    out.println("<th>EDAD</th>");
                    out.println("<th>TELEFONO</th>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<td>" + alumno.getId()+ "</td>");
                    out.println("<td>" + alumno.getNombresApellidos()+ "</td>");
                    out.println("<td>" + alumno.getCarrera() + "</td>");
                    out.println("<td>" + alumno.getDireccion() + "</td>");
                    out.println("<td>" + alumno.getEmail() + "</td>");
                    out.println("<td>" + alumno.getEdad() + "</td>");
                    out.println("<td>" + alumno.getTelefono() + "</td>");
                }
                out.println("</tr>");
                out.println("</table>");
            } else {
                out.println("ERROR MÉTODO MOSTRAR");
            }
        } else {
            out.println("ERROR CONEXION");
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
        <form action="conecta.jsp" method="post">
            
            <input type="submit" name="btoMostrar" value="MOSTRAR">
        </form>
    </body>
</html>

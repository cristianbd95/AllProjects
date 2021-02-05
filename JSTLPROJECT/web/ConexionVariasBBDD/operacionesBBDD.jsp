<%-- 
    Document   : operacionesBBDD
    Created on : 13-dic-2020, 13:50:31
    Author     : kk
--%>
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

    String sRadioButton = (String) session.getAttribute("radio_s");
    Conexion c = null;
    Connection conexion = null;

    OperacionesCrud oc = new OperacionesCrud();

    String database = "C:\\universidad\\mydatabase.universidad";
    out.println(sRadioButton);

    switch (sRadioButton) {
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

    if (request.getParameter("btoMostrar") != null) {
        session.setAttribute("radioButton_s", sRadioButton);
        if (conexion != null) {
            if (oc.mostrarAlumno(conexion) != null) {
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<th>ID</th>");
                out.println("<th>NOMBRE Y APELLIDOS</th>");
                out.println("<th>CARRERA</th>");
                out.println("<th>DIRECCIÓN</th>");
                out.println("<th>EMAIL</th>");
                out.println("<th>EDAD</th>");
                out.println("<th>TELEFONO</th>");
                out.println("</tr>");
                
                List<Alumno> alumnos_al = oc.mostrarAlumno(conexion);
                for (int i = 0; i < alumnos_al.size(); i++) {
                    Alumno alumno = alumnos_al.get(i);
                    out.println("<tr>");
                    out.println("<td>" + alumno.getId() + "</td>");
                    out.println("<td>" + alumno.getNombresApellidos() + "</td>");
                    out.println("<td>" + alumno.getCarrera() + "</td>");
                    out.println("<td>" + alumno.getDireccion() + "</td>");
                    out.println("<td>" + alumno.getEmail() + "</td>");
                    out.println("<td>" + alumno.getEdad() + "</td>");
                    out.println("<td>" + alumno.getTelefono() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } else {
                out.println("ERROR MÉTODO MOSTRAR");
            }
        } else {
            out.println("ERROR CONEXION");
        }
    }
    if (request.getParameter("btoInsertar") != null) {
        String sId = request.getParameter("txtId");
        String sNombreAp = request.getParameter("txtNombre");
        String sCarrera = request.getParameter("txtCarrera");
        String sDireccion = request.getParameter("txtDireccion");
        String sEmail = request.getParameter("txtEmail");
        String sEdad = request.getParameter("txtEdad");
        String sTelefono = request.getParameter("txtTelefono");
        if (sNombreAp.length() <= 3 || sNombreAp.length() > 55) {
            out.println("La longitud del nombre debe estar entre 2 y 55 caracteres");
%>
            <form action="operacionesBBDD.jsp" method="post">
                <center>
                    <fieldset style="width: 180px; margin-top: 100px;">
                        <legend>Alumno:</legend>
                        <input type="text" name="txtId" placeholder="Introduzca id" required><br>
                        <input type="text" name="txtNombre" placeholder="Introduzca nombre y apellidos" required><br>
                        <input type="text" name="txtCarrera" placeholder="Introduzca carrera" required><br>
                        <input type="text" name="txtDireccion" placeholder="Introduzca dirección" required><br>
                        <input type="text" name="txtEmail" placeholder="Introduzca email" required><br>
                        <input type="text" name="txtEdad" placeholder="Introduzca edad" required><br>
                        <input type="text" name="txtTelefono" placeholder="Introduzca teléfono" required><br>
                        <input type="submit" name="btoInsertar" value="INSERT">
                    </fieldset>
            </form
<%        } else {
            Alumno alumno = new Alumno(sId, sNombreAp, sCarrera, sDireccion, sEmail, Integer.parseInt(sEdad), Integer.parseInt(sTelefono));
                if (oc.crearAlumno(alumno, conexion)) {
                    out.println("ALUMNO CREADO CORRECTAMENTE");
                } else {
                    out.println("ERROR CREAR ALUMNO");
                }
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
        <form action="index.jsp" method="post">

            <input type="submit" name="btoVolver" value="Volver">
        </form>
    </body>
</html>

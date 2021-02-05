
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

    session.setAttribute("radio_s", sRadioButton);

    Conexion c = null;
    Connection conexion = null;

    OperacionesCrud oc = new OperacionesCrud();

    String database = "C:\\universidad\\mydatabase.universidad";

    switch (sRadioButton) {
        case "Mysql":
            c = new ConexionMysql(true);
            break;
        case "Postgresql":
            c = new ConexionPostgresql(true);
            break;
        case "Sqlite3":
            c = new ConexionSqlite(database);
            c.setConexion(true);
            break;
    }

    conexion = c.getConexion();

    if (conexion == null) {
        System.out.println("no hay conexion");
    } 

        if (oc.existeTabla(conexion)) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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

        </form>
        <br>
        <form action="operacionesBBDD.jsp" method="post">
            <input type="submit" name="btoMostrar" value="MOSTRAR">
        </form>
    </center>
</body>
</html><center>
    <%
    } else {
        out.println("LA TABLA NO ESTÁ CREADA, DEBERÁ CREARLA");
    %>
    <form action="index.jsp" method="post">
        <input type="submit" name="btoCrearTabla" value="Crear tabla">
    </form>
</center>
<%
        }
    
%>

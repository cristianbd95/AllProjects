
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
    if (request.getParameter("btoCrearTabla") != null) {
        Conexion c = null;
        Connection conexion = null;

        OperacionesCrud oc = new OperacionesCrud();

        String database = "C:\\universidad\\mydatabase.universidad";
        String sRadioButton = (String) session.getAttribute("radio_s");
        

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
        
        if(oc.crearTabla(conexion)){
            out.println("Tabla CREADA CORRECTAMENTE");
        }else{
            out.println("ERROR CREAR TABLA");
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
            <input type="radio" id="Mysql" name="bbdd" value="Mysql">
            <label for="Mysql">Mysql</label><br>
            <input type="radio" id="Postgresql" name="bbdd" value="Postgresql">
            <label for="Postgres">Postgresql</label><br>
            <input type="radio" id="Sqlite3" name="bbdd" value="Sqlite3">
            <label for="Sqlite3">Sqlite3</label>
            <input type="submit" name="btoEnviar">
        </form>
    </body>
</html>

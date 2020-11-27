

<%@page import="misrcAficionado.Club"%>
<%@page import="java.util.List"%>
<%@page import="misrcAficionado.OCAficionado"%>
<%@page import="java.sql.Connection"%>
<%@page import="misrcAficionado.Conexion"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String ruta = request.getContextPath() + "/aficionadoClub/imagenes";
    Conexion c = new Conexion(true);
    Connection conexion = c.getConexion();
    OCAficionado oc = new OCAficionado(conexion);
    List<Club> clubs_al = oc.guardarNombreClub();//0,1,2,3,4
    int x;
    int numero;

    if (request.getParameter("btoRandom") != null) {
        x = (int) Math.floor(Math.random() * 3 + 2);//2,3,4
        int[] numRand = new int[x];
        for ( int i=0; i<x; i++ ) {
            numero = (int) (Math.random() * 5 + 0);
            if (numRand[i] != numero) {
                numRand[i] = numero;
                break;
            }
            System.out.println(numRand[i]);
        }
        for (int i = 0; i < x; i++) {
            
            out.println(clubs_al.get(numRand[i]).getId());
        }
    }

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="aficionado.jsp" method="post">
            <input type="text" name="txtNombre" placeholder="Introduzca un Nombre">
            <input type="date" name="dateFechanac">
            <input type="text" name="txtCiudad" placeholder="Introduzca una Ciudad">
            <input type="text" name="txtEstadocivil" placeholder="Introduzca Estado Civil">
            <input type="submit" name="btoEnviar" value="Enviar">
            <input type="submit" name="btoRandom" value="Seleccionar Clubs">
            <fieldset style="width: 900px;">
                <legend>Clubs</legend>
                <label>
                    <input type="checkbox" name="club" value="1"> <img src="<%=ruta%>/barsa.png">
                </label>
                <label>
                    <input type="checkbox" name="club" value="2"> <img src="<%=ruta%>/atm.png">
                </label>
                <label>
                    <input type="checkbox" name="club" value="3"> <img src="<%=ruta%>/sevilla.png">
                </label>
                <label>
                    <input type="checkbox" name="club" value="4"> <img src="<%=ruta%>/realmadrid.png">
                </label>
                <label>
                    <input type="checkbox" name="club" value="5"> <img src="<%=ruta%>/getafe.png">
                </label>
            </fieldset>
        </form>
    </body>
</html>

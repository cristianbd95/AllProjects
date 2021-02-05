

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="misrcAficionado.Aficionado"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="misrcAficionado.Club"%>
<%@page import="java.util.List"%>
<%@page import="misrcAficionado.OCAficionado"%>
<%@page import="java.sql.Connection"%>
<%@page import="misrcAficionado.Conexion"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<fieldset style="width: 600px;">
    <legend>Clubs</legend>
    <%
        String ruta = request.getContextPath() + "/aficionadoClub/imagenes";
        Conexion c = new Conexion(true);
        Connection conexion = c.getConexion();
        OCAficionado oc = new OCAficionado(conexion);
        List<Club> clubs_al = oc.guardarNombreClub();//GUARDO EN EL ARRAYLIST LOS IDS DE LOS CLUBS DEL 0,1,2,3,4
        int x;
        
        x = (int) Math.floor(Math.random() * 3 + 2);//2,3,4
        int[] numRand = new int[x];

        //String sBotonSelect = request.getParameter("btoRandom");
        //session.setAttribute("boton_s", sBotonSelect);
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (request.getParameter("btoRandom") != null) {

            for (int i = 0; i < 5; i++) {
                list.add(new Integer(i)); //0,1,2,3,4
            }
            Collections.shuffle(list);

            for (int i = 0; i < numRand.length; i++) {
                numRand[i] = list.get(i).intValue(); // GUARDO LOS NUMEROS ALEATORIOS
            }
                session.setAttribute("rand_s", numRand);
            
            for (int i = 0; i < x; i++) { //ELIJO Y CREO LAS FOTOS DE LOS CLUBS ALEATORIAMENTE
%>    
    <img src="<%=ruta%>/<%=clubs_al.get(numRand[i]).getId()%>.png">

    <%
        }
    %>
</fieldset> 
<form action="aficionado.jsp" method="-post">
    <input type="submit" name="btoEnviar">
    <input type="text" name="txtNombre" placeholder="Introduzca un Nombre" required> 
    <input type="date" name="dateFechanac">
    <input type="text" name="txtCiudad" placeholder="Introduzca una Ciudad" required>
    <input type="text" name="txtEstadocivil" placeholder="Introduzca Estado Civil" required>
</form>  
<%
    }
    if (request.getParameter("btoEnviar") != null) {
        out.println("ENTRA");
        int[] varSesion = (int[]) session.getAttribute("rand_s");
        
        
        List<String> aficionado_al = new ArrayList<String>();
        String guardar;
        String nombre = request.getParameter("txtNombre");
        Date fechanacimiento = new Date(request.getParameter("dateFechanac"));
        String ciudad = request.getParameter("txtCiudad");
        String estadocivil = request.getParameter("txtEstadocivil");
        for (int i = 0; i < varSesion.length; i++) {
            guardar = String.valueOf(clubs_al.get(varSesion[i]).getId());
            aficionado_al.add(guardar);
        }
        for (int i = 0; i < varSesion.length; i++) {
            out.println(aficionado_al.get(i));
        }
        out.println(nombre + " " + ciudad + " " + estadocivil);
        Aficionado aficionado = new Aficionado(2, nombre, fechanacimiento, ciudad, estadocivil, aficionado_al);
        if (oc.registrarAficionado(aficionado)) {
            out.println("INSERT OK");
        } else {
            out.println("ERROR INSERT");
        }
    }

    if (request.getParameter("btoMostrar") != null) {

        List<String> mostrar_al = oc.mostrarTablaAficionado();

        for (int i = 0; i < mostrar_al.size(); i++) {
            String mostrar = mostrar_al.get(i);
            out.println(mostrar);
        }

    }

    if (request.getParameter("btoEliminar") != null) {
%> 
<form action="aficionado.jsp" method="post">

    <input type="text" name="txtEliminar" placeholder="Introduzca id a eliminar" required>
    <input type="submit" name="btoDel" value="Enviar">

</form>   
<%
    }
    if (request.getParameter("btoDel") != null) {
        String sEliminar = request.getParameter("txtEliminar");
        oc.eliminarAficionado(Integer.parseInt(sEliminar));
        out.println("Delete CORRECTO");
    }


%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="aficionado.jsp" method="post">

            <input type="submit" name="btoRandom" value="Seleccionar Clubs">
            <input type="submit" name="btoMostrar" value="Mostrar">
            <input type="submit" name="btoEliminar" value="Eliminar">

        </form>
    </body>
</html>

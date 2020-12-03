

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

<fieldset style="width: 900px;">
    <legend>Clubs</legend>
    <%
        String ruta = request.getContextPath() + "/aficionadoClub/imagenes";
        Conexion c = new Conexion(true);
        Connection conexion = c.getConexion();
        OCAficionado oc = new OCAficionado(conexion);
        List<Club> clubs_al = oc.guardarNombreClub();//0,1,2,3,4
        int x;
        x = (int) Math.floor(Math.random() * 3 + 2);//2,3,4
        int[] numRand = new int[x];
        int[] generarNums = new int[10];

        String nombre = request.getParameter("txtNombre");
        //Date fechanacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dateFechanac").trim());
        String ciudad = request.getParameter("txtCiudad");
        String estadocivil = request.getParameter("txtEstadocivil");
        List<String> aficionado_al = new ArrayList<String>();
        String guardar;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            list.add(new Integer(i)); //0,1,2,3,4
        }
        Collections.shuffle(list);
        for (int i = 0; i < x; i++) {
            numRand[i] = list.get(i).intValue();
        }
        if (request.getParameter("btoRandom") != null) {

            for (int i = 0; i < x; i++) {
    %>    
    <label>
        <input type="checkbox" name="club" value="<%=i%>"> <img src="<%=ruta%>/<%=clubs_al.get(numRand[i]).getId()%>.png">
    </label>            
    <%
            }
        }

        if (request.getParameter("btoEnviar") != null) {
            for (int i = 0; i < numRand.length; i++) {
                guardar = String.valueOf(clubs_al.get(numRand[i]).getId());
                aficionado_al.add(guardar);
            }
            for (int i = 0; i < numRand.length; i++) {
                out.println(aficionado_al.get(i));
            }
            Aficionado aficionado = new Aficionado(1, nombre, new Date(2020-10-10), ciudad, estadocivil, aficionado_al);
            if(oc.registrarAficionado(aficionado)){
                out.println("INSERT OK");
            }else{
                out.println("ERROR INSERT");
            }
        }

    %>
</fieldset> 
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

        </form>
    </body>
</html>

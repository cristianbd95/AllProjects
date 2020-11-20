<%-- 
    Document   : index.jsp
    Created on : 14-oct-2020, 10:32:46
    Author     : Campus FP
--%>

<%@page import="java.util.List"%>
<%@page import="misrc.Vehiculo"%>
<%@page import="misrc.MetodoArchivoSerial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    MetodoArchivoSerial m = new MetodoArchivoSerial();
    String ruta = "C:\\Users\\Campus FP\\Downloads\\apache-tomcat-9.0.38\\bin\\data\\vehiculo.ser";
    String sMatricula = "";
    String sMarca = "";
    String sDeposito = "";
    String sModelo = "";
    



    

%>


<%
    if (request.getParameter("btoRegistrar") != null) {
        out.println("<h3>GRABAR</h3>");
        sMatricula = request.getParameter("txtMatricula");
        sMarca = request.getParameter("txtMarca");
        sDeposito = request.getParameter("txtDeposito");
        sModelo = request.getParameter("txtModelo");

        String idVehiculo = "V";
        int cont = 000;
        cont++;
        String idV = "";
        idV = idVehiculo + cont;

        try {
            
            double dDeposito = Double.parseDouble(sDeposito);
            

            Vehiculo a = new Vehiculo(sMatricula, sMarca, dDeposito, sModelo);

            if (m.escribir(ruta, a)) {
                out.println("<h4> Grabación correcta </h4>");
            } else {
                out.println("<h4> Error de grabación </h4>");
            }
        } catch (Exception e) {
            out.println("<h4> Entrada de datos incorrecta </h4>");
        }

    }

    if (request.getParameter("btoCrear") != null) {
        out.println("<h3>CREAR</h3>");
        if (m.crear(ruta)) {
            out.println("<h4> Se creo el archivo </h4>");
        } else {
            out.println("<h4> ERROR </h4>");
        }
    }
    

    if (request.getParameter("btoMostrar") != null) {
        
        out.println("<h3>MOSTRAR</h3>");
        List<Object> vehiculos_al = m.leer(ruta);
        if(vehiculos_al != null){
            if(vehiculos_al.size()>0){
            out.println("<table border='1'>");
                out.println("<tr>");
                    out.println("<th>MATRICULA </th>");     
                    out.println("<th> MARCA</th>");
                    out.println("<th> DEPOSITO</th>");
                    out.println("<th> MODELO</th>");
                out.println("</tr>");


            for (int i = 0; i<vehiculos_al.size(); i++){
                Vehiculo vehiculo = (Vehiculo)vehiculos_al.get(i);
                out.println("<tr>");
                    out.println("<td>" + vehiculo.getMatricula() + "</td>");
                    out.println("<td>" + vehiculo.getMarca() + "</td>");
                    out.println("<td>" + vehiculo.getDeposito() + "</td>");
                    out.println("<td>" + vehiculo.getModelo() + "</td>");
                out.println("</tr>");   
            }
            out.println("</table>");
            }else{
                out.println("No hay registros");
            }
        }else{
                out.println("Error lectura");
                }
       
    }

%>





<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            fieldset{
                width: 250px;
                align: center;
                margin-left: 40%;
                margin-top: 4%;
                color: blue;
                background-color: lightblue;
                font-size:14px;
                padding:10px;
                width:250px;
                line-height:1.8;
                border: 4px solid red;
            }
            h3{
                text-decoration: underline;
                color: blue;
            }
            h4{
                color: red;
            }
        </style>
    </head>
    <body>
        <form action="index.jsp" method="post">
            <fieldset>
                <legend> Ingresar Datos: </legend>
                <p>
                    <label for="lblMatricula">Matricula</label>
                    <input type="text" name="txtMatricula" value="<%= sMatricula%>">

                    <label for="lblMarca">Marca</label>
                    <input type="text" name="txtMarca" value="<%= sMarca%>">

                    <label for="lblDeposito">Deposito</label>
                    <input type="text" name="txtDeposito" value="<%= sDeposito%>">
                    <label for="lblModelo">Modelo</label>
                    <input type="text" name="txtModelo" value="<%= sModelo%>">
                </p>
                <p>

                    <input type="submit" name="btoCrear" value="Crear">
                    <input type="submit" name="btoRegistrar" value="Registrar">
                    <input type="submit" name="btoMostrar" value="Mostrar">
                </p>
            </fieldset>

        </form>
    </body>
</html>

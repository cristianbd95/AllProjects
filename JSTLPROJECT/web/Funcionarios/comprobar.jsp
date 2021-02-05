
<%@page import="misrcFuncionario.Ingeniero"%>
<%@page import="misrcFuncionario.Secretario"%>
<%@page import="misrcFuncionario.Director"%>
<%@page import="misrcFuncionario.Autorizacion"%>
<%@page import="misrcFuncionario.Gerente"%>
<%@page import="misrcFuncionario.Funcionario"%>
<%@page import="misrcFuncionario.Controlador"%>
<%@page import="misrcFuncionario.OperacionesCrud"%>
<%@page import="java.sql.Connection"%>
<%@page import="misrcFuncionario.Conexion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Conexion c = new Conexion(true);
    Connection conexion = c.getConexion();
    OperacionesCrud oc = new OperacionesCrud();
    
    String sUsuario = (String) session.getAttribute("usuario_s");
    String sPassword = (String) session.getAttribute("password_s");

    List<String> funcionarios_al = oc.obtenerFuncionario(Integer.parseInt(sUsuario), conexion);
    
    String id = funcionarios_al.get(0);
    String nombre = funcionarios_al.get(1);
    String password = funcionarios_al.get(2);
    
    Controlador cont = new Controlador();
    Autorizacion a = new Ingeniero();
    Funcionario f = new Director();
    
    if(cont.login(a, Integer.parseInt(password), Integer.parseInt(sPassword))){
        if(nombre.equals("Gerente") || nombre.equals("Director")){
%> 
<center>
    <form action="Operaciones.jsp" method="post">

        <fieldset style="width: 450px; margin-top: 100px;">
            <legend>Crear nuevo usuario</legend>
            <input type="text" name="txtId" placeholder="Introduzca ID">
            <select name="funcionarios" id="funcionarios">
                <option id="Director" name="Director">Director</option>
                <option id="Gerente" name="Gerente">Gerente</option>
                <option id="Ingeniero" name="Ingeniero">Ingeniero</option>
                <option id="Secretario" name="Secretario">Secretario</option>
            </select>
            <input type="number" name="numPassword" placeholder="introduzca contraseña"><br><br>
            <input type="submit" name="btoEnviar" value="CREAR USUARIO"> 
            <input type="submit" name="btoMostrar" value="MOSTRAR USUARIOS">
        </fieldset>
    </form>
</center>
<%
        
        }else{
            %>
            <center>
                <form action="Operaciones.jsp" method="post">
                    <fieldset style="width: 450px; margin-top: 100px;">
                        <legend>MOSTRAR USUARIOS</legend>
                        <input type="submit" name="btoMostrar" value="MOSTRAR USUARIOS">
                    </fieldset>
                </form>
            </center>
            <%
        }
    }else{

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

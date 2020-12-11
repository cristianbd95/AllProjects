<%-- 
    Document   : index
    Created on : 11-dic-2020, 13:56:53
    Author     : Campus FP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <input type="radio" id="Postgres" name="bbdd" value="Postgres">
            <label for="Postgres">Postgres</label><br>
            <input type="radio" id="Sqlite3" name="bbdd" value="Sqlite3">
            <label for="Sqlite3">Sqlite3</label>
            <input type="submit" name="btoEnviar">
        </form>
    </body>
</html>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Estas logeado como ${usuario.getNombre()} <br><br>
        <a href="Controlador?direccion=consulta1" target="myFrame">Crear</a>
        <a href="Controlador?direccion=consulta2" target="myFrame">Leer</a>
        <a href="Controlador?direccion=consulta3" target="myFrame">Actualizar</a>
        <a href="Controlador?direccion=consulta4" target="myFrame">Eliminar</a>
        <div style="heigth:500px; width: 700px">
            <iframe name="myFrame" style="height: 500px; width: 100%;">
                
            </iframe>
        </div>
    
    </body>
</html>

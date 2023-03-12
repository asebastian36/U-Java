<%-- 
    Document   : index
    Created on : 12 mar. 2023, 17:35:21
    Author     : asebastian36
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC</h1>
        <br>
        <!-- Obtener el nombre de la aplicacion de manera dinamica -->
        <a href="${pageContext.request.contextPath}/ServletControlador">Link al servlet controlador que despliega las variables</a>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 12 mar. 2023, 17:35:21
    Author     : asebastian36
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC 2</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC 2</h1>
        <br>
        <div style="color: azul">${mensaje}</div>
        <br>
        <a href="${pageContext.request.contextPath}/ServletControlador">Link al servlet controlador sin parametros</a>
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregarVariables">Link al servlet controlador que agrega parametros</a>
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">Link al servlet controlador que lista parametros</a>

    </body>
</html>

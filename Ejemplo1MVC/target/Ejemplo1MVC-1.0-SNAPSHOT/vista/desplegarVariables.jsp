<%-- 
    Document   : desplegarVariables
    Created on : 12 mar. 2023, 17:30:36
    Author     : asebastian36
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue de variables</title>
    </head>
    <body>
        <h1>Despliegue de variables</h1>
        Variable en alcance request: ${mensaje}
        <br>
        <br>
        Variable en alcance de session:
        <br>
        <br>
        Rectangulo
        <br>
        Base: ${rectangulo.base},
        Altura: ${rectangulo.altura},
        Area: ${rectangulo.area}
        <br>
        <br>
        <a href="${pageContext.request.contextPath}">Regresar al inicio</a>
    </body>
</html>

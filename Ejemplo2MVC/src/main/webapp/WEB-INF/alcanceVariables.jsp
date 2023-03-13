<%-- 
    Document   : alcanceVariables
    Created on : 12 mar. 2023, 18:37:01
    Author     : asebastian36
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance de Variables</title>
    </head>
    <body>
        <h1>Alcance de Variables</h1>
        <br>
        Variable request:
        <br>
        Rectangulo:
        <br>
        Base: ${rectanguloRequest.base},
        Altura: ${rectanguloRequest.altura},
        Area: ${rectanguloRequest.area}
        <br>
        <br>
        Variable session:
        <br>
        Rectangulo:
        <br>
        Base: ${rectanguloSession.base},
        Altura: ${rectanguloSession.altura},
        Area: ${rectanguloSession.area}
        <br>
        <br>
        Variable application:
        <br>
        Rectangulo:
        <br>
        Base: ${rectanguloApplication.base},
        Altura: ${rectanguloApplication.altura},
        Area: ${rectanguloApplication.area}
        <br>
        <br>
        <a href="${pageContext.request.getContextPath()}">Regresar a inicio</a>
    </body>
</html>

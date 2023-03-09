<%-- 
    Document   : getterJsp
    Created on : 8 mar. 2023, 17:57:13
    Author     : asebastian36
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que lee los valores del JavaBean</title>
    </head>
    <body>
        <h1>JSP que lee los valores del JavaBean</h1>
        <%-- leer un objeto rectangulo en el alcance de session --%>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        <br>
        Valor base: <jsp:getProperty name="rectangulo" property="base" />
        <br>
        Valor altura: <jsp:getProperty name="rectangulo" property="altura" />
        <br>
        Valor del area: <jsp:getProperty name="rectangulo" property="area" />
        <br>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>

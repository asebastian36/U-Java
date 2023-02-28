<%-- 
    Document   : FondoColor
    Created on : 28 feb. 2023, 15:19:43
    Author     : asebastian36
--%>

<%--Para recuperar el color del formulario:--%>
<%
    String fondo = request.getParameter("colorFondo");
    if(fondo == null || fondo.trim().equals("")) {
        fondo = "white";
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP cambio de color</title>
    </head>
    <!<!-- expresion para cambiar el color de fondo -->
    <body bgcolor="<%=fondo%>">
        <h1>JSP cambio de color</h1>
        <br>
        Color de fondo aplicado: <%=fondo%>
        <br>
        <a href="index.html">regresar al inicio</a>
    </body>
</html>

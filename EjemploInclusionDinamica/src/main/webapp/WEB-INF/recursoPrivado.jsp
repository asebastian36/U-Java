<%-- 
    Document   : recursoPrivado
    Created on : 8 mar. 2023, 16:05:00
    Author     : asebastian36
--%>

<% 
    //  recuperamos el color que se envio en el index
    String colorFondo = request.getParameter("colorFondo");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%--aqui aplicamos el color de fondo--%>
    <body bgcolor='<%=colorFondo%>'>
    </body>
</html>

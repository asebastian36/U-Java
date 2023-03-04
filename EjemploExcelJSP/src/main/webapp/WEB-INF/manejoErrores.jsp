<%-- 
    Document   : manejoErrores
    Created on : 4 mar. 2023, 13:45:03
    Author     : asebastian36
--%>
<%@page isErrorPage="true" %>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo de Errores</title>
    </head>
    <body>
        <h1>Manejo de Errores</h1>
        <br>
        Ocurrio una excepcion: <%= exception.getMessage()%>
        <br>
        <%-- para mandar un mensaje mas detallado y sin formato --%>

        <textarea cols="30" rows="5">
            <% exception.printStackTrace(new PrintWriter(out));%>;
        </textarea>
    </body>
</html>

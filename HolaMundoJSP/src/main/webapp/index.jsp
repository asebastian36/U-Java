<%-- 
    Document   : index
    Created on : 25 feb. 2023, 22:28:22
    Author     : asebastian36
--%>

<%--
    se una directiva para remplazar el setContentType
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--se reemplaza el meta con la directiva de contentType-->
        <title>Hola mundo JSP Page</title>
    </head>
    <body>
        <h1>Hola mundo JSP Page</h1>
        <ul>
            <!--manera de imprimir informacion-->
            <li> <% out.print("HolaMundo con un scriplets"); %> </li>
            <li>${"Hola mundo con Expression Language EL"}</li>
            <li> <%= "Hola mundo con Expresiones" %> </li>
            <li> <c:out value="Hola mundo con JSTL" /> </li>
        </ul>
    </body>
</html>

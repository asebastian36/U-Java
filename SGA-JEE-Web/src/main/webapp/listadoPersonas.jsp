<%-- 
    Document   : listadoPersonas
    Created on : 22 may 2023, 15:04:36
    Author     : Angel Franco
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Listado de personas</h1>
        <ul>
            <c:forEach items="${personas}" var="persona">
                <li>${persona.nombre} ${persona.apellido}</li>
            </c:forEach>
        </ul>
    </body>
</html>

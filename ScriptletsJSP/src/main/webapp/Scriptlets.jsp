<%-- 
    Document   : Scriptlets
    Created on : 28 feb. 2023, 15:20:12
    Author     : asebastian36
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriptlets</h1>
        <br>
        <%-- Scriptlet para enviar informacion al navegador --%>
        <%
            out.print("Saludos desde un Scriptlet");
        %>

        <%-- Scriptlet para manipular los objetos implicitos (objetos ya creados) --%>
        <%
            String nombreAplicacion = request.getContextPath();
            out.print("nombre de la aplicacion: " + nombreAplicacion);
        %>
        <br>
        <%-- Scriptlet con codigo condicionado (no es una buena practica)--%>
        <%
            if(session != null && session.isNew()) {
        %>
        Se a creado una nueva sesion
        <%
            } else if(session != null) {
        %>
        Ha vuelto a iniciar sesion
        <% } %>
    </body>
</html>

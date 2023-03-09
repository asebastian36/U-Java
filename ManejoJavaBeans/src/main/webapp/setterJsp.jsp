<%-- 
    Document   : setterJsp
    Created on : 8 mar. 2023, 17:55:52
    Author     : asebastian36
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que modifica a un JavaBean</title>
    </head>
    <body>
        <h1>JSP que modifica a un JavaBean</h1>
        <%-- Definimos la instancia rectangulo de la clase creada y definimos su scope --%>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        Modificamos los atributos:        
        <br>
        <br>
        
        <%
            int baseValor = 5;
            int alturaValor = 10;
        %>
        
        <%-- aqui se cambio el valor de la base por el de baseValor --%>
        <jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>" />
        
        <%-- aqui se cambio el valor de la altura por el de alturaValor --%>
        <jsp:setProperty name="rectangulo" property="altura" value="<%=alturaValor%>" />
        
        Nuevo valor base: <%=baseValor%>
        <br>
        Nuevo valor altura: <%=alturaValor%>
        <br>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>

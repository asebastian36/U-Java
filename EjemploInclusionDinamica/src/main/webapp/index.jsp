<%-- 
    Document   : index
    Created on : 8 mar. 2023, 16:03:26
    Author     : asebastian36
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Inclusion Dinamica</title>
    </head>
    <body>
        <h1>Ejemplo Inclusion Dinamica</h1>
        <br> 
        <jsp:include page="paginas/recursoPublico.jsp" />
        <br> 
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="blue"/>
        </jsp:include>
    </body>
</html>

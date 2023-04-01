<%-- 
    Document   : clientes
    Created on : 30 mar 2023, 21:02:02
    Author     : Angel Franco
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <%-- Para usar los estilos de bootstrap--%>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <%-- link de fuente de font awesome--%>
        <script src="https://kit.fontawesome.com/1e473fdbef.js" crossorigin="anonymous"></script>

        <title>Control de clientes</title>
    </head>
    <body>
        <!-- cabecero -->
        <jsp:include page="WEB-INF/paginas/comunes/cabecero.jsp"/>
        
        <!-- botones de navegacion -->
        <jsp:include page="WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>
        
        <ul>
            <c:forEach var="cliente" items="${clientes}">
                <li>${cliente.idCliente}    ${cliente.nombre} ${cliente.apellido}</li>
                </c:forEach>
        </ul>

        <!-- pie de pagina -->
        <jsp:include page="WEB-INF/paginas/comunes/piePagina.jsp"/>
        
        <%-- para incluir el js requerido por bootstrap --%>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>

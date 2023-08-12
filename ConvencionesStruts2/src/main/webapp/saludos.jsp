<%-- 
    Document   : saludos
    Created on : 26 jul. 2023, 13:21:09
    Author     : angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- tags de struts -->
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saludos desde Struts 2</title>
    </head>
    <body>
        <!-- para acceder al atributo del action -->
        <h1><s:property value="saludos"></s:property></h1>
    </body>
</html>
